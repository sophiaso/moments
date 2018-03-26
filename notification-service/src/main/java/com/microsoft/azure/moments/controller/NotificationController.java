package com.microsoft.azure.moments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    @GetMapping("/get")
    public String getNotification() {
        return "Notification received";
    }
}
