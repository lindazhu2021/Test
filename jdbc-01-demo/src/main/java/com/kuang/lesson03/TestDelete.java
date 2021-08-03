package com.kuang.lesson03;

import com.kuang.lesson02.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class TestDelete {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "delete from users where id=?";
            statement = connection.prepareStatement(sql);
            statement.setObject(1,4);

            int num = statement.executeUpdate();
            if(num>0){
                System.out.println("删除成功");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.release(null,statement,connection);
        }
    }
}
