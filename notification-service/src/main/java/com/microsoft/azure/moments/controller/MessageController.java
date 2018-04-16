package com.microsoft.azure.moments.controller;

import com.microsoft.azure.moments.domain.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageController.class);

    @MessageMapping("/onMessage")
    @SendTo("/topic/messages")
    public Message onMessage(Message message) {
        LOGGER.info("Received message: " + message);
        return message;
    }
}