package com.example.module3_exam.model;

public class ThanhToan {
    private int paymentId;
    private String paymentName;

    public ThanhToan() {
    }

    public ThanhToan(int payment_id) {
        this.paymentId = payment_id;
    }

    public ThanhToan(int payment_id, String payment_name) {
        this.paymentId = payment_id;
        this.paymentName = payment_name;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentName() {
        return paymentName;
    }

    public void setPaymentName(String paymentName) {
        this.paymentName = paymentName;
    }
}
