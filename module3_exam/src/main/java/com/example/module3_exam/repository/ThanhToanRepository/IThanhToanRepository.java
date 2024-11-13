package com.example.module3_exam.repository.ThanhToanRepository;

import com.example.module3_exam.model.ThanhToan;

import java.util.List;

public interface IThanhToanRepository {
    List<ThanhToan> findAll();

    ThanhToan findById(int id);

    ThanhToan findByName(String name);
}
