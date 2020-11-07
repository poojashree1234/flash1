package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {
 private static Connection connection;

 public static Connection getConnection() throws ClassNotFoundException {
  try {
   Class.forName("com.mysql.cj.jdbc.Driver");
   String url = "jdbc:mysql://localhost:3306/onlineshopping";
   String user = "root";
   String password = "root";

   connection = DriverManager.getConnection(url, user, password);
  } catch ( SQLException e) {
   e.printStackTrace();
  }

  return connection;
 }

}
