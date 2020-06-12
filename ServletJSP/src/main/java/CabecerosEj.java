import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 29/05/2020
 **/
@WebServlet("/ServletExcel")
public class CabecerosEj extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //indicamos el tipo de respuesta al navegador
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=tutorial.xsl");
        //Indicar al navegador q no guarde caché
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", -1); //Expire de manera inmediata
        //Desplegamos la informacion
        PrintWriter printWriter = response.getWriter();
        printWriter.println("\tValores");
        printWriter.println("\t1");
        printWriter.println("\t2");
        printWriter.println("Suma\t=Suma(B2:B3)");

        printWriter.close();
    }
}
