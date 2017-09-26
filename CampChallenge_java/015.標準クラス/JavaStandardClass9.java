/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

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
class Sample9 {
    public static void main (String[] args) throws IOException{
        File fp = new File("profile.txt");
        FileReader fr = new FileReader(fp);
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br.readLine());
        br.close();
    }
}
public class JavaStandardClass9 {
    
}
