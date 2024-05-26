package com.NSiTeam.WolframNS.repositories;

import com.NSiTeam.WolframNS.domain.Entities.Status;
import com.NSiTeam.WolframNS.domain.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    List<UserEntity> findAllByStatus(Status status);
}
