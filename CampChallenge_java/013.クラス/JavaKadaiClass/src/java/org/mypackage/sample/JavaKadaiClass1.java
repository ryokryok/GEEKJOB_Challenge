/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

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
public class JavaKadaiClass1 {
    public static void main (String[] args){
        Human hito = new Human();
        hito.setHuman("Merkel", 63);
        System.out.println(hito.name);
        System.out.println(hito.age);

        
    }
}
