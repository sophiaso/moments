/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.azure.moments.config;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

/**
 * https://github.com/spring-cloud/spring-cloud-gateway/issues/ 252
 */
@Component
public class WebsocketUpgradeFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 10;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String upgrade = exchange.getRequest().getHeaders().getUpgrade();
        if ("WebSocket".equalsIgnoreCase(upgrade)) {
            URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);
            URI ws = UriComponentsBuilder.fromUri(requestUrl).scheme("ws").build().toUri();
            exchange.getAttributes().put(GATEWAY_REQUEST_URL_ATTR, ws);
        }
        return chain.filter(exchange);
    }
}