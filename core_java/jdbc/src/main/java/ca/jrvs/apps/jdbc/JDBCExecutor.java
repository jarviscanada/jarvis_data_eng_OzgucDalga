package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

   public static void main(String... args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost",
            "hplussport", "postgres", "password");
        try {
            Connection connection = dcm.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");

            while (resultset.next()) {
                System.out.println(resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}