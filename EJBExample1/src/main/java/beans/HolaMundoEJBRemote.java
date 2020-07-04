package beans;

import javax.ejb.Remote;

@Remote
public interface HolaMundoEJBRemote {
    public int suma(int a, int b);
}
