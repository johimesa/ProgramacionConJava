package pe.johimesa.service;

import java.util.List;
import javax.ejb.Remote;
import pe.johimesa.domain.Persona;

@Remote
public interface PersonaServiceRemote {
    
    public List<Persona> findAll();
    public Persona findById(Persona persona);
    public Persona findByEmail(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}
