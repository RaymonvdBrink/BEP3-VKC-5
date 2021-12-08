package com.registreren.registreren.user;

import com.registreren.registreren.user.dto.UserDTO;
import com.registreren.registreren.user.email.EmailValidator;
import com.registreren.registreren.user.token.ConfirmationToken;
import com.registreren.registreren.user.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
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
public class UserService implements UserDetailsService {

    @NonNull
    private final UserRepository userRepository;

    @NonNull
    private final EmailValidator emailValidator;

    @NonNull
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new IllegalStateException("Username could not be found"));
    }

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

        userRepository.save(new User(
                userDTO.getEmail(),
                encPass,
                userDTO.getFirstName(),
                userDTO.getLastName(),
                "USER"));
    }
}