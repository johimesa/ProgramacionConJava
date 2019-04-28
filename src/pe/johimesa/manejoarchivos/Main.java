package pe.johimesa.manejoarchivos;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        String path = "/Users/hilariomedina/Documents/manejoArchivos.txt";

        crearArchivo(path);
        leerArchivo(path);
        anexarArchivo(path);
        leerArchivo(path);
    }

    public static void crearArchivo(String nombreArchivo) {

        File file = new File(nombreArchivo);

        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(file));
            String salida = "Hola este texto será insertado en el archivo";

            printWriter.println(salida);
            printWriter.println();
            printWriter.println("Fin de la escritura");
            printWriter.close();

            System.out.println("Se ha escrito correctamente el archivo.\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerArchivo(String nombreArchivo) {

        File file = new File(nombreArchivo);

        try{
            BufferedReader entrada = new BufferedReader(new FileReader(file));
            String lectura;
            lectura = entrada.readLine();

            while (lectura != null) {
                System.out.println(lectura);
                lectura = entrada.readLine();
            }

            entrada.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void anexarArchivo(String nombreArchivo) {

        File file = new File(nombreArchivo);

        try {
            PrintWriter salida = new PrintWriter(new FileWriter(file, true));
            String contenido = "Agregando más contenido al archivo.";

            salida.println(contenido);
            salida.println();
            salida.println("Se termina el anexo del nuevo contenido");
            salida.close();

            System.out.println("Se ha anexado correctamente el contenido.\n");
        } catch (IOException e){
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
