/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAMPLE;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ryokato
 */
public class Dealer  extends Human {
    ArrayList<Integer> cards = new ArrayList<>();
    public Dealer(){
        for (int i = 0;i < 4;i++){
            for (int k = 1;k < 14;k++){
                if (k >= 10){
                    cards.add(10);
                } else {
                    cards.add(k);             
                }
            }
 
        }
    }
    
    
    public ArrayList<Integer> deal(){
        /**
         * cardsの配列をshuffleでランダムにして、
         * 先頭から2枚のカードを定義したdrawに入れる
         */
        ArrayList<Integer> draw = new ArrayList<>();
        Collections.shuffle(cards);
        draw.add(cards.get(0));
        draw.add(cards.get(1));
        cards.remove(0);
        cards.remove(1);
        return draw;
        
    }
    public ArrayList<Integer> hit(){
        ArrayList<Integer> draw2 = new ArrayList<>();
        draw2.add(cards.get(0));
        cards.remove(0);
        return draw2;
    }
    
    @Override
    public void setCard(ArrayList<Integer> s){
       for(int i = 0;i < s.size();i++){
          myCards.add(s.get(i));
       }
        
    }
        /**
         * dealerルールとして17を超えるまでカードをヒットする必要あり
         * 合計値が17を以下である=true
         */
    @Override
    public boolean checkSum(){
        int checkSum =0;
        for(int i = 0; i < myCards.size();i++){
            checkSum += myCards.get(i);
        }
        
        if (checkSum < 17){
           return true; 
        } else {
           return false;
        }
    }
    
    @Override
    public int open(){
        int openSum =0;
        for(int i = 0; i < myCards.size();i++){
            openSum += myCards.get(i);
        }
        return openSum;
    }
    
}
