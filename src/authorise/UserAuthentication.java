/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package authorise;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/**
 *
 * @author Admin
 */
public interface UserAuthentication {
   public static void createUser(String username, String password,String Saltval, Connection conn){
       try {
           Statement stmt=conn.createStatement();
           String query="INSERT INTO ADMINISTRATOR(USERNAME, PASSWORD, SALTVAL) VALUES('"+username+"','"+password+"','"+Saltval+"');";
           System.out.println(query);
           stmt.executeUpdate(query);
           JOptionPane.showMessageDialog(null, "User created");
       }catch(Exception e){
             System.out.println("Error User Authentication:"+e);
        }
      
       
   } 
   
   
   public static boolean SignIn(String username, String password, Connection conn){
       try {
          Statement stmt=conn.createStatement();
          String query="SELECT * FROM ADMINISTRATOR WHERE username='"+username+"';";
          ResultSet rs=stmt.executeQuery(query);
          if(rs.next()==false) return false; 
          else{
           return PassBasedEnc.verifyUserPassword(password, rs.getString(3), rs.getString(4));
          } 
       } catch (Exception e) {
           System.out.println("Error User Authentication:"+e);
       }
       return false;
   }
   
   public static boolean checkFields(String[] fields, int length){
      for(int i=0;i<length;i++){
          //System.out.println("Field Value: "+fields[i]);
          if(fields[i].isBlank() | fields[i].isEmpty() | fields[i]==null | fields[i]=="null")
              return false;
      }
       return true;
   }
   
   
   
   
}
