import java.sql.*;

public class MyTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sql_store?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String useName = "root";
        String password ="zhudandan99+";
        Connection connection = DriverManager.getConnection(url, useName, password);
        System.out.println(connection==null);
        Statement statement = connection.createStatement();

        String sql ="SELECT * FROM shippers";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("shipper_id="+resultSet.getObject("shipper_id"));
            System.out.println("name="+resultSet.getObject("name"));
        }
        //修改
        resultSet.close();
        statement.close();
        connection.close();
    }
}
