package com.example.module3_exam.service;

import com.example.module3_exam.model.ThanhToan;

import java.util.List;

public interface IThanhToanService {
    List<ThanhToan> findAll();

    ThanhToan findById(int id);

    ThanhToan findByName(String name);
}
