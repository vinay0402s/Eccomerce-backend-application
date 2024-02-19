package com.example.springsecurity;

import lombok.Getter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.StringJoiner;

@RestController
@RequestMapping("/home")
public class ControllerNew {

    @GetMapping("/welcome")
    public String welcome(){
        return "Hii welcome to spring security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String admin(){
        return "You are at the Admin PAge";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String user(){
        return "You are at the   User Page";
    }

}
