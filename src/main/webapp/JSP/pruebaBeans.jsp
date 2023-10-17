<%-- 
    Document   : pruebaBeans
    Created on : 11 oct. 2023, 16:20:41
    Author     : manue
--%>

<%@page import="es.albarregas.beans.Persona"%>

<%

    Persona persona = new Persona();
    Persona persona1 = new Persona("Pedro", "Prieto", Byte.parseByte("0"), 2000.0);
    persona.setNombre("Juan");
    persona.setApellidos("Macias");
    persona.setNumHijos(Byte.parseByte("2"));
    persona.setSalario(1200.34);

    request.getSession().setAttribute("personaSesion", persona); //se mete en sesion

    request.setAttribute("personaPeticion", persona1);   //se mete en peticion

    response.sendRedirect("pruebaBeansSalida.jsp");
%>
