package com.company;

import javax.swing.*;
import java.sql.*;

/**
 * Simple Java program to connect to MySQL database running on localhost and
 * running SELECT and INSERT query to retrieve and add data.
 * @author Javin Paul
 */
public class Main {

    // JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "1111";

    // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String args[]) {
        String query = "select * from test";

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, user, password);
            // the mysql insert statement
            String query2 = " insert into test (name)"
                    + " values (?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = con.prepareStatement(query2);
            preparedStmt.setString (1, JOptionPane.showInputDialog(null, "name"));


            // execute the preparedstatement
            preparedStmt.execute();

            String query3 = "delete from test where id = ?";
            PreparedStatement preparedStmt1 = con.prepareStatement(query3);
            preparedStmt1.setInt(1, 432);

            // execute the preparedstatement
            preparedStmt1.execute();

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt("id");
                String name = rs.getString(2);
                System.out.println("Total number of books in the table : " + count +  " : " +  name);

            }


            System.out.println("DataBase");


        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            //close connection ,stmt and resultset here
            try { con.close(); } catch(SQLException se) { /*can't do anything */ }
            try { stmt.close(); } catch(SQLException se) { /*can't do anything */ }
            try { rs.close(); } catch(SQLException se) { /*can't do anything */ }
        }
    }

}
