package com.registreren.registreren.user;

import com.registreren.registreren.user.dto.UserDTO;
import com.registreren.registreren.user.dto.ValidateDTO;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
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

    @GetMapping("/validateUser")
    public ResponseEntity<?> validateUser(@RequestBody ValidateDTO validateDTO){
        return new ResponseEntity<>(userService.validateUser(validateDTO), HttpStatus.OK);
    }
}
