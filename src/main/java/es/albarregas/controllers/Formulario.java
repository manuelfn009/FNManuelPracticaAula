/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
@WebServlet(name = "Formulario", urlPatterns = {"/Formulario"})
public class Formulario extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Formulario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Formulario</title>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/formularioStyleJ.css\">");
            out.println("</head>");
            out.println("<body>");            
            out.println("<div>");
            out.println("<h1>Datos introducidos en el formulario </h1>");
            out.println("<ul>");
            boolean correcto = true;
            if (!correcto) {
                out.println("<p>No se han introducido datos</p>");
            } else {
                Enumeration<String> parametros = request.getParameterNames();
                while (parametros.hasMoreElements()) {
                    String nombre = parametros.nextElement();
                    if (!nombre.startsWith("btn")) {
                        if (!nombre.startsWith("gustos")) {
                            out.println(nombre + " - <strong>" + request.getParameter(nombre) + "</strong><br/>");
                        } else {
                            String[] valores = request.getParameterValues(nombre);
                            for (String valor : valores) {
                                out.println(nombre + "- <strong>" + valor + "</strong><br/>");
                            }
                        }
                    }
                }
            }
            
            out.println("</div>");
            out.println("<a href=\"" + request.getContextPath() + "/index.html\">");
            out.println("<button class='buttom8'>Volver a inicio</button></a>");
            out.println("</body>");
            out.println("</html>");
        }
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
