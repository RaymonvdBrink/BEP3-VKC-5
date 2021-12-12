package com.registreren.registreren.user;

import com.registreren.registreren.user.dto.UserDTO;
import com.registreren.registreren.user.dto.ValidateDTO;
import com.registreren.registreren.user.email.EmailValidator;
import com.registreren.registreren.user.token.ConfirmationToken;
import com.registreren.registreren.user.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.IllformedLocaleException;

@RequiredArgsConstructor
@Service
public class UserService {

    @NonNull
    private final UserRepository userRepository;
    @NonNull
    private final EmailValidator emailValidator;
    @NonNull
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @NonNull
    private final RabbitTemplate rabbitTemplate;

    //TODO: Logic for registering user to database...
    public void registerUser(UserDTO userDTO){

        boolean isValidEmail = emailValidator.validateEmail(userDTO.getEmail());
        boolean exists = userRepository.findByEmail(userDTO.getEmail()).isPresent();

        if(!isValidEmail ){
            throw new IllegalStateException("Entered email is not valid");
        }
        else if(exists){
            throw new IllegalStateException("Entered email already exists");
        }

        String encPass = bCryptPasswordEncoder.encode(userDTO.getPassword());

        User user = new User(
                userDTO.getEmail(),
                encPass,
                userDTO.getFirstName(),
                userDTO.getLastName(),
                "USER");

        userRepository.insert(user);
        rabbitTemplate.convertAndSend("user_exchange", "post_user_key", user);
    }

    public boolean validateUser(ValidateDTO validateDTO){
        userRepository.findByEmail(validateDTO.getEmail())
                .orElseThrow(() -> new IllegalStateException("Can't find user by email"));

        return true;
    }
}