package com.kuang.lesson04;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.Callable;

public class TestTransaction1 {
    public static void main(String[] args) {
        Connection connection  =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql1 = "update account set money=money-100 where name ='A'";
            statement = connection.prepareStatement(sql1);
            statement.executeUpdate();

            int x=1/0;
            String sql2 = "update account set money=money+100 where name ='B'";
            statement = connection.prepareStatement(sql2);
            statement.executeUpdate();
            connection.commit();
            System.out.println("成功");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(null,statement,connection);
        }
    }
}
