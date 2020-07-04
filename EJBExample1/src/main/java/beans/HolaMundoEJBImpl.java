package beans;

import javax.ejb.Stateless;

@Stateless
public class HolaMundoEJBImpl implements HolaMundoEJBRemote {

    @Override
    public int suma(int a, int b) {
        return a + b;
    }
    
}
