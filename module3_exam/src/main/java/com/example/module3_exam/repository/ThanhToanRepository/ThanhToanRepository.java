package com.example.module3_exam.repository.ThanhToanRepository;

import com.example.module3_exam.model.PhongTro;
import com.example.module3_exam.model.ThanhToan;
import com.example.module3_exam.repository.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThanhToanRepository implements IThanhToanRepository{
    private BaseRepository baseRepository= new BaseRepository();
    private final String FIND_ALL = "select * from thanh_toan";
    private final String FIND_BY_ID = "select * from thanh_toan where payment_id = ?";
    private final String FIND_BY_NAME = "select * from thanh_toan where payment_name = ?";

    @Override
    public List<ThanhToan> findAll() {
        List<ThanhToan> payments = new ArrayList<>();
        Connection c = baseRepository.getConnection();
        try {
            Statement stmt = c.createStatement();
            ResultSet resultSet = stmt.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("payment_id");
                String name = resultSet.getString("payment_name");
                ThanhToan thanhToan = new ThanhToan(id, name);
                payments.add(thanhToan);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return payments;
    }

    @Override
    public ThanhToan findById(int id) {
        ThanhToan payment = null;
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement stmt = c.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("payment_name");
                payment = new ThanhToan(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return payment;
    }

    @Override
    public ThanhToan findByName(String name) {
        ThanhToan payment = null;
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement stmt = c.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("payment_id");
                payment = new ThanhToan(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return payment;
    }


}
