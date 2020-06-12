import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 27/05/2020
 **/
@WebServlet("/Servlet")
public class ServletTest extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration cabeceras = req.getHeaderNames();
        Cookie[] cookies = req.getCookies();

        String user = req.getParameter("usuario");
        String pass = req.getParameter("clave");
        String[] tecnologias = req.getParameterValues("tecnologia");
        String genero = req.getParameter("genero");
        String ocupacion = req.getParameter("ocupacion");
        String[] musica = req.getParameterValues("musica");
        String comentario = req.getParameter("comentario");

        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html>");
        printWriter.print("<body>");
        printWriter.print("<h3>Usuario: " + user + "</h3>");
        printWriter.print("<h3>Clave: " + pass + "</h3>");
        String tec = "";
        for (String item : tecnologias ) {
            tec += item + "|";
        }
        printWriter.print("<h3>Tecnologías: " + tec + "</h3>");
        printWriter.print("<h3>Genero: " + genero + "</h3>");
        printWriter.print("<h3>Ocupación: " + ocupacion + "</h3>");
        String mus = "";
        if(musica != null) {
            for (String item : musica ) {
                mus += item + "|";
            }
        }
        printWriter.print("<h3>Música: " + mus + "</h3>");
        printWriter.print("<h3>Comentario: " + comentario + "</h3>");
        printWriter.print("<br><br>");
        while (cabeceras.hasMoreElements()) {
            String cab = (String) cabeceras.nextElement();
            printWriter.print("<b>" + cab + "</b>: " + req.getHeader(cab));
            printWriter.print("<br>");
        }
        printWriter.print("</body>");
        printWriter.println("</html>");
        printWriter.close();

        //resp.sendError(resp.SC_UNAUTHORIZED, "Datos incorrectos.");// Estado del servlet
        // Cookies

        if(cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                System.out.println(cookies[i].getName() + " - " + cookies[i].getValue());
            }
        } else {
            Cookie cookie = new Cookie("usuario", "Hilario");
            resp.addCookie(cookie);
        }

        HttpSession httpSession = req.getSession();
        
    }
}
