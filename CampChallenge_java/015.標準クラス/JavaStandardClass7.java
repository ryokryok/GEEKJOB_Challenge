/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author ryokato
 */
class Sample7 {
    public static void main (String[] args){
        String test1 = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
        String test2 = test1.replaceAll("U", "う");
        String test3 = test2.replace("I", "い");
        
        System.out.println(test3);
    }
}
public class JavaStandardClass7 {
    
}
