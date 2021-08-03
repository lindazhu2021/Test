package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection= JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql ="select * from shippers";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("shipper_id="+resultSet.getObject("shipper_id"));
                System.out.println("name"+resultSet.getObject("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(resultSet,statement,connection);
        }
    }
}
