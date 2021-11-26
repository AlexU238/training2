package com.u238.training.testConnections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/TestDbServlet")
public class TestDBServletConnection extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user="hbstudent";
        String pass="hbstudent";
        String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String driver="com.mysql.cj.jdbc.Driver";

        try {
            PrintWriter out = response.getWriter();

            out.println("Connecting to: "+jdbcUrl);

            Class.forName(driver);

            Connection con= DriverManager.getConnection(jdbcUrl,user,pass);
            out.println("Connection successful");
            con.close();
            out.println("Connection shut down successful");

        }catch(Exception e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
    }

}
