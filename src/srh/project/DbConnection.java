/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srh.project;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import Database.Dbconn;
/**
 *
 * @author Admin
 */
public class DbConnection implements Dbconn{
    Dbconn dbconn = new Dbconn() {};
    public static void main(String args[]){
        try {
            Connection conn = Dbconn.Connect();
             // create a statement
	     Statement stmt = conn.createStatement();
	     ResultSet rs = stmt.executeQuery("SELECT * FROM persons");
             
             while(rs.next()){
                 try{
                     System.out.println("Id: "+rs.getString(1));
                     System.out.println("LastName: "+rs.getString(2));
                     System.out.println("FirstName: "+rs.getString(3));
                     System.out.println("Address: "+rs.getString(4));
                     System.out.println("City: "+rs.getString(5));
                     System.out.println("   ");
                 }catch(Exception e){
                     System.out.println("Result Set Error:"+e);
                 }
             }
            conn.close();
        } catch(Exception e){
            System.out.println("Error1:"+e);
        }
    }

}
