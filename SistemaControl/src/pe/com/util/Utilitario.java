package pe.com.util;

import java.util.List;

import pe.com.domain.ClientDTO;

public class Utilitario {
	
	public static Double calcularSaldo(List<ClientDTO> listaClientes) {
		Double total = 0.0;
		
		if(listaClientes == null || listaClientes.isEmpty()) {
			return total;
		} else {
			for (ClientDTO clientDTO : listaClientes) {
				total += clientDTO.getBalance();
			}
		}
		
		return total;
	}
	
}
