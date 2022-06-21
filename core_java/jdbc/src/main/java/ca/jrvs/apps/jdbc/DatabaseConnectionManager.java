package ca.jrvs.apps.jdbc;

import java.util.Properties;

public class DatabaseConnectionManager {
  private final String url;
  private final Properties properties;


  /**
   * the constructor parts are attached below
   * @param host
   * @param DatabaseName
   * @param username
   * @param password
   */
  public DatabaseConnectionManager(String host, String DatabaseName,
                                    String username, String password){
    this.url = "jdbc:postgresql://"+host+"/"+databaseName;
    this.properties= new Properties();
    this.properties.setProperty("user", username);
    this.properties.setProperty("password",password);

  }

  public Connection getConnection() throws SQLException{
    return DriverManager.getConnection(this.url, this.properties);
  }


}