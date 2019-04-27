package pe.johimesa.generics;

public class Main {

    public static void main(String[] args) {

        GenericClass<Integer> integer = new GenericClass<>(12);
        integer.obtenerTipoObjeto();

        GenericClass<String> string = new GenericClass<>("Hilario");
        string.obtenerTipoObjeto();

        Person p = new Person();
        GenericClass<Person> objeto = new GenericClass<>(p);
        objeto.obtenerTipoObjeto();

    }

}
