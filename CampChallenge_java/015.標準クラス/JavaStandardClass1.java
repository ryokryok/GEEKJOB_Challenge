/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author ryokato
 */
class Sample {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016, 0, 1, 0, 0, 0);
        Date d = new Date();
        d = c.getTime();
        System.out.println(d);
        System.out.println(d.getTime());
        
        
    }
}
public class JavaStandardClass1 {
    
}
