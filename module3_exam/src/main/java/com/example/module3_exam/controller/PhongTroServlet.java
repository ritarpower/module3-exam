package com.example.module3_exam.controller;

import com.example.module3_exam.model.PhongTro;
import com.example.module3_exam.model.ThanhToan;
import com.example.module3_exam.repository.ThanhToanRepository.IThanhToanRepository;
import com.example.module3_exam.service.IPhongTroService;
import com.example.module3_exam.service.IThanhToanService;
import com.example.module3_exam.service.PhongTroService;
import com.example.module3_exam.service.ThanhToanService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "PhongTroServlet", value = "")
public class PhongTroServlet extends HttpServlet {
    private  final IThanhToanService thanhToanService = new ThanhToanService();
    private final IPhongTroService phongTroService = new PhongTroService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) {
        List<ThanhToan> payments = thanhToanService.findAll();
        request.setAttribute("payments", payments);
        RequestDispatcher dispatcher = request.getRequestDispatcher("add.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<PhongTro> rooms = phongTroService.findAll();

        request.setAttribute("rooms", rooms);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                add(request,response);
                break;
            default:
                break;
        }
    }
    private void add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int phone = Integer.parseInt(request.getParameter("phone"));
        LocalDate date = LocalDate.parse(request.getParameter("date"));
        String payment = request.getParameter("payment");
        ThanhToan payment1 = thanhToanService.findByName(payment);
        String note = request.getParameter("note");
        PhongTro room = new PhongTro(name, phone, date, payment1 , note);
        phongTroService.add(room);
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}