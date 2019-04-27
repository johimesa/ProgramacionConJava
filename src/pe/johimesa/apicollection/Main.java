package pe.johimesa.apicollection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // /Users/hilariomedina/Documents/UdemyJava/ProgramacionConJava

        List list = new ArrayList(); // permiten repetidos y guardan el orden
        list.add("José");
        list.add("Amelia");
        list.add("Adriano");
        list.add("Hamlet");
        leer(list);

        Set set = new HashSet(); // No permite elementos duplicados, los ignora si los hay
        set.add("Adriano");
        set.add("Amelia");
        set.add("Adriano");
        set.add("Hamlet");
        leer(set);

        Map map = new HashMap(); // guarda llave valor
        map.put("1", "Lunes");
        map.put("2", "Martes");
        map.put("3", "Miercoles");
        map.put("4", "Jueves");
        map.put("5", "Viernes");
        leer(map.keySet());
        leer(map.values());

    }

    private static void leer(Collection collection) {

        for (Object o: collection) {
            System.out.println(o);
        }
        System.out.println();
    }

}
