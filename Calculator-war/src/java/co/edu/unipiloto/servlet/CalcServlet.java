/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.servlet;

import co.edu.unipiloto.sessionBEAN.CalcBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Paula Sabogal
 */
public class CalcServlet extends HttpServlet {

    @EJB
    private CalcBeanLocal calcBean;

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
        try (PrintWriter out = response.getWriter()) {

            int v1 = Integer.parseInt(request.getParameter("val1"));
            int v2 = Integer.parseInt(request.getParameter("val2"));
            String operador = request.getParameter("oper");
            String resultado = "";

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href='css/style.css' rel='stylesheet'>");
            out.println("<title>Servlet CalcServlet</title>");
            out.println("</head>");
            out.println("<body>");
            switch (operador) {

                case "+":
                    resultado = calcBean.addition(v1, v2) + "";
                    break;
                case "-":
                    resultado = calcBean.subtraction(v1, v2) + "";
                    break;
                case "*":
                    resultado = calcBean.multiplication(v1, v2) + "";
                    break;
                case "/":
                    resultado = calcBean.division((double) v1, (double) v2) + "";
                    break;
                case "%":
                    resultado = calcBean.module((double) v1, (double) v2) + "";
                    break;
                case "^":
                    resultado = calcBean.power(v1, v2) + "";
                    break;

            }
            out.println("<div class='main'>");
            out.println("<table class='calculadora'>");
            out.println("<td colspan=4><p class='screen'>" + v1 + " " + operador + " " + v2 + "<br>" + "= " + resultado + "</p></td>");
            out.println("<tr>");
            out.println("<td><input class='button' type='button' value='C'></td>");
            out.println("<td><input class='button' type='button' value='^'></td>");
            out.println("<td><input class='button' type='button' value='/'></td>");
            out.println("<td><input class='button' type='button' value='*'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input class='button' type='button' value='7'></td>");
            out.println("<td><input class='button' type='button' value='8'></td>");
            out.println("<td><input class='button' type='button' value='9'></td>");
            out.println("<td><input class='button' type='button' value='-'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input class='button' type='button' value='4'></td>");
            out.println("<td><input class='button' type='button' value='5'></td>");
            out.println("<td><input class='button' type='button' value='6'></td>");
            out.println("<td><input class='button' type='button' value='+'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><input class='button' type='button' value='1'></td>");
            out.println("<td><input class='button' type='button' value='2'></td>");
            out.println("<td><input class='button' type='button' value='3'></td>");
            out.println("<td><input class='button' type='button' value='%'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=2><input class='button' style='width:167px' type='button' value='0'></td>");
            out.println("<td><input class='button' type='button' value='.'></td>");
            out.println("<td><input class='button' type='button' value='='></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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

}
