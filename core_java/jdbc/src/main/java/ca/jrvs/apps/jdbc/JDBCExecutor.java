package ca.jrvs.apps.jdbc;

import ca.jrvs.apps.jdbc.util.DataAccessObject;
import ca.jrvs.apps.jdbc.util.DataTransferObject;
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

            /**
            this is for getting by id and update  method
             */
          Customer customer2 = customerDao.findById(10000);
          System.out.println(customer2.getFirstName() + " " + customer2.getLastName() + " " +
              customer2.getEmail());
          customer2.setEmail("oguchi@gmail.com");
          customer2 = customerDao.update(customer2);
          System.out.println(customer2.getFirstName() + " " + customer2.getLastName() + " " +
              customer2.getEmail());

          /**
           * this is for feeleting method
           */
          Customer customer3= new Customer();
          customer3.setFirstName("John");
          customer3.setLastName("Adams");
          customer3.setEmail("jadams.wh.gov");
          customer3.setAddress("1234 Main St");
          customer3.setCity("Arlington");
          customer3.setState("VA");
          customer3.setPhone("(555) 555-9845");
          customer3.setZipCode("01234");

          Customer dbCustomer = customerDao.create(customer);
          System.out.println(dbCustomer);
          dbCustomer = customerDao.findById(dbCustomer.getId());
          System.out.println(dbCustomer);
          dbCustomer.setEmail("john.adams@wh.gov");
          dbCustomer = customerDao.update(dbCustomer);
          System.out.println(dbCustomer);
          customerDao.delete(dbCustomer.getId());



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}