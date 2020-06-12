package pe.com.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.com.dao.ClientDao;
import pe.com.dao.ClientDaoImplOracle;
import pe.com.domain.ClientDTO;
import pe.com.util.Utilitario;
import utils.system;

@WebServlet("/ServletController")
public class ServletController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public ServletController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("accion");
		
		if(action != null) {
			switch (action) {
			case "edit":
				this.updateClient(request, response, null);
				break;
			case "delete":
				this.deleteClient(request, response);
				break;
			default:
				this.defaultAction(request, response);
				break;
			}
		} else {
			this.defaultAction(request, response);
		}
		
		this.defaultAction(request, response);
	}
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		ClientDao cliDao = new ClientDaoImplOracle();
		int id = Integer.parseInt(request.getParameter("id"));
		ClientDTO cliente = new ClientDTO(id);
		int resultado = 0;
		
		try {
			resultado = cliDao.deleteClient(cliente);
			System.out.println("resultado:" + resultado);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} finally {
			this.defaultAction(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("accion");
		
		if(action != null) {
			switch (action) {
			case "insert":
				this.insertClient(request, response);
				break;
			case "edit":
				this.updateClient(request, response, true);
				break;
			default:
				this.defaultAction(request, response);
				break;
			}
		} else {
			this.defaultAction(request, response);
		}
	}
	
	// Métodos utilitarios
	private void defaultAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientDao clientDAO = new ClientDaoImplOracle();
		List<ClientDTO> listClients = new ArrayList<>();
		HttpSession session = request.getSession();
		
		try {
			listClients = clientDAO.getClients();
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			/*
			request.setAttribute("clientes", listClients);
			request.setAttribute("clientesTotal", listClients.isEmpty() ? 0 : listClients.size());
			request.setAttribute("saldoTotal", Utilitario.calcularSaldo(listClients));
			
			request.getRequestDispatcher("clientes.jsp").forward(request, response); */
			
			session.setAttribute("clientes", listClients);
			session.setAttribute("clientesTotal", listClients.isEmpty() ? 0 : listClients.size());
			session.setAttribute("saldoTotal", Utilitario.calcularSaldo(listClients));
			
			response.sendRedirect("clientes.jsp");
		}
	}
	
	private void insertClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientDao clienteDAO = new ClientDaoImplOracle();
		int resultado = 0;
		
		try {
			ClientDTO cliente = new ClientDTO();
			
			cliente.setId(Integer.parseInt(request.getParameter("idCliente")) + 1);
			cliente.setName(request.getParameter("name"));
			cliente.setLastname(request.getParameter("lastname"));
			cliente.setBalance(Double.parseDouble(request.getParameter("balance")));
			
			resultado = clienteDAO.addClient(cliente);
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}
		
		System.out.println("resultado = " + resultado);
		
		this.defaultAction(request, response);
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response, Boolean post) throws ServletException, IOException {
		ClientDao cliDao = new ClientDaoImplOracle();
		
		if(post != null) {
			
			int resultado = 0;
			
			try {
				ClientDTO cliente = new ClientDTO();
				
				cliente.setId(Integer.parseInt(request.getParameter("idCliente")));
				cliente.setLastname(request.getParameter("lastname"));
				cliente.setBalance(Double.parseDouble(request.getParameter("balance")));
				
				resultado = cliDao.updateClient(cliente);
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			}
			
			System.out.println("resultado = " + resultado);
			
			this.defaultAction(request, response);
			
		} else {
			int id = Integer.parseInt(request.getParameter("id"));
			ClientDTO cliente = new ClientDTO(id);
			
			try {
				cliente = cliDao.getClientById(cliente);
				System.out.println(cliente);
				request.setAttribute("cliente", cliente);
				
			} catch (SQLException e) {
				e.printStackTrace(System.out);
			} finally {
				request.getRequestDispatcher("/WEB-INF/paginas/clients/update.jsp").forward(request, response);
			}
		}
	}
}
