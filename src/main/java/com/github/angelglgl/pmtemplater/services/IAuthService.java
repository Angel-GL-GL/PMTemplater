package com.github.angelglgl.pmtemplater.services;

import java.util.HashMap;
import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import com.github.angelglgl.pmtemplater.services.models.dto.LoginDTO;
import com.github.angelglgl.pmtemplater.services.models.dto.ResponseDTO;

public interface IAuthService {
    public HashMap<String, String> login(LoginDTO login) throws Exception;

    public ResponseDTO register(UsersEntity user) throws Exception;
}
