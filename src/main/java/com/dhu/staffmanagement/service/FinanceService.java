package com.dhu.staffmanagement.service;

import com.dhu.staffmanagement.entity.Finance;

import java.util.List;

public interface FinanceService {

    void add(Finance finance);
    List<Finance> findAll(int page, int size);
    Finance get(int id);
    int number();
    List<Finance> findByName(String name);
}
