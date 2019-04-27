package pe.johimesa.generics;

public class GenericClass<T> {

    T objeto;

    public GenericClass(T objeto) {
        this.objeto = objeto;
    }

    public void obtenerTipoObjeto() {
        System.out.println("El tipo de dato es: " + objeto.getClass().getName());
    }

}
