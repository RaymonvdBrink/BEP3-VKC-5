package com.registreren.registreren.user.token;

import com.mongodb.lang.NonNull;
import com.registreren.registreren.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "Token")
public class ConfirmationToken {

    @MongoId
    private Long id;

    @NonNull
    private String token;

    @NonNull
    private LocalDateTime createdAt;

    @NonNull
    private LocalDateTime expiresAt;

    @NonNull
    private LocalDateTime confirmedAt;

    //TODO: Mapping for user in mongodb?
    private User user;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User user) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.user = user;
    }
}
