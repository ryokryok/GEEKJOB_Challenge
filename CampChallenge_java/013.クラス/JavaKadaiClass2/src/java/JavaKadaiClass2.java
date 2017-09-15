package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryokato
 */
class Human {
    public String name = "";
    public int age = 0;
    
    public void setHuman(String n,int a){
        this.name = n;
        this.age = a;
    }
}

class President extends Human {
    public void delete() {
        this.name = null;
        this.age = 0;
        
    
}
    
}
public class JavaKadaiClass2 {
    public static void main (String[] args){
        President abe = new President();
        abe.setHuman("Shinzo Abe", 62);
        abe.delete();
        System.out.println("My name is " + abe.name + ", age is" + abe.age);
        

}
}