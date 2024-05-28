package com.NSiTeam.WolframNS.controllers;

import com.NSiTeam.WolframNS.domain.Entities.UserEntity;
import com.NSiTeam.WolframNS.domain.dto.UserDto;
import com.NSiTeam.WolframNS.responses.UserResponse;
import com.NSiTeam.WolframNS.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@AllArgsConstructor
@Log
public class UserController {

    private UserService userService;


    @MessageMapping("/user.addUser")
    @SendTo("/user/public")
    public UserEntity addUser (
            @Payload UserEntity userEntity
    ) {
        userService.saveUser(userEntity);
        log.severe("SAVEDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        return userEntity;
    }

    @MessageMapping("/user.disconnectedUser")
    @SendTo("/user/public")
    public UserEntity disconnect (
            @Payload UserEntity userEntity
    ) {
        userService.disconnect(userEntity);
        return userEntity;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findConnectedUsers() {
        log.severe("IT WAS CALLED");
        return ResponseEntity.ok(userService.findConnectedUsers());
    }

    @GetMapping("/user/me")
    public ResponseEntity<UserResponse> getInfoAboutUserById(
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        Optional<UserEntity> foundUserEntity = userService.findByUsername(userDetails.getUsername());

        log.severe("profile requested");

        if(foundUserEntity.isPresent()) {
            UserResponse userResponse = UserResponse.builder()
                .firstname(foundUserEntity.get().getFirstname())
                .lastname(foundUserEntity.get().getLastname())
                .email(foundUserEntity.get().getEmail())
                .build();
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/users/all")
    public Integer listUsers() {
        List<UserEntity> users = userService.findAll();
      //  log.severe("LIST OF USERS ARE AVAILABLE");
        return users.size();
    }

    @GetMapping("/user/hello")
    public String printHelloUser(
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        Optional<UserEntity> userEntity = userService.findByUsername(userDetails.getUsername());
        return "Hello, " + userEntity.get().getFirstname();
    }



}
