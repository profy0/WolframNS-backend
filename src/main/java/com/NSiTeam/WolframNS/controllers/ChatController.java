package com.NSiTeam.WolframNS.controllers;

import com.NSiTeam.WolframNS.domain.Entities.ChatMessage;
import com.NSiTeam.WolframNS.domain.Entities.ChatNotification;
import com.NSiTeam.WolframNS.services.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage (
            @Payload ChatMessage chatMessage
    ) {
        return chatMessage;
    }
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser (
            @Payload ChatMessage chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        // add username in websocket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSenderId());
        return chatMessage;
    }

 /*   private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat")
    public void processMessage (
            @Payload ChatMessage chatMessage
        ) {
        ChatMessage savedMsg = chatMessageService.save(chatMessage);
        messagingTemplate.convertAndSendToUser(
                chatMessage.getRecipientId(), "/queue/messages",
                ChatNotification.builder()
                        .id(savedMsg.getId())
                        .senderId(savedMsg.getSenderId())
                        .recipientId(savedMsg.getRecipientId())
                        .content(savedMsg.getContent())
                        .build()
        );
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(
            @PathVariable("senderId") String senderId,
            @PathVariable("recipientId") String recipientId
    ) {
        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId, recipientId));
    }*/
}
