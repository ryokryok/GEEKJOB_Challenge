/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ryokato
 */
public class JavaMethodKadai6 extends HttpServlet {
    
   ArrayList<String> arrayOrig (String id,String name,String bornDate,String adress) {
        ArrayList<String> data = new ArrayList<>();
        data.add(id);
        data.add(name);
        data.add(bornDate);
        data.add(adress);
        return data;
   }
    
    ArrayList<String> prof (String id) {
        ArrayList<String> data1 = arrayOrig("a1", "Mike", "19900101", "USA");
        ArrayList<String> data2 = arrayOrig("b2", "Gupta", "19801212", "IND");
        ArrayList<String> data3 = arrayOrig("c3", "Mikako", "19890808", "JPN");
        
        if (id.equals(data1.get(0))) {
            return data1;
        } else if (id.equals(data2.get(0))) {
            return data2;
        } else if (id.equals(data3.get(0))) {
            return data3;
        } else{
            return null;
        }
        

    }
    
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ArrayList<String> data = new ArrayList<>();
        data = prof("b2");
        out.print("name:"+ data.get(1)  + "<br>");
        out.print("birthday:" + data.get(2)  + "<br>");
        out.print("from:" + data.get(3)  + "<br>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
