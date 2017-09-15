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
public class JavaMethodKadai8 extends HttpServlet {
   ArrayList<String> arrayOrig (String id,String name,String bornDate,String adress) {
        ArrayList<String> data = new ArrayList<>();
        data.add(id);
        data.add(name);
        data.add(bornDate);
        data.add(adress);
        return data;
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
        ArrayList<String> data1 = arrayOrig("a1", "Mike", "19900101", null);
        ArrayList<String> data2 = arrayOrig("b2", "Gupta", "19801212", "IND");
        ArrayList<String> data3 = arrayOrig("c3", "Mikako", "19890808", "JPN");
        ArrayList<ArrayList> data = new ArrayList<>();
        data.add(data1);
        data.add(data2);
        data.add(data3);
        Integer limit = 2;
        ArrayList<ArrayList> output = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            output = data.get(i);
            out.println("name:"+ output.get(1) + "<br>");
            out.println("birthday:"+ output.get(2) + "<br>");
             if (output.get(3) == null) {
                continue;
            } else {
            out.print("from:"+ output.get(3) + "<br>");  
            }
        }
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

    private String data(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
