package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

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
            out.println("<title>Servlet Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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

        response.setContentType("text/html/charset=UTF-8");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        //El elemento tecnología puede tener varios valores
        //por ello lo procesamos como un arreglo
        String[] tecnologias = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        //El componente música, indica que se pueden
        //seleccionar múltiples elementos, por ello 
        //lo procesamos como un arreglo
        String[] musica = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Resultado Servlet</title>");
        out.println("<meta charset='UTF-8'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Par&aacute;metros procesados por el Servlet:</h1>");
        out.println("<table border='1'>");

        out.println("<tr>");
        out.println("<td>");
        out.println("Usuario:");
        out.println("</td>");
        out.println("<td>");
        out.println(usuario);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println("Password:");
        out.println("</td>");
        out.println("<td>");
        out.println(password);
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println("Tecnolog&iacute;as:");
        out.println("</td>");
        out.println("<td>");
        for (String tec : tecnologias) {
            out.println(tec);
            out.println(" / ");
        }
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println("G&eacute;nero:");
        out.println("</td>");
        out.println("<td>");
        if ("H".equals(genero)) {
            out.println("Hombre");
        } else {
            out.println("Mujer");
        }
        out.println("</td>");
        out.println("</tr>");

        out.println("<tr>");
        out.println("<td>");
        out.println("Ocupaci&oacute;n:");
        out.println("</td>");
        out.println("<td>");
        switch (ocupacion) {
            case "1" :
                out.println("Profesor");
                break;
            case "2" :
                out.println("TSU");
                break;
            case "3" :
                out.println("Jubilado");
                break;
            default :
                out.println("Otro");
        }
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>");
        out.println("M&uacute;sica:");
        out.println("</td>");
        out.println("<td>");
        for (String mus : musica) {
            out.println(mus + " / ");
        }
        out.println("</td>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>");
        out.println("Comentarios:");
        out.println("</td>");
        out.println("<td>");
        out.println(comentario);
        out.println("</td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
        //processRequest(request, response);
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
