/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author manue
 */
@WebServlet(name = "NVecesSesion", urlPatterns = {"/NVecesSesion"})
public class NVecesSesion extends HttpServlet {

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
            out.println("<title>Servlet NVecesSesion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<input class=\"btn\" type=\"submit\" name=\"Recargar\" value=\"Recargar\">");
            out.println("<input class=\"btn\" type=\"submit\" name=\"volver\" value=\"Menu inicial\">");
            out.println("</form>");
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
    HttpSession session;
    int visitas = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NVecesSesion</title>");
            out.println("</head>");
            out.println("<body>");
            session = request.getSession(true);

            Date fechaCreacion = new Date(session.getCreationTime());
            Date ultimoAcceso = new Date(session.getLastAccessedTime());
            out.println("ID de la sesion: <strong>" + session.getId() + "</strong></h3><br>");
            out.println("Fecha de creacion: <strong>" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(fechaCreacion) + "</strong></h3><br>");
            out.println("Numero de visitas: <strong>" + visitas + "</strong></h3><br>");
            out.println("Último acceso: <strong>" + new SimpleDateFormat("dd-MM-yyyy HH:mm").format(ultimoAcceso) + "</strong></h3><br>");
            out.println("<form method=\"post\" action=\"NVecesSesion\">");
            out.println("<input class=\"btn\" type=\"submit\" name=\"Recargar\" value=\"Recargar\">");
            out.println("</form>");
            out.println("<a href=\"" + request.getContextPath() + "/index.html\">");
            out.println("<button class='buttom8'>Volver a inicio</button>");
            out.println("</a>");
            out.println("</body>");
            out.println("</html>");
        }
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NVecesSesion</title>");
            out.println("</head>");
            out.println("<body>");
            if (request.getMethod().equals("POST")) {
                if (request.getParameter("Recargar") != null) {
                    visitas++; // Incrementar el contador de visitas
                }else if(request.getParameter("Recargar") != null && request.getParameter("chckbx") != null){
                    visitas = 0;
                }
                out.println("Numero de visitas: <strong>" + visitas + "</strong></h3><br>");
                out.println("<form method=\"post\" action=\"NVecesSesion\">");
                out.println("Borrar sesión <input class=\"chckbx\" type=\"checkbox\" name=\"chckbx\" >");
                out.println("<input class=\"btn\" type=\"submit\" name=\"Recargar\" value=\"Recargar\">");
                out.println("</form>");
                out.println("<a href=\"" + request.getContextPath() + "/index.html\">");
                out.println("<button class='buttom8'>Volver a inicio</button>");
                out.println("</a>");
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
