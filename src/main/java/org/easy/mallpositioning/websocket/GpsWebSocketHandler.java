package org.easy.mallpositioning.websocket;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GpsWebSocketHandler extends TextWebSocketHandler {

    // 存储每个监控端的WebSocket会话，使用监控端ID作为键
    private final Map<Long, WebSocketSession> clientSessions = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        // 获取监控端的唯一ID（假设通过URL参数传递）
        Long monitorId = getMonitorIdFromSession(session);
        if (monitorId != null) {
            clientSessions.put(monitorId, session);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Long monitorId = getMonitorIdFromSession(session);
        if (monitorId != null) {
            clientSessions.remove(monitorId);
        }
    }

    // 发送消息给指定的监控端
    public void sendMessageToClient(Long monitorId, String message) {
        WebSocketSession session = clientSessions.get(monitorId);
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 获取监控端的唯一ID
    private Long getMonitorIdFromSession(WebSocketSession session) {
        // 假设通过WebSocket连接URL中的query参数传递，如 ws://server/gps-websocket?monitorId=123
        //websocket = new WebSocket("ws://localhost:8080/gps-websocket?monitorId=" + monitorId);
        String query = session.getUri().getQuery();
        if (query != null && query.contains("monitorId=")) {
            String monitorId= query.split("monitorId=")[1];
            return Long.parseLong(monitorId);
        }
        return null;
    }
}
