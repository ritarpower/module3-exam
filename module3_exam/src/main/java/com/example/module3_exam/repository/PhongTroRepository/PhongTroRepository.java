package com.example.module3_exam.repository.PhongTroRepository;

import com.example.module3_exam.model.PhongTro;
import com.example.module3_exam.model.ThanhToan;
import com.example.module3_exam.repository.BaseRepository;
import com.example.module3_exam.repository.ThanhToanRepository.IThanhToanRepository;
import com.example.module3_exam.repository.ThanhToanRepository.ThanhToanRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhongTroRepository implements IPhongTroRepository {
    private BaseRepository baseRepository= new BaseRepository();
    private IThanhToanRepository thanhToanRepository= new ThanhToanRepository();
    private final String FIND_ALL = "SELECT * FROM phong_tro JOIN thanh_toan ON phong_tro.payment_id = thanh_toan.payment_id";
    private final String ADD = "INSERT INTO phong_tro(name,phone_number,first_date, payment_id, note) VALUES(?, ?, ?, ?, ?)";

    @Override
    public List<PhongTro> findAll() {
        List<PhongTro> rooms = new ArrayList<>();
        Connection c = baseRepository.getConnection();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(FIND_ALL);
            while (rs.next()) {
                int id = rs.getInt("room_id");
                String name = rs.getString("name");
                int phoneNumber = rs.getInt("phone_number");
                LocalDate firstDate = rs.getDate("first_date").toLocalDate();
                String note = rs.getString("note");
                int paymentId = rs.getInt("payment_id");
                ThanhToan thanhToan = thanhToanRepository.findById(paymentId);
                PhongTro phongTro = new PhongTro(id, name, phoneNumber, firstDate, note, thanhToan);
                rooms.add(phongTro);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rooms;
    }

    @Override
    public void add(PhongTro phongTro) {
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(ADD);
            ps.setString(1, phongTro.getName());
            ps.setInt(2, phongTro.getPhoneNumber());
            ps.setDate(3, Date.valueOf(phongTro.getFirstDate()));
            ps.setInt(4, phongTro.getPayment().getPaymentId());
            ps.setString(5, phongTro.getNote());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
