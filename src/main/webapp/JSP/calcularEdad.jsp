<%-- 
    Document   : saludo
    Created on : 2 oct. 2023, 20:56:19
    Author     : manue
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- <link rel="stylesheet" type= "text/css" href="/CSS/saludoStyle.css"/>-->
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado</h1>
        <%
            // Obtenemos el parámetro 'nombre' del formulario
            String nombre = "";
            nombre = request.getParameter("nombre");
        %>
        <p>Hola <%= nombre%></p>

        <%
            // Obtenemos el parámetro 'fecha' del formulario
            String fecha = "";
            fecha = request.getParameter("fechaNac");

            // Creamos un formateador de fecha para parsear la fecha ingresada
            SimpleDateFormat fechaD = new SimpleDateFormat("yyyy-MM-dd");

            // Parseamos la fecha de texto a un objeto Date
            Date fechaNac = fechaD.parse(fecha);
            Date fechaAct = new Date();

            // Creamos objetos Calendar para manejar fechas
            Calendar cFechaNac = Calendar.getInstance();
            cFechaNac.setTime(fechaNac);

            Calendar cFechaAct = Calendar.getInstance();
            cFechaAct.setTime(fechaAct);

            // Calculamos la diferencia en años, meses y días
            int anio = cFechaAct.get(Calendar.YEAR) - cFechaNac.get(Calendar.YEAR);
            int mes = cFechaNac.get(Calendar.MONTH) - cFechaAct.get(Calendar.MONTH);
            int dia = cFechaNac.get(Calendar.DAY_OF_MONTH) - cFechaNac.get(Calendar.DAY_OF_MONTH);

            String frase = "Tienes ";

            // Construimos la frase en base a la diferencia calculada
            if (anio > 0) {
                if (mes <= cFechaAct.get(Calendar.MONTH)) {
                    anio--;
                    if (dia <= cFechaAct.get(Calendar.DAY_OF_MONTH)) {
                        mes--;
                    }
                }
                frase += anio + " años " + (mes + 12) + " meses" + (dia + Calendar.DAY_OF_MONTH) + "dias";
            }
            if (mes > 0) {
                anio--;
                frase += mes + " meses ";
            }
            if (dia > 0) {
                mes--;
                frase += dia + " dias ";
            }

        %>
        <p><%= frase%><p>

            <!-- Enlace para volver a la página de inicio -->
            <a href="../index.html">
                <button class='buttom8'>Volver a inicio</button>
            </a>
    </body>
</html>