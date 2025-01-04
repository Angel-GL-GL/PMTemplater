package com.github.angelglgl.pmtemplater.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import com.github.angelglgl.pmtemplater.persistence.repositories.UsersRepository;
import com.github.angelglgl.pmtemplater.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public List<UsersEntity> getAllUsers() {
        return usersRepository.findAll();
    }
}
