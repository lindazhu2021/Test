package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.*;

public class SQLInsert {
    public static void main(String[] args) {
        login("lisi","123456");
        //login("'' or 1=1","123456");
    }
    public static void login(String name,String password){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection= JdbcUtils.getConnection();
            String sql ="select * from users where `name` =? and `password` = ?";

            statement = connection.prepareStatement(sql);
            statement.setString(1,name);
            statement.setString(2,password);
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("name="+resultSet.getString("name"));
                System.out.println("password="+resultSet.getObject("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(resultSet,statement,connection);
        }
    }
}
