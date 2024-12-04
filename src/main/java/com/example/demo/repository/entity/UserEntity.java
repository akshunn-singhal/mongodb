package com.example.demo.repository.entity;

import com.example.demo.model.UserType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Data
@Document(collection = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    private BigInteger userId;
    private String emailId;
    private String name;
    private UserType userType;
}
