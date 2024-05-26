package com.NSiTeam.WolframNS.controllers;

import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
public class DemoController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHelloWithHello() {
        return ResponseEntity.ok("Hello from secure hello endpoint");
    }

    @GetMapping("/check-connection")
    public ResponseEntity<String> checkIfRemoteConnectionWorks() {
        log.severe("connected");
        return ResponseEntity.ok("you are connected to WolframNS server");
    }



}
