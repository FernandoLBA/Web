package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = ("/Servlet"))
public class Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        //Esto es un try with resources
        try (PrintWriter out = response.getWriter()) {
            //Creamos ls variables para el título
            //y el mensaje de nuestra página web
            String titulo = null, mensaje = null;
            //Detectamos el tipo de navegador que hizo la
            //petición
            String tipoNavegador = request.getHeader("User-Agent");
            out.println("Tipo de navegador: " + tipoNavegador);
            //Verificamos el tipo de navegador y personalizamos
            //el mensaje a enviar
            //si el tipoNavegador no está vacío y tipoNavegador 
            //contiene la palabra "Trident".
            if (tipoNavegador != null && tipoNavegador.contains("Trident")) {
                titulo = "Navegador Internet Explorer.";
                mensaje = "Estás navegando con Internet Explorer.";
            } else if (tipoNavegador != null && tipoNavegador.contains("Firefox")) {
                titulo = "Navegador Firefox.";
                mensaje = "Estás navegando con Firefox.";
            } else if (tipoNavegador != null && tipoNavegador.contains("Edg")) {
                titulo = "Navegador Edge.";
                mensaje = "Estás navegando con Edge.";
            } else if (tipoNavegador != null && tipoNavegador.contains("Chrome")) {
                titulo = "Navegador Google Chrome.";
                mensaje = "Estás navegando con Google Chrome.";
            }

            out.println("<html>");
            out.println("<head>");
            out.println("<title>" + titulo + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tipo de Navegador</h1>");
            out.println("<br>");
            out.println(mensaje);
            out.println("</body>");
            out.println("</html>");
        }
    }
}
