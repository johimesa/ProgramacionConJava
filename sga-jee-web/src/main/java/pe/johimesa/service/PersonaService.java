package pe.johimesa.service;

import java.util.List;
import javax.ejb.Local;
import pe.johimesa.domain.Persona;

@Local
public interface PersonaService {
    public List<Persona> findAll();
    public Persona findById(Persona persona);
    public Persona findByEmail(Persona persona);
    public void insert(Persona persona);
    public void update(Persona persona);
    public void delete(Persona persona);
}
