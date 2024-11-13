package com.example.module3_exam.service;

import com.example.module3_exam.model.ThanhToan;
import com.example.module3_exam.repository.ThanhToanRepository.IThanhToanRepository;
import com.example.module3_exam.repository.ThanhToanRepository.ThanhToanRepository;

import java.util.Collections;
import java.util.List;

public class ThanhToanService implements IThanhToanService{
    private final IThanhToanRepository thanhToanRepository = new ThanhToanRepository();

    @Override
    public List<ThanhToan> findAll() {
        return thanhToanRepository.findAll();
    }

    @Override
    public ThanhToan findById(int id) {
        return thanhToanRepository.findById(id);
    }

    @Override
    public ThanhToan findByName(String name) {
        return thanhToanRepository.findByName(name);
    }
}
