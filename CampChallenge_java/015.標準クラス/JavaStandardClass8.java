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
class Sample8 {
    public static void main (String[] args) throws IOException{
        File fp = new File("profile.txt");
        FileWriter fw = new FileWriter(fp);
        fw.write("My name is Ryo Kato");
        fw.close();
        
    }
}
public class JavaStandardClass8 {
    
}
