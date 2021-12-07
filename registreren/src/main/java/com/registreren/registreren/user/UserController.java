package com.registreren.registreren.user;

import com.registreren.registreren.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/user")
public class UserController {

    @NonNull
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){

        try {
            userService.registerUser(userDTO);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("There was an error registering user to database", HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok("Registered user to database");
    }
}
