package com.app.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello(){
        return "Hello world";
    }

    @GetMapping("/hello-secured")
    @PreAuthorize("hasAuthority('CREATE')")
    public String helloSecured(){
        return "Hello world Secured";
    }

    @GetMapping("/hello-secured2")
    public String helloSecured2(){
        return "Hello world Secured2";
    }


    @GetMapping("/get")
    @PreAuthorize("hasAuthority('READ')")
    private String helloGet(){
        return "Hello World - GET";
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('CREATE') or hasAuthority('READ')")
    private String helloPost(){
        return "Hello World - POST";
    }

    @PutMapping("/put")
    @PreAuthorize("hasAnyAuthority('CREATE','READ')")
    private String helloPut(){
        return "Hello World - PUT";
    }

    @DeleteMapping()
    private String helloDelete(){
        return "Hello World - DELETE";
    }

    @PatchMapping
    private String helloPatch(){
        return "Hello World - PATCH";
    }
}
