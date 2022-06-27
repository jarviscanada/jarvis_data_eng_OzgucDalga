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
            CustomerDAO customerDao= new CustomerDAO(connection);

          /**
           * THIS IS FOR CREATING DATA FROM DATABASE
           */
          Customer customer = new Customer();
            customer.setFirstName("Oguchi");
            customer.setLastName("DALGA");
            customer.setEmail("oguchi@yahoo.com");
            customer.setPhone("555-444-3248");
            customer.setAddress("185 Downsview Avenue");
            customer.setCity("Toronto");
            customer.setState("ON");
            customer.setZipCode("M3M 1E7");
            customerDao.create(customer);

              /**
              this is for READING DATA FROM DATABASE
               */
            Customer customer1= customerDao.findById(135);
            System.out.println(customer1.getFirstName() + " " +customer1.getLastName());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}