package com.NSiTeam.WolframNS.services;

import com.NSiTeam.WolframNS.domain.Entities.ChatMessage;
import com.NSiTeam.WolframNS.repositories.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        var chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(),
                chatMessage.getRecipientId(),
                true
        ).orElseThrow();
        chatMessage.setChatId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages (
            String senderId,
            String recipientId
    ) {
        var chatId = chatRoomService.getChatRoomId(
                senderId,
                recipientId,
                false);
        return chatId.map(chatMessageRepository::findByChatId).orElse(new ArrayList<>());
    }

}
