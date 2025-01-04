package com.github.angelglgl.pmtemplater.services;

import java.util.List;

import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;

public interface IUserService {
    public List<UsersEntity> getAllUsers();
}
