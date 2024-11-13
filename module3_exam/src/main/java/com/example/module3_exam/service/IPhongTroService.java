package com.example.module3_exam.service;

import com.example.module3_exam.model.PhongTro;

import java.util.List;

public interface IPhongTroService {
    List<PhongTro> findAll();

    void add(PhongTro phongTro);
}
