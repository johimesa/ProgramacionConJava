package pe.johimesa.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.johimesa.domain.Persona;
import pe.johimesa.service.PersonaService;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {
    
    @Inject
    PersonaService personaService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Persona> lista = personaService.findAll();
        System.out.println("personas: " + lista);
        
        req.setAttribute("personas", lista);
        req.getRequestDispatcher("/listapersonas.jsp").forward(req, resp);
    }
        
}
