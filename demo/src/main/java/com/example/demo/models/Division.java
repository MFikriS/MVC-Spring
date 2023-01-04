package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

//import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "tb_m_division")

public class Division {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    
    private String Name;
    @Column(name = "name") 

    public void setId(int Id){
        this.Id = Id;
    }

    public int getId(){
        return this.Id;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public String getName(){
        return this.Name;
    }

}
