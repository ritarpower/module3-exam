package com.example.module3_exam.model;


import java.time.LocalDate;

public class PhongTro {
    private int id;
    private String name;
    private int phoneNumber;
    private LocalDate firstDate;
    private ThanhToan payment;
    private String note;

    public PhongTro(String name, int phoneNumber, LocalDate firstDate, ThanhToan payment, String note) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstDate = firstDate;
        this.payment = payment;
        this.note = note;
    }

    public PhongTro(int id, String name, int phoneNumber, LocalDate firstDate, String note, ThanhToan payment) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.firstDate = firstDate;
        this.payment = payment;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDate firstDate) {
        this.firstDate = firstDate;
    }

    public ThanhToan getPayment() {
        return payment;
    }

    public void setPayment(ThanhToan payment) {
        this.payment = payment;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
