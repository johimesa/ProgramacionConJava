package pe.johimesa.entradasalida;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
***** API de Entrada
java.lang.Object
    Reader: Tipo char
        InputStreamReader:
            FileReader:
        BufferedReader:

    InputStream: Tipo byte
        FilterInputStream:
            DataInputStream:
            BufferedInputStream:

***** API de Salida
java.lang.Object
    Writer: Tipo char
        PrintWriter
        OutputStreamWriter
            FileWriter
        BufferedWriter
            PrintStream

    OutputStream: Tipo byte
        FilterOutputStream:
            BufferedOutputStream
            DataOutputStream
 */
public class Main {

    public static void main(String[] args) {

        String entrada;

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            System.out.print("Ingrese datos: ");
            entrada = bufferedReader.readLine();

            while (entrada != null && !entrada.isEmpty()) {
                System.out.println("Dato introducido: " + entrada);
                entrada = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" ***** Clase Scanner. *****");
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingrese datos scanner: ");
            entrada = scanner.nextLine();

            while (entrada != null && !entrada.isEmpty()) {
                System.out.println("Dato introducido: " + entrada);
                entrada = bufferedReader.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
