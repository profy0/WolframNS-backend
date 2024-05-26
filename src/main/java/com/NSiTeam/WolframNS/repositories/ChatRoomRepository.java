package com.NSiTeam.WolframNS.repositories;

import com.NSiTeam.WolframNS.domain.Entities.ChatRoom;
import com.NSiTeam.WolframNS.domain.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
