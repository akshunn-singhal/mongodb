package com.example.demo.controller;

import com.example.demo.model.UserRecord;
import com.example.demo.model.UserType;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping("/{userType}")
    public ResponseEntity<List<UserRecord>> getUsersByType(@PathVariable UserType userType) {
        log.info("user by type requested: "+ userType.name());
        List<UserRecord> user = userService.getUsersByType(userType);
        log.info("Regular users:"+user + "\n");
        log.info("Sorted:"+ userService.findUsersSortedByAggregator(userType));
        return ResponseEntity.ok(user);
    }

    @PostMapping("")
    public ResponseEntity<Void> addUser(UserRecord user) {
        log.info("Add user request: "+ user);
        userService.addUser(user);
        return ResponseEntity.noContent().build();
    }
}
