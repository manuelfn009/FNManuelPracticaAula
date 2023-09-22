/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author manue
 */
@WebServlet(name = "FormularioComp", urlPatterns = {"/FormularioComp"})
public class FormularioComp extends HttpServlet {

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
            out.println("<title>Servlet FormularioComp</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormularioComp at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Servlet FormularioComp</title>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/formularioCompStyleJ.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos introducidos en el formulario</h1>");
            Map<String, String> formData = new HashMap<>();
            Map<String, String[]> opcionesMap = request.getParameterMap();
            Iterator<Map.Entry<String, String[]>> itr = opcionesMap.entrySet().iterator();
            out.println("<div>");

            formData.put("usuario", request.getParameter("usuario"));
            formData.put("password", request.getParameter("password"));
            formData.put("edad", request.getParameter("edad"));
            formData.put("ec", request.getParameter("ec"));
            formData.put("afi", request.getParameter("afi"));
            formData.put("com", request.getParameter("com"));
            formData.put("sn", request.getParameter("sn"));
            formData.put("so", request.getParameter("so"));
            formData.put("digito", request.getParameter("digito"));

            out.println("<p>Usuario - <strong>" + formData.get("usuario") + "</strong></p>");
            out.println("<p>Password - <strong>" + formData.get("password") + "</strong></p>");
            out.println("<p>Edad - <strong>" + formData.get("edad") + "</strong></p>");
            out.println("<p>Estado civil - <strong>" + formData.get("ec") + "</strong></p>");
            if (opcionesMap.containsKey("afi")) {

                out.println("Aficciones - ");
                while (itr.hasNext()) {
                    Map.Entry<String, String[]> entry = itr.next();
                    String[] opciones2 = entry.getValue();

                    if (entry.getKey().contains("afi")) {
                        for (String opcion : opciones2) {
                            out.println("<strong>" + opcion + " </strong>");
                        }
                    }
                }
                out.println("<p>Comentarios - <strong>" + formData.get("com") + "</strong></p>");
                out.println("<p>Internet - <strong>" + formData.get("sn") + "</strong></p>");
                out.println("<p>Sistema Operativo - <strong>" + formData.get("so") + "</strong></p>");
                out.println("<p>Digito - <strong>" + formData.get("digito") + "</strong></p>");
                out.println("</div>");
                out.println("<a href=\"" + request.getContextPath() + "/index.html\">");
                out.println("<button class='buttom8'>Volver a inicio</button></a>");
                out.println("</body>");
                out.println("</html>");

            }
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
