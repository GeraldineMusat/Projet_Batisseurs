/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.Serializable;

public class Message implements Serializable{
    private static final long serialVersionUID = 8778418858108856051L;
    public String message;
    public String nom;
    
    public Message(){
        nom = "";
        message = "Bye";
    }
    
    public Message(String n, String m){
        nom = n;
        message = m;
    }
    
    @Override
    public String toString(){
        return nom + " : " + message;
     }
}
