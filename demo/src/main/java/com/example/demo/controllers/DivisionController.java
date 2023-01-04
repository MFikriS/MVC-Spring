package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.DivisionDao;
import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("division")
public class DivisionController {
    DivisionDao dDao = new DivisionDao(DBConnection.getConnection());

    @GetMapping()
    public String index(Model model){
        model.addAttribute("divisions", dDao.getAll());
        return "";
    }
}
