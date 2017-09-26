/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;
/**
 *
 * @author ryokato
 */
class Sample10 {
    public static void main(String[] args) throws IOException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");
        
        File fpS = new File("log.txt");
        FileWriter fwS = new FileWriter(fpS);
        
        Date start = new Date(); //get time
        
        fwS.write(sdf.format(start) + " :実行開始"); //write time
        fwS.close();
        
        double dig = 0;
        
        for(int i = 0;i < 50 ;i++){
            if (dig >= 361d){
                break;
            } else {
                double sinResult = Math.sin(Math.toRadians(dig));
                double cosResult = Math.cos(Math.toRadians(dig));
                double tanResult = Math.tan(Math.toRadians(dig));
                System.out.println("degrees : " + dig);
                System.out.println("sin(dig) : " + sinResult);
                System.out.println("cos(dig) : " + cosResult);
                System.out.println("tan(dig) : " + tanResult);
                dig += 15d;
            }
        }
        
        Date end = new Date();
        File fpE = new File("log.txt");
        
        FileWriter fwE = new FileWriter(fpE, true);
        fwE.write(">" + sdf.format(end) + " :実行終了");
        fwE.close();
        
        File fpR = new File("log.txt");
        FileReader fr = new FileReader(fpR);
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
        br.close();
        
        
        
        
        
        
        
        
        
    }
}
public class JavaStandardClass10 {
    
}
