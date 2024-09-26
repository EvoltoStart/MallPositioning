package org.easy.mallpositioning.config;

import org.easy.mallpositioning.websocket.GpsWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final GpsWebSocketHandler gpsWebSocketHandler;

    public WebSocketConfig(GpsWebSocketHandler gpsWebSocketHandler) {
        this.gpsWebSocketHandler = gpsWebSocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(gpsWebSocketHandler, "/gps-websocket")
                .setAllowedOrigins("*"); // 设置允许所有来源
    }
}

