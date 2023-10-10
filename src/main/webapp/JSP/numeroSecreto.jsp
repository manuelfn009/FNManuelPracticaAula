<%-- 
    Document   : numeroSecreto
    Created on : 3 oct. 2023, 21:18:00
    Author     : manue
--%>


<%@page import="java.util.Random"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Numero secreto</title>
    </head>
    <body>
        <h1>Juego del numero secreto</h1>
        <form action="../JSP/numeroSecreto.jsp">
            <label>Introduce un numero:</label>
            <input type="number" name="numero" min="1" max="100">
            <input type="submit" name="btnCom" value="Comprobar">
        </form>
        <table>
            <tr>
                <th>Numero</th>
                <th>Mensaje</th>
            </tr>
            <%
                String respuesta = "";
                String acierto = "";
                int numeroSecreto;
                
                if (session.getAttribute("numeroSecreto") == null) {
                    Random rand = new Random();
                    numeroSecreto = rand.nextInt(100) + 1; // Número aleatorio entre 1 y 100
                    session.setAttribute("numeroSecreto", numeroSecreto);
                } else {
                    numeroSecreto = (int) session.getAttribute("numeroSecreto");
                }
                int numero = 0;
                int cont = 0;

                if (session.getAttribute("respuestas") == null) {
                    session.setAttribute("respuestas", new ArrayList<String>());
                }

                List<String> respuestas = (List<String>) session.getAttribute("respuestas");

                if (request.getParameter("btnCom") != null) {
                    numero = Integer.parseInt(request.getParameter("numero"));
                    
                    if (numeroSecreto != numero) {
                        if (numeroSecreto < numero) {

                            respuesta = "El numero introducido es mayor que el que he pensado";

                        } else {
                            respuesta = "El numero introducido es menor que el que he pensado";
                        }
                    } else {
                        respuesta = "Has acertado!!";
                        acierto = "Has necesitado " + cont + " intentos";
                        respuestas.add(numero + ": " + respuesta + acierto);
                    }

                    respuestas.add(numero + ": " + respuesta + ": " + cont);

                    session.setAttribute("respuestas", respuestas);
                }

                for (String r : respuestas) {
                    String[] parts = r.split(": ");
                    String num = parts[0];
                    String msg = parts[1];
            %>
            <tr>
                <td><%= num%></td>
                <td><%= msg%></td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>