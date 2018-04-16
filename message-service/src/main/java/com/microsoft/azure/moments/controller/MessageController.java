/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.moments.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @GetMapping("/get")
    public String getMessage() {
        return "Message received";
    }

    @GetMapping("/admin/get")
    public String getAdminMessage() {
        return "Admin message received";
    }
}
