package com.kuang.lesson02;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInsert {
    public static void main(String[] args) {
        //login("lisi","123456");
        login(" 'or '1=1"," 'or '1=1");
    }
    public static void login(String name,String password){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection= JdbcUtils.getConnection();
            statement = connection.createStatement();
            String sql ="select * from users where name='"+name+"' and password='"+password+"'";
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
