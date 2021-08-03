package com.kuang.lesson05;

import com.kuang.lesson05.utils.jdbcUtils_C3P0;
import com.kuang.lesson05.utils.jdbcUtils_DBCP;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestC3P0 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = jdbcUtils_C3P0.getConnection();
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,5);
            statement.setObject(2,"jackson");
            statement.setObject(3,"123321");
            statement.setObject(4,"123432@qq.com");
            statement.setObject(5,new java.sql.Date(new Date().getTime()));

            int num = statement.executeUpdate();
            if(num>0){
                System.out.println("插入成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils_C3P0.release(null,statement,connection);
        }
    }
}
