package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.daos.RegionDao;
import com.example.demo.models.Region;
import com.example.demo.tools.DBConnection;

@Controller
@RequestMapping("region")
public class RegionController {
    private RegionDao rDao = new RegionDao(DBConnection.getConnection());

    // CREATE
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("regions", rDao.getAll());
        return "region/index";
    }

    // CREATE
    // GET
    @GetMapping(value = {"form"})
    public String form(Model model){
        model.addAttribute("region", new Region());
        return "region/form";
    }

    // POST
    @PostMapping("save")
    public String save(Region region){
        Boolean result = rDao.insertData(region);
        if(result){
            return "redirect:/region";
        } else {
            return "region/form";
        }
    }

    //EDIT
    //GET
    @GetMapping(value = {"edit/{id}"})
    public String updateForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("region", rDao.getById(id));
        return "region/formUpdate";
    }
    //POST
    public String update(Region region){
        Boolean result = rDao.updateData(region);
        if(result){
            return "redirect:/region";
        } else {
            return "region/updateForm";
        }
    }

    //DELETE
    @GetMapping(value = {"delete/{id}"})
    public  String delete(Region region){
        Boolean result = rDao.delete(region);
        if(result){
            return "redirect:/region";
        } else {
            return "Gagal";
        }
    }
}