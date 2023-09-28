package es.albarregas.controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
@WebServlet(urlPatterns = {"/Registro"})
public class Registro extends HttpServlet {

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
            out.println("<title>Servlet Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registro at " + request.getContextPath() + "</h1>");
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
            Map<String, String> formData = new HashMap<>();
            Map<String, String[]> opcionesMap = request.getParameterMap();
            Iterator<Map.Entry<String, String[]>> itr = opcionesMap.entrySet().iterator();

            String usuario = request.getParameter("usuario");
            String contrasena = request.getParameter("contrasenia");
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellidos");
            StringBuilder errores = new StringBuilder();
            
            formData.put("hm", request.getParameter("hm"));
            // formData.put("hm", request.getParameter("hm"));
            // formData.put("pref", request.getParameter("pref"));
            if (nombre == null || nombre == "") {
                errores.append("<h3>No has introducido el nombre</h3>");
            }
            if (usuario == null || usuario == "") {
                errores.append("<h3>No has introducido el usuario</h3>");
            }
            if (contrasena == null || contrasena == "") {
                errores.append("<h3>No has introducido la contraseña</h3>");
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registro</title>");
            out.println("<link rel=\"stylesheet\" href=\"" + request.getContextPath() + "/CSS/registroStyleJ.css\">");
            out.println("</head>");
            out.println("<body>");

            if (errores.length() > 0) {
                out.println("<div class =\"errores\">");
                out.println(errores.toString());
                out.println("</div>");
                out.println("<h1>REGISTRO</h1>");
                out.println("<form action=\"" + request.getContextPath() + "/Registro\" method=\"post\">");
                out.println("<div class=\"a\">");
                out.println("<h4>Datos personales</h4>");
                out.println("<br>");
                out.println("<label for = \"nb\">* Nombre:</label>");
                out.println("<input type=\"text\" id=\"nb\" name=\"nombre\" value=\"" + nombre + "\"><br>");
                out.println("<br>");
                out.println("<label for=\"ap\">Apellidos:</label>");
                out.println("<input type=\"text\" id=\"ap\" name=\"apellidos\" value=\"" + apellido + "\"><br>");
                out.println("<br>");
                out.println("<br>");
                out.println("<label>Sexo:</label>");
                out.println("<div class=\"as\">");
                out.println("<input type=\"radio\" name=\"hm\" value=\"Hombre\" checked> Hombre<br>");
                out.println("<input type=\"radio\" name=\"hm\" value=\"Mujer\"> Mujer");
                out.println("</div>");
                out.println("<br>");
                out.println("<label for=\"dma\">Fecha de Nacimiento: </label>");
                out.println("<select>");
                for (int i = 1; i <= 31; i++) {
                    out.println("<option value=\"" + i + "name=\"mes\">" + i + "</option>");
                }
                out.println("</select> &nbsp;/&nbsp;");
                out.println("<select>");
                for (int i = 1; i <= 12; i++) {
                    out.println("<option value=\"" + i + "name=\"mes\">" + i + "</option>");
                }
                out.println("</select> &nbsp;/&nbsp;");
                out.println("<select>");
                for (int i = 1975; i <= 2005; i++) {
                    out.println("<option value=\"" + i + "name=\"anio\">" + i + "</option>");
                }

                out.println("</select>");
                out.println("<br><br>");
                out.println("</div>");
                out.println("<div class=\"b\">");
                out.println("<h4>Datos de acceso</h4>");
                out.println("<br>");
                out.println("<label for = \"usu\">* Usuario:</label>");
                out.println("<input type=\"text\" id=\"usu\" name=\"usuario\" value= \"" + usuario + "\"><br>");
                out.println("<br>");
                out.println("<label for=\"con\">* Contraseña:</label>");
                out.println("<input type=\"password\" id=\"con\" name=\"contrasenia\"value = \"" + contrasena + "\"><br>");
                out.println("<br>");
                out.println("</div>");
                out.println("<div class=\"c\">");
                out.println("<label for=\"so\">Preferencias:</label>");
                out.println("<div class=\"pr\">");
                out.println("<input type=\"checkbox\" name=\"pref\" value=\"Deporte\">Deporte<br>");
                out.println("<input type=\"checkbox\" name=\"pref\" value=\"Lectura\">Lectura<br>");
                out.println("<input type=\"checkbox\" name=\"pref\" value=\"Viajes\">Viajes<br>");
                out.println("<input type=\"checkbox\" name=\"pref\" value=\"Juegos\">Juegos<br>");
                out.println("<br>");
                out.println("</div>");
                out.println("</div>");
                out.println("<br>");
                out.println("<div class=\"btns\">");
                out.println("<input type=\"submit\" name=\"btnEnviar\" value=\"Enviar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("<input type=\"reset\"  name=\"btnLimpiar\" value=\"Limpiar\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                out.println("</div>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            } else {
                String dia = request.getParameter("dia");
                String mes = request.getParameter("mes");
                String anio = request.getParameter("anio");
                out.println("<h1>Datos introducidos en el registro</h1>");
                out.println("<div>");
                out.println("<p>Nombre y Apellidos - <strong>" + nombre + " " + apellido + "</strong></p>");
                out.println("<p>Sexo - <strong>" + formData.get("hm") + "</strong></p>");
                out.println("<p>Fecha de nacimiento - <strong> " + dia + " de " + mes + " del " + anio + "</strong></p>");
                out.println("<p>Usuario - <strong>" + usuario + "</strong></p>");
                out.println("<p>Contraseña - <strong>" + contrasena + "</strong></p>");
                if (opcionesMap.containsKey("pref")) {

                    out.println("Preferencias - ");
                    while (itr.hasNext()) {
                        Map.Entry<String, String[]> entry = itr.next();
                        String[] opciones2 = entry.getValue();

                        if (entry.getKey().contains("pref")) {
                            for (String opcion : opciones2) {
                                out.println("<strong>" + opcion + " </strong>");
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
