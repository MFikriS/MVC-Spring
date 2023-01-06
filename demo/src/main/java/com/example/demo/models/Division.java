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
    private Integer Id;

    @Column(name = "name", nullable = false) 
    private String Name;

    @Column(name = "regionId")
    private Integer RegionId;

    @Column(name = "regionName")
    private String RegionName;

    public void setId(Integer id){
        Id = id;
    }

    public Integer getId(){
        return Id;
    }

    public void setName(String name){
        Name = name;
    }

    public String getName(){
        return Name;
    }

    public void setRegionId(Integer regionId){
        RegionId = regionId;
    }

    public Integer getRegionId(){
        return RegionId;
    }

    public void setRegionName(String regionName){
        RegionName = regionName;
    }

    public String getRegionName(){
        return RegionName;
    }
}
