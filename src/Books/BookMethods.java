/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Books;


import srh.project.DbConnection;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.Dbconn;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public interface BookMethods {
    public static void addBooks(String[] fields){
        try{
        Connection conn=Database.Dbconn.Connect2();
        String query="INSERT INTO BOOKS(ISBN, NAME, AUTHOR, PUBLISHER, PUBLISHYEAR, GENRE, PRICE, EDITION) "
                + "VALUES('"+fields[0]+"','"+fields[1]+"','"+fields[2]+"','"+fields[3]+"',"+fields[4]+",'"+fields[5]+"',"+fields[6]+",'"+fields[7]+"');";
        Statement stmt=conn.createStatement();  
        stmt.executeUpdate(query);
        JOptionPane.showMessageDialog(null, "Book Added");
        }catch(Exception e){
            System.out.println("Error while adding books: "+e);
        }
      
    }
}
