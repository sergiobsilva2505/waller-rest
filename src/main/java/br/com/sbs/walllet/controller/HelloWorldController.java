package br.com.sbs.walllet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public ResponseEntity<Message> hello(){
        return ResponseEntity.ok().body(new Message());
    }
}
