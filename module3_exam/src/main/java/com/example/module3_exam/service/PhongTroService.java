package com.example.module3_exam.service;

import com.example.module3_exam.model.PhongTro;
import com.example.module3_exam.repository.PhongTroRepository.IPhongTroRepository;
import com.example.module3_exam.repository.PhongTroRepository.PhongTroRepository;

import java.util.Collections;
import java.util.List;

public class PhongTroService implements IPhongTroService {
    private final IPhongTroRepository phongTroRepository = new PhongTroRepository();

    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }

    @Override
    public void add(PhongTro phongTro) {
        phongTroRepository.add(phongTro);
    }
}
