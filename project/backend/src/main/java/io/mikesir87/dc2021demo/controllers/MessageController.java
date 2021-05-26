package io.mikesir87.dc2021demo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Value("${message}")
    private String message;

    @GetMapping
    public String getMessage() {
        return message;
    }
}
