package servlets;

import java.io.*;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ServletHeaders", urlPatterns = ("/ServletHeaders"))
public class ServletHeaders extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            //Procesamos los headers relacionados con la
            //información de la petición
            //solictamos el método que usó el cliente
            //para llamar al servlet
            String metodoHttp = request.getMethod();
            String uri = request.getRequestURI();
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Headers HTTP</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Headers HTTP</h1>");
            out.println("Método HTTP: " + metodoHttp);
            out.println("<br>");
            out.println("URI solicitado: " + uri);
            out.println("<br>");
            //procesamos algunos cabeceros que son
            //parte de la petición
            out.println("<br>");
            //vemos el host
            out.println("Host: " + request.getHeader("Host"));
            out.println("<br>");
            //vemos el tipo de navegador que usó el cliente
            out.println("Navegador: " + request.getHeader("User-Agent"));
            //Procesamos todos los cabeceros
            //estos pueden variar según el navegador que se
            //utilice
            out.println("<br>");
            out.println("<br>");
            Enumeration cabeceros = request.getHeaderNames();
            while (cabeceros.hasMoreElements()) {                
                String nombreCabecero = (String) cabeceros.nextElement();
                out.print("<br>" + nombreCabecero + "</br>: ");
                out.print(request.getHeader(nombreCabecero));
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
