package pe.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import pe.bean.Rectangulo;

@WebServlet("/ServletControlador")
public class SerevletControlador extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1. Procesa parámetros
		String action = req.getParameter("accion");
		// 2. Creación JavaBean
		Rectangulo rect_req = new Rectangulo(2, 3);
		Rectangulo rect_session = new Rectangulo(4, 7);
		Rectangulo rect_app = new Rectangulo(5, 8);
		
		// 3. Agregamos el JavaBean a algún alcance
		if(action != null && "addVar".equalsIgnoreCase(action)) {
			// alcance request
			req.setAttribute("rect_req", rect_req);
			
			// alcance session
			HttpSession session = req.getSession();
			session.setAttribute("rect_session", rect_session);
			
			// alcance application
			ServletContext application = this.getServletContext();
			application.setAttribute("rect_app", rect_app);
			
			// alcance request
			req.setAttribute("mensaje", "Las variables fueron agregadas.");
			// 4. Redireccionar a la vista seleccionada
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} else if(action != null && "displayVar".equalsIgnoreCase(action)) {
			// 4. Redireccionar a la vista seleccionada
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/alcanceVar.jsp");
			rd.forward(req, resp);
		} else {
			// 4. Redireccionar a la vista seleccionada
			// alcance request
			req.setAttribute("mensaje", "Acción no proporcionada.");
			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
			// Esta línea no agregaría info al JSP, ya q no propaga los obj.req y resp
			//resp.sendRedirect("index.jsp");
		}
	}
}
