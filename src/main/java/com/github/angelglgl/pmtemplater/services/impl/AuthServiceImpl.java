package com.github.angelglgl.pmtemplater.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import com.github.angelglgl.pmtemplater.persistence.repositories.UsersRepository;
import com.github.angelglgl.pmtemplater.services.IAuthService;
import com.github.angelglgl.pmtemplater.services.IJWTUtilityService;
import com.github.angelglgl.pmtemplater.services.models.dto.LoginDTO;
import com.github.angelglgl.pmtemplater.services.models.dto.ResponseDTO;
import com.github.angelglgl.pmtemplater.services.models.validations.UsersValidation;

@Service
public class AuthServiceImpl implements IAuthService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private IJWTUtilityService jwtUtilityService;

    @Autowired
    private UsersValidation usersValidation;

    @Override
    public HashMap<String, String> login(LoginDTO login) throws Exception {
        try {
            HashMap<String, String> jwt = new HashMap<>();

            Optional<UsersEntity> user = usersRepository.findByUserEmail(login.getUserEmail());

            if(user.isEmpty()){
                jwt.put("error", login.getUserEmail());
                return jwt;
            } 
            
            if(verifyPassword(login.getUserPassword(), user.get().getUserPassword())){
                jwt.put("jwt", jwtUtilityService.generateJWT(user.get().getUserId()));
            } else {
                jwt.put("error", "Invalid password");
            }

            return jwt;
        }  catch (IllegalArgumentException e) {
            System.err.println("Error generating JWT: " + e.getMessage());
            throw new Exception("Error generating JWT", e);
        } catch (Exception e) {
            System.err.println("Unknown error: " + e.toString());
            throw new Exception("Unknown error", e);
        }
    }

    @Override
    public ResponseDTO register(UsersEntity user) throws Exception {
        try {
            ResponseDTO response = usersValidation.validate(user);

            if(response.getNumOfErrors() > 0){
                return response;
            }
            
            List<UsersEntity> users = usersRepository.findAll();

            for (UsersEntity userEntity: users) {
                if(userEntity != null){
                    response.setNumOfErrors(1);
                    response.setMessage("User already exists");
                    return response;
                }
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
            user.setUserPassword(encoder.encode(user.getUserPassword()));

            usersRepository.save(user);

            response.setMessage("User registered successfully");
            return response;
        } catch (Exception e) {
            throw new Exception(e.toString());
        }
    }

    private boolean verifyPassword(String password, String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(password, hashedPassword);
    }
}
