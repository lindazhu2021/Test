package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JdbcUtils.getConnection();
            //String sql = "select * from users where id= ?";
            String sql ="select * from users where `name` =? and `password` = ?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"lisi");
            statement.setObject(2,"123456");
            resultSet = statement.executeQuery();
            while(resultSet.next()){
                System.out.println(resultSet.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(resultSet,statement,connection);
        }
    }
}
