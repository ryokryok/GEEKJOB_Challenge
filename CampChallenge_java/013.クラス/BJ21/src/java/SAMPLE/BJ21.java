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

        
public class BJ21 {
    public static void main(String[] args){
        Dealer gameD = new Dealer();
        ArrayList<Integer> cardsD = gameD.deal();
        gameD.setCard(cardsD);
        if (gameD.checkSum()) {
            ArrayList<Integer> hitD = gameD.hit();
            gameD.setCard(hitD);
        } else {
        }
        
        int pointD = gameD.open();
        int diffD = 21 - pointD;
        
        System.out.println("Dealer point:" + pointD);
        
        User gameU = new User ();
        ArrayList<Integer> cardsU = new ArrayList<>();
        cardsU = gameD.deal();
        gameU.setCard(cardsU);
        if (gameU.checkSum()) {
            ArrayList<Integer> hitU = gameD.hit();
            gameD.setCard(hitU);   
        } else {
        }
        
        int pointU = gameU.open();
        int diffU = 21 - pointU;
        
        System.out.println("User point:" + pointU);
        
        
        /**
         * 勝敗判定その1。どちらかが21を超えてしまった場合
         */
        if (pointD > 21 || pointU > 21){
            if (pointD > 21 && pointU > 21){
                System.out.println("お互い21を超えたのでDealerとUserは引き分けです。");
            } else if(pointD >21) {
                System.out.println("Dealerがオーバー。よってUserの勝利。");
            } else {
                // pointU > 21
                System.out.println("Userがオーバー。よってDealerの勝利。");
            }
        /**
         * 勝敗判定その2。
         * 両者とも21以下の場合、21との差、diffD と diffUを比較してより小さい方が勝利
         */
        } else if(diffD < diffU){
            System.out.print("21により近いDealerの勝利です");
            
        } else if(diffD > diffU){
            System.out.print("21により近いUserの勝利です");
        } else {
            System.out.print("お互い21なので引き分けです");
        }

        
        
        
    }
    
    
}
