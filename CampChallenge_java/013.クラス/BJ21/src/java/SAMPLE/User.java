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
public class User extends Human{
    /**
     * 設計上、Userにはdeal処理の記述はないため、dealerクラスからインスタンス生成
     * deal,hitのメソッド処理を利用
     */
    
    public void setCard(ArrayList<Integer> s){
       for(int i = 0;i < s.size();i++){
          myCards.add(s.get(i));
       }
       /**
        * 今回のゲームではhit判定後、1枚だけカードを追加処理
        * 変数countによって重複でmyCardsにカードを入れるのを避ける
        */
        
    }
        /**
         * Userルールとしてを17を超えるまでカードをヒット必要あり
         * 合計値が17以下である=true
         */
    @Override
    public boolean checkSum(){
        int checkSum =0;
        for(int i = 0; i < myCards.size();i++){
            checkSum += myCards.get(i);
        }
        return checkSum < 17;
    }
    
    @Override
    public int open(){
        int openSum =0;
        for(int i = 0; i < myCards.size();i++){
            openSum += myCards.get(i);
        }
        return openSum;
    }

    void hit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
