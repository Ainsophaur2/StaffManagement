package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.Administration;

import java.sql.Date;
import java.util.List;
import java.util.Map;

public interface AdministrationService {

    void add(Administration administration);
    List<Administration> findAll(int page, int size);
    Administration get(int id);
    int number();

    List<Administration> findByName(String name);

}
