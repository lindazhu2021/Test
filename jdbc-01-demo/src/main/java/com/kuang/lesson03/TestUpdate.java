package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "update users set name=? where id=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,"小白");
            statement.setObject(2,1);

            int num = statement.executeUpdate();
            if(num>0){
                System.out.println("更新成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(null,statement,connection);
        }
    }
}
