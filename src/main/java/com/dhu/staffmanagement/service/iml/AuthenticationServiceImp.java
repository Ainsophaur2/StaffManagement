package com.dhu.staffmanagement.service.iml;

import com.dhu.staffmanagement.dao.AuthenticationDao;
import com.dhu.staffmanagement.entity.Authentication;
import com.dhu.staffmanagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthenticationServiceImp implements AuthenticationService {
    @Autowired
    AuthenticationDao dao;
    @Override
    public List<Authentication> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}
