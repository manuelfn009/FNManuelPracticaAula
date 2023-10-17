<%-- 
    Document   : pruebaBeansSalida
    Created on : 11 oct. 2023, 16:36:28
    Author     : manue
--%>

<%@page import="es.albarregas.beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Salida</title>
    </head>
    <body>
        <h1>Ejemplos de atributo</h1>
        <h2>De sesion</h2>
        <%
            Persona persona = new Persona();
            persona = (Persona) request.getSession().getAttribute("personaSesion");
        %>
        <ul>
            <li><%= persona.getNombre()%></li>
            <li><%= persona.getApellidos()%></li>
            <li><%= persona.getNumHijos()%></li>
            <li><%= persona.getSalario()%></li>
        </ul>
        <h1>Ejemplos de atributo</h1>
        <h2>De petición</h2>
        <%
            persona = new Persona();
            persona = (Persona) request.getAttribute("personaPeticion");
        %>
        <ul>
            <li><%= persona.getNombre()%></li>
            <li><%= persona.getApellidos()%></li>
            <li><%= persona.getNumHijos()%></li>
            <li><%= persona.getSalario()%></li>
        </ul>

    </body>
</html>
