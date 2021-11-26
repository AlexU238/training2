package com.u238.training.testConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {



    public static void main(String[] args) {
        String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user="hbstudent";
        String pass="hbstudent";
        try {
            System.out.println("Connecting to: "+jdbcUrl);
            Connection con= DriverManager.getConnection(jdbcUrl,user,pass);
            System.out.println("Connection successful");
            con.close();
            System.out.println("Connection shut down successful");
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }
}
