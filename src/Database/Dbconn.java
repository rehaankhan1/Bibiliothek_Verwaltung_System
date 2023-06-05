/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Database;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import srh.project.Books;
/**
 *
 * @author Admin
 */
public interface Dbconn {
    /* Method to connect to database */
    public static Connection Connect(){
        try {
            System.out.println("Connecting to a database");	
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/srh", "postgres", "1234");
            //conn.setAutoCommit(false);
            return conn;
        }catch(ClassNotFoundException ex){
          System.out.println("Message: " + ex.getMessage());
        }catch(Exception e){
            System.out.println("Error1:"+e);
        }
        return null;
    }
    
    public static Connection Connect2(){
        try {
            System.out.println("Connecting to a database");	
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
            //conn.setAutoCommit(false);
            return conn;
        }catch(ClassNotFoundException ex){
          System.out.println("Message: " + ex.getMessage());
        }catch(Exception e){
            System.out.println("Error1:"+e);
        }
        return null;
    }
    
    /*Method to check existing user*/
    public static int CheckUser(String user){
         
        try{
            Connection conn=Dbconn.Connect();
            Statement stmt = conn.createStatement();
            String query="SELECT * FROM ADMINISTRATOR WHERE USERNAME='"+user+"'";
            ResultSet rs = stmt.executeQuery(query);
            if(!rs.next()){
               // System.out.println("Not a current User"); 
                return 0;
            }else return 1;
        }catch(Exception e){
             System.out.println("Error1:"+e);
             return 0;
        }
        
       
    }
    
    
    public static int[] centerFrameAgain(Dimension size) {

            Dimension windowSize = size;
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = ge.getCenterPoint();

            int dx = centerPoint.x - windowSize.width / 2;
            int dy = centerPoint.y - windowSize.height / 2;    
            //setLocation(dx, dy);
            int result[]={dx, dy};
            return result;
    }
    
    
}
