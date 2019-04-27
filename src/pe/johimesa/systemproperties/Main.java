package pe.johimesa.systemproperties;

import java.util.Enumeration;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties properties = System.getProperties();

        Enumeration enumeration = properties.propertyNames();

        while (enumeration.hasMoreElements()) {
            String propertieName = (String) enumeration.nextElement();

            System.out.println(propertieName + ": " + properties.getProperty(propertieName));
        }

    }

}
