package com.github.angelglgl.pmtemplater.services;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;

public interface IJWTUtilityService {
    public String generateJWT(Long id) 
    throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
            JOSEException;

    public JWTClaimsSet parseJWT(String jwt)
    throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, 
            JOSEException, ParseException;
}
