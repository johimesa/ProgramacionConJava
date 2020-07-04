package pe.johimesa.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import pe.johimesa.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote {

    @Override
    public List<Persona> findAll() {
        List<Persona> list = new ArrayList<>();
        Persona p1 = new Persona(1, "hilario", "medina", "johimesa@gmai.com", "970456782");
        Persona p2 = new Persona(2, "hamlet", "medina", "hamlet@gmail.com", "896456231");
        
        list.add(p1);
        list.add(p2);
        
        return list;
    }

    @Override
    public Persona findById(Persona persona) {
        return null;
    }

    @Override
    public Persona findByEmail(Persona persona) {
        return null;
    }

    @Override
    public void insert(Persona persona) {
        
    }

    @Override
    public void update(Persona persona) {
        
    }

    @Override
    public void delete(Persona persona) {
        
    }    
}
