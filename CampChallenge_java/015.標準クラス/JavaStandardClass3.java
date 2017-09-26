/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author ryokato
 */
class Sample3 {
    public static void main (String[] args){
        Calendar c = Calendar.getInstance();
        c.set(2016, 10, 4, 10, 0, 0);
        
        Date d = new Date();
        d = c.getTime();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        System.out.println(d.getTime());
        System.out.println(sdf.format(d));
    }
    
}
public class JavaStandardClass3 {
    
}
