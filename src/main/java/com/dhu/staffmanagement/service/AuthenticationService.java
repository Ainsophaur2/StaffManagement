package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.Authentication;

import java.util.List;

public interface AuthenticationService {
    public List<Authentication> findByUserId(int userId);
}
