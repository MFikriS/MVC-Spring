package com.example.demo.daos;

import java.sql.*;
import java.util.*;
import com.example.demo.models.Division;
import com.example.demo.models.Region;

public class DivisionDao {
    private Connection con;

    public DivisionDao(Connection connection){
        this.con = connection;
    }

    public List<Division> getAll(){
        List<Division> divisions = new ArrayList<>();
        String query = "Select * from tb_m_division";
        try{
            ResultSet resultSet = con.prepareStatement(query).executeQuery();
            while (resultSet.next()){
                Division division = new Division();
                division.setId(resultSet.getInt(1));
                division.setName(resultSet.getString(2));
                division.setRegion(resultSet.getObject(3, region.getName()));
                divisions.add(division);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return divisions;
    }

    public Division getById(int id) {
        Division division = new Division();
        String query = "SELECT * FROM tb_m_division WHERE Id = ?";
        try {
            PreparedStatement prepareStatement = con.prepareStatement(query);
            prepareStatement.setInt(1, id);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                division.setId(resultSet.getInt(1));
                division.setName(resultSet.getString(2));
                division.setRegionId(resultSet.getInt(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }

    public boolean insertData(Division division){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Insert INTO tb_m_division(Name, RegionId) values(?,?)");
            preparedStatement.setString(1, division.getName());
            preparedStatement.setInt(2, division.getRegionId());
            int temp = preparedStatement.executeUpdate();
            return temp > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateData(Division division){
        try {
            String query = "Update tb_m_division SET Id = ?, Name = ? WHERE Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getId());
            preparedStatement.setString(2, division.getName());
            preparedStatement.setInt(3, division.getId());
            int temp = preparedStatement.executeUpdate();
            return temp > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteData(Integer id){
        try {
            String query = "Delete from tb_m_division where Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int temp = preparedStatement.executeUpdate();
            return temp > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}

