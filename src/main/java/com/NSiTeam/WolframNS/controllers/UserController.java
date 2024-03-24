package com.NSiTeam.WolframNS.controllers;

import com.NSiTeam.WolframNS.domain.Entities.UserEntity;
import com.NSiTeam.WolframNS.domain.dto.UserDto;
import com.NSiTeam.WolframNS.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

@RestController
@AllArgsConstructor
@Log
public class UserController {

    private UserService userService;


    @GetMapping("/user/me")
    public ResponseEntity<UserEntity> getInfoAboutUserById(
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        Optional<UserEntity> foundUserEntity = userService.findByUsername(userDetails.getUsername());

        return foundUserEntity.map(userEntity -> {
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/users")
    public List<UserEntity> listUsers() {
        List<UserEntity> users = userService.findAll();
        log.severe("LIST OF USERS ARE AVAILABLE");
        return users;
    }

    @GetMapping("/user/hello")
    public String printHelloUser(
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        Optional<UserEntity> userEntity = userService.findByUsername(userDetails.getUsername());
        return "Hello, " + userEntity.get().getFirstname();
    }



}
