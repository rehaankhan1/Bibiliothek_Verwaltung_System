/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Session;

/**
 *
 * @author Admin
 */
public class Session  {
    public boolean Loggedin;
    public String Username;
    public Session(boolean Loggedin, String Username){
        this.Loggedin=Loggedin;
        this.Username=Username;
    }
    
    public void LogOut(boolean Loggedin){
        this.Loggedin=false;
        this.Username="";
    }
    
    public boolean getStatus(){
        return Loggedin;
    }
    
    public String getUsername(){
        return Username;
    }
}
