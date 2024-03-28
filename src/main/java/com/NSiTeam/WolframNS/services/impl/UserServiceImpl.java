package com.NSiTeam.WolframNS.services.impl;

import com.NSiTeam.WolframNS.domain.Entities.UserEntity;
import com.NSiTeam.WolframNS.repositories.UserRepository;
import com.NSiTeam.WolframNS.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<UserEntity> findByUsername(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }
}
