/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ryokato
 */
class Sample4 {
    public static void main(String[] args){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date dateTo = null;
        Date dateFrom = null;
        try {
            dateTo = sdf.parse("2015/01/01 00:00:00");
            dateFrom = sdf.parse("2015/12/31 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long dateTimeTo = dateTo.getTime();
        long dateTimeFrom = dateFrom.getTime();
        
        long dayDiff = (dateTimeFrom - dateTimeTo);
        
        System.out.println(dateFrom + "-" + dateTo + "=");
        System.out.println(dayDiff);
        
        
        
    }
}
public class JavaStandardClass4 {
    
}
