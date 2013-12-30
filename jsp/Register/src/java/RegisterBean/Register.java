/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package RegisterBean;

/**
 *
 * @author josephstalin
 */
public class Register {
    String username="",password="",email="";
    String backNews;
    
    public void setUsername(String name){
        username=name;
    }
    public String getUsername(){
        return username;
    }
    public void setPassword(String pw){
        password=pw;
    }
    public String getPassword(){
        return password;
    }
    public void setEmail(String em){
        email=em;
    }
    public String getEmail(){
        return email;
    }
    public String getBackNews(){
        return backNews;
    }
    public void setBackNews(String s){
        backNews=s;
    }
}
