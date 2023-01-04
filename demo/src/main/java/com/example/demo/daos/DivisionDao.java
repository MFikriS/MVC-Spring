package com.example.demo.daos;

import java.sql.*;
import java.util.*;
import com.example.demo.models.Division;

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
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return divisions;
    }

    public boolean insertData(Division division){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("Insert INTO tb_m_division(Id, Name) values(?,?)");
            preparedStatement.setInt(1, division.getId());
            preparedStatement.setString(2, division.getName());
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

    public boolean deleteData(Division division){
        try {
            String query = "Delete from tb_m_division where Id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, division.getId());
            int temp = preparedStatement.executeUpdate();
            return temp > 0;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }


}

