package com.NSiTeam.WolframNS.repositories;

import com.NSiTeam.WolframNS.domain.Entities.ChatMessage;
import com.NSiTeam.WolframNS.domain.Entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, String> {
    List<ChatMessage> findByChatId(String s);
}
