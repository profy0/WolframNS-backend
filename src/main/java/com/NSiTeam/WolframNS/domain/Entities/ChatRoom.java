package com.NSiTeam.WolframNS.domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "privateChat")
public class ChatRoom {
    @Id
    private String id;
    private String chatId;
    private String senderId;
    private String recipientId;
}
