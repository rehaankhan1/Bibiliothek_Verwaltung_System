/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package srh.project;


import Database.Dbconn;
import java.beans.Statement;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class Books implements Dbconn {
    public String ISBN;
    public String Name;
    public String Author;
    public String Publisher;
    public int PubliserYear;
    public String Genre;
    public int Price;
    public String Edition;
    
    public Books(String ISBN, String Name, String Author, String Publisher, int PublisherYear, String Genre, int Price, String Edition){
        this.ISBN=ISBN;
        this.Name=Name;
        this.Author=Author;
        this.Publisher=Publisher;
        this.PubliserYear=PublisherYear;
        this.Genre=Genre;
        this.Price=Price;
        this.Edition=Edition;
    }
    
    public String getISBN(){return this.ISBN;}
    public String getName(){return this.Name;}
    public String getAuthor(){return this.Author;}
    public String getPublisher(){return this.Publisher;}
    public int getPubliserYear(){return this.PubliserYear;}
    public String getGenre(){return this.Genre;}
    public int getPrice(){return this.Price;}
    public String getEdition(){return this.Edition;}
    
    
    public ArrayList<Books> getBooks(){
        Connection conn=Dbconn.Connect2();
        ArrayList<Books> books=new ArrayList<Books>();
        //Statement stmt;
        ResultSet rs;
        Books b;
        try{
            
             java.sql.Statement stmt = conn.createStatement();
             rs=stmt.executeQuery("SELECT * FROM BOOKS ORDER BY id DESC");
             while(rs.next()){
                 b=new Books(
                         rs.getString("ISBN"),
                         rs.getString("Name"),
                         rs.getString("Author"),
                         rs.getString("Publisher"),
                         rs.getInt("PublishYear"),
                         rs.getString("Genre"),
                         rs.getInt("Price"),
                         rs.getString("Edition")
                 );
                books.add(b);
             }
        }catch(Exception e){
            System.out.println("Cannot Read : "+e);
        }
        return books;
    }
    
     public ArrayList<Books> getBookResult(String id, String searchTxt){
        Connection conn=Dbconn.Connect2();
        ArrayList<Books> books=new ArrayList<Books>();
        //Statement stmt;
        ResultSet rs;
        Books b;
        try{
            
             java.sql.Statement stmt = conn.createStatement();
                String query="";
             if(id=="PublishYear")
                  query="SELECT * FROM BOOKS WHERE "+id+"="+searchTxt+""+" ORDER BY id DESC";
             else if(id=="Price")
                  query="SELECT * FROM BOOKS WHERE "+id+"="+searchTxt+""+" ORDER BY id DESC";
              else if(id=="isbn")
                  query="SELECT * FROM BOOKS WHERE "+id+"='"+searchTxt+"'"+" ORDER BY id DESC";
               else if(id=="LessThanPrice")
                  query="SELECT * FROM BOOKS WHERE price <="+searchTxt+""+" ORDER BY price DESC";
             else
                 query="SELECT * FROM BOOKS WHERE "+id+" LIKE '%"+searchTxt+"%'"+" ORDER BY id DESC";
             System.out.println(query);
             rs=stmt.executeQuery(query);
             while(rs.next()){
                 b=new Books(
                         rs.getString("ISBN"),
                         rs.getString("Name"),
                         rs.getString("Author"),
                         rs.getString("Publisher"),
                         rs.getInt("PublishYear"),
                         rs.getString("Genre"),
                         rs.getInt("Price"),
                         rs.getString("Edition")
                 );
                books.add(b);
             }
        }catch(Exception e){
            System.out.println("Cannot Read : "+e);
        }
        return books;
    }
    
    
    public void showData(ArrayList<Books> books){
       for(int i=0;i<books.size();i++){
            System.out.println(books.get(i).getISBN());
       } 
    }
    
    
    
}
