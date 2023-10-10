<%-- 
    Document   : nombreCookie
    Created on : 9 oct. 2023, 19:55:35
    Author     : manue
--%>

<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie cookie = null;
    Boolean existe = false;

    Cookie[] cookies = request.getCookies();
    if (cookies != null) { 
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("nombreCookie")) {
                cookie = cookies[i];
                existe = true; // Establecer existe a true si encontramos la cookie
                break;
            }
        }
    }
    if (cookie == null) {
        cookie = new Cookie("nombreCookie", URLEncoder.encode("Manuel Fernandez Nevado", "UTF-8"));
    }

    cookie.setMaxAge(3600); // Una hora en segundos
    response.addCookie(cookie);

    String persona = "";

    if (existe) {
        persona += "Hola " + URLDecoder.decode(cookie.getValue(), "UTF-8");
    } else {
        persona += "Todavía no tenemos datos tuyos";
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><%= persona%></h1>
        <form action="nombreCookie.jsp">
            <a href="nombreCookie.jsp">
                <button class='buttom8'>Recargar</button>
            </a>            
        </form>
        <a href="../index.html">
            <button class='buttom8'>Volver a inicio</button>
        </a>
    </body>
</html>
