/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsi.web;

/**
 *
 * @author mateu
 */
public class Student {
    private String name;
    private String lastname;
    private String email;
    
    public Student(String name, String lastname, String email){
        this.name = name;
        this.lastname = lastname;
        this.email = email;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getLastName(){
        return this.lastname;
    }
    public void setLastName(String lastname){
        this.lastname = lastname;
    }
    
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}