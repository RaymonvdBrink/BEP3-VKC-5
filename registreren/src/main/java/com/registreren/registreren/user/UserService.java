package com.registreren.registreren.user;

import com.registreren.registreren.user.dto.UserDTO;
import com.registreren.registreren.user.token.ConfirmationToken;
import com.registreren.registreren.user.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.IllformedLocaleException;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    @NonNull
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalStateException("Username could not be found"));
    }

    //TODO: Logic for registering user to database...
    public void registerUser(UserDTO userDTO){

    }

}
