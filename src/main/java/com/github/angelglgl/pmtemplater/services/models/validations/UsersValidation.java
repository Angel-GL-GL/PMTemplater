package com.github.angelglgl.pmtemplater.services.models.validations;

import com.github.angelglgl.pmtemplater.persistence.entities.UsersEntity;
import com.github.angelglgl.pmtemplater.services.models.dto.ResponseDTO;

public class UsersValidation {
    public ResponseDTO validate(UsersEntity user){
        ResponseDTO response = new ResponseDTO();

        response.setNumOfErrors(0);

        if(user.getUserFirstname() == null || 
            user.getUserFirstname().length() < 3 ||
            user.getUserFirstname().length() > 30){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Name is required, must be between 3 and 30 characters");
        }

        if(user.getUserLastname() == null || 
            user.getUserLastname().length() < 3 ||
            user.getUserLastname().length() > 30){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Lastname is required, must be between 3 and 30 characters");
        }

        if(user.getUserRole() == null || 
            user.getUserRole().length() < 5 ||
            user.getUserRole().length() > 20){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Role is required, must be between 3 and 20 characters");
        }

        if(user.getUserEmail() == null || 
            !user.getUserEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Email is required, must be a valid email");
        }

        if(user.getUserPassword() == null || 
            !user.getUserPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{20,100}$")){
            response.setNumOfErrors(response.getNumOfErrors() + 1);
            response.setMessage("Password is required, must be between 20 and 100 characters");
        }

        return response;
    }
}
