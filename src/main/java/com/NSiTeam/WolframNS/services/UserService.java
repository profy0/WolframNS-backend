package com.NSiTeam.WolframNS.services;

import com.NSiTeam.WolframNS.domain.Entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<UserEntity> findById(Long id);

    Optional<UserEntity> findByUsername(String username);

    List<UserEntity> findAll();
}
