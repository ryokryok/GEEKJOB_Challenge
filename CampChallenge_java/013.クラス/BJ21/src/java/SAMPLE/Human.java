/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMPLE;

import java.util.ArrayList;

/**
 *
 * @author ryokato
 */
public abstract class Human {
    abstract public int open();
    abstract public void setCard(ArrayList<Integer> list);
    abstract public boolean checkSum();
    public ArrayList<Integer> myCards = new ArrayList<>(); 
    
    
}
