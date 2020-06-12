package pe.controladores;

import pe.bean.Rectangulo;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1. Procesa parámetros
		// 2. Creación JavaBean
		Rectangulo rect = new Rectangulo(2, 3);
		
		// 3. Agregamos el JavaBean a algún alcance
		HttpSession session = req.getSession();
		session.setAttribute("rectangle", rect);
		
		req.setAttribute("saludo", "Hola desde Servlet");
		
		// 4. Redireccionar a la vista seleccionada
		RequestDispatcher rd = req.getRequestDispatcher("vista/displayVariables.jsp");
		rd.forward(req, resp);
	}
	
}
