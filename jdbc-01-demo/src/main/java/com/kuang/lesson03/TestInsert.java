package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class TestInsert {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,4);
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
            JdbcUtils.release(null,statement,connection);
        }
    }
}
