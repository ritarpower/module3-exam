package com.example.module3_exam.repository.PhongTroRepository;

import com.example.module3_exam.model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> findAll();

    void add(PhongTro phongTro);
}
