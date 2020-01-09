package com.platform.service;

import com.platform.entity.TokenEntity;
import com.platform.mapper.ApiTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TokenService {
    @Autowired
    private ApiTokenMapper apiTokenMapper;

    public void save(TokenEntity token) {
        apiTokenMapper.save(token);
    }

    public void update(TokenEntity token) {
        apiTokenMapper.update(token);
    }

}
