package pe.johimesa.cliente;

import java.util.List;
import javax.naming.*;
import pe.johimesa.domain.Persona;
import pe.johimesa.service.PersonaServiceRemote;

public class ClientePersonaService {

    public static void main(String[] args) {
        try {
            System.out.println("iniciando la llamada al EJB desde el cliente");
            
            Context jndi = new InitialContext();
            
            PersonaServiceRemote personaRemote = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!pe.johimesa.service.PersonaServiceRemote");
            
            List<Persona> listaPersonas = personaRemote.findAll();
            
            listaPersonas.forEach(p -> System.out.println(p));
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
