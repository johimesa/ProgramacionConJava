package test;

import beans.HolaMundoEJBRemote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.*;

public class TestHolaMundoEJB {
    public static void main(String[] args) {
        
        System.out.println("iniciando la llamada al EJB");
        try {
            
            Context jndi = new InitialContext();
            
            HolaMundoEJBRemote holaMundoEJB = (HolaMundoEJBRemote) jndi.lookup("java:global/EJBExample1/HolaMundoEJBImpl");
            
            int resultado = holaMundoEJB.suma(78, 89);
            
            System.out.println("La suma es: " + resultado);
        } catch (NamingException ex) {
            Logger.getLogger(TestHolaMundoEJB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
