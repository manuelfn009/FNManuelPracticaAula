<%-- 
    Document   : nVecesCookie
    Created on : 9 oct. 2023, 21:04:37
    Author     : manue

Una jsp contador de visitas 
Que se inicie cuando lo abres con 1 visita.3 botones uno para refrescar 
y que te sume una visita. Otro para volver al index y que al entrar de nuevo 
al jsp sume una visita más y el último que borre la cookie poniendo el tiempo 
de vida a 0 age
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>Contador de Visitas</title>
        <link rel="stylesheet" type= "text/css" href="../CSS/nVecesCookieStyle.css">
    </head>
    <body>
        <div>
        <h1>Contador de Visitas</h1>
        <div class="principal">
            <%-- Obtener el valor actual de la cookie o inicializar a 1 si no existe --%>
            <%
                int visitas = 1; // Valor inicial
                int version = 0;
                String nombre = "";
                Boolean segura = false;
                int tiempoVida = 0;

                Cookie[] cookies = request.getCookies();

                if (cookies != null) {
                    for (Cookie cookie : cookies) {
                        if (cookie.getName().equals("contadorVisitas")) {
                            cookie.setMaxAge(3600); // Una hora en segundos
                            visitas = Integer.parseInt(cookie.getValue());
                            version = cookie.getVersion();
                            nombre = cookie.getName();
                            segura = cookie.getSecure();
                            tiempoVida = cookie.getMaxAge();
                            break;
                        }
                    }
                }

            %>

            <p>Visitas: <%= visitas%></p>
            <p>Caducidad: <%= tiempoVida%></p>
            <p>Nombre cookie: <%= nombre%></p>
            <p>Segura: <%= segura%></p>
            <p>Version: <%= version%></p>
        </div>
        <form method="post">
            <input class="btn" type="submit" name="Recargar" value="Recargar">
            <input class="btn" type="submit" name="volver" value="Menu inicial">
            <input class="btn" type="submit" name="reset" value="Resetear visitas">
        </form>

        <%-- Procesar los botones --%>
        <%
            if (request.getMethod().equals("POST")) {
                if (request.getParameter("Recargar") != null) {
                    visitas++; // Incrementar el contador de visitas
                } else if (request.getParameter("volver") != null) {
                    response.sendRedirect("../index.html"); // Redirigir al index
                    return;
                } else if (request.getParameter("reset") != null) {

                    Cookie cookie = new Cookie("contadorVisitas", String.valueOf(visitas));
                    cookie.setMaxAge(0); // Establecer la vida de la cookie a 0 para eliminarla
                    visitas = 0; // Restablecer el contador de visitas
                    response.addCookie(cookie);
                }

                // Actualizar la cookie con el nuevo valor de visitas
                Cookie cookie = new Cookie("contadorVisitas", String.valueOf(visitas));
                response.addCookie(cookie);
            }
        %>
        </div>
    </body>
</html>