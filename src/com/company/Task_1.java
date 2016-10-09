package com.company;

/**
 * Created by dwarfawrrior on 7/10/2016.
 */

import java.sql.*;

/**
 *

 Таблиця Люди
 в неї
 1. id (унікальний, автогенерований)
 2. name (строка)
 3. second name (строка)
 4. birthday (дата)
 5. вік


 завдання:

 1. вивести всю інформацію про людей
 2. за допомогую селект в квері поставити умову, щоб:
 А. у яких імя Діма (вставити в базу даних трьох Дім)
 Б. у яких день народження пізніше 1 січня 1994 року (мінімум 1.)
 В. у яких вік більше 40 (мінімум 1.)


 */
public class Task_1 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "1111";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) {

        try {

            con = DriverManager.getConnection(url, user, password);

            String query  = "select * from Task_1";
            String query2 = "select * from Task_1 where name = 'Dima'";
            String query3 = "select * from Task_1 where birthday < '1994-12-31'";
            String query4 = "select * from Task_1 where age > '40'";

            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt("id");
                String name = rs.getString(2);
                String secondName = rs.getString(3);
                Date date = rs.getDate(4);
                int age = rs.getInt(5);
                System.out.println("Total number of books in the table : " + count +  " : " +  name + " : " + secondName + " : " + date + " : " + age );

            }
            System.out.println("\n\t");


            rs = stmt.executeQuery(query2);

            while (rs.next()) {
                int count = rs.getInt("id");
                String name = rs.getString(2);
                String secondName = rs.getString(3);
                Date date = rs.getDate(4);
                int age = rs.getInt(5);
                System.out.println("Total number of books in the table : " + count +  " : " +  name + " : " + secondName + " : " + date + " : " + age );

            }

            System.out.println("\n\t");

            rs = stmt.executeQuery(query3);

            while (rs.next()) {
                int count = rs.getInt("id");
                String name = rs.getString(2);
                String secondName = rs.getString(3);
                Date date = rs.getDate(4);
                int age = rs.getInt(5);
                System.out.println("Total number of books in the table : " + count +  " : " +  name + " : " + secondName + " : " + date + " : " + age );

            }
            System.out.println("\n\t");

            rs = stmt.executeQuery(query4);

            while (rs.next()) {
                int count = rs.getInt("id");
                String name = rs.getString(2);
                String secondName = rs.getString(3);
                Date date = rs.getDate(4);
                int age = rs.getInt(5);
                System.out.println("Total number of books in the table : " + count +  " : " +  name + " : " + secondName + " : " + date + " : " + age );

            }


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
