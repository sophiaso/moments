/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.moments.controller;

import com.microsoft.azure.moments.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @GetMapping("/get")
    public String getMessage() {
        return "Message received";
    }

    @GetMapping("/admin/get")
    public String getAdminMessage() {
        return "Admin message received";
    }

    @MessageMapping("/onMessage")
    @SendTo("/topic/messages")
    public Message onMessage(Message message) {
        LOGGER.info("Received message: " + message);
        return message;
    }

}
