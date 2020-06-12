package pe.com.jdbc;

import com.sun.security.ntlm.Client;
import pe.com.datos.ClienteJDBC;
import pe.com.datos.ClienteJDBCTransacciones;
import pe.com.datos.Conexion;
import pe.com.domain.Cliente;

import java.sql.*;
import java.util.List;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 13/05/2020
 **/
public class JdbcMain {

    public static void main(String[] args) {
        /*
        // crear cadena de conexion oracle -> https://www.codejava.net/java-se/jdbc/connect-to-oracle-database-via-jdbc
        String cadena = "jdbc:oracle:thin:@172.19.74.144:1521:TIMDEV";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Creamos el objeto de conexión
            Connection connection = DriverManager.getConnection(cadena, "pvu", "pvu");

            if(connection != null) {
                // Creamos el objeto Statement
                Statement statement = connection.createStatement();
                // Creamos el query
                ResultSet resultSet = statement.executeQuery("select c.codcliente, c.nomcliente, c.email, c.dircliente, c.telfcliente from cliente c");

                while(resultSet.next()) {
                    System.out.println("COD: " + resultSet.getString("codcliente"));
                    System.out.println("NOM: " + resultSet.getString("nomcliente"));
                    System.out.println("EMAIL: " + resultSet.getString("email"));
                    System.out.println("DIR: " + resultSet.getString("dircliente"));
                    System.out.println("TEL: " + resultSet.getString("telfcliente"));
                    System.out.println();
                }

                resultSet.close();
                statement.close();
                connection.close();
            } else {
                System.out.println("No hubo conexion.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
        */

        //try {
            /*
            List<Cliente> listClients = ClienteJDBC.getAllCients();
            for (Cliente item : listClients ) {
                System.out.println(item);

                if(item.getId().equals("2"))
                    System.out.println(ClienteJDBC.updateClient("email2@mail.com.pe", Integer.parseInt(item.getId())));
            }

            System.out.println();
            */
            //List<Cliente> listClients1 = null;
            /*
            Cliente cliente = new Cliente();
            cliente.setId("4");
            cliente.setName("Nombre de Cliente 4");
            cliente.setEmail("email4@email.com.pe");
            cliente.setAddress("Direccion de Cliente 4");
            cliente.setPhone("444-4444");

            System.out.println(ClienteJDBC.insertClient(cliente));
            System.out.println();
            */
            /*
        listClients1 = ClienteJDBC.getAllCients();
            listClients1.forEach(c -> System.out.println(c.toString()));

            System.out.println(ClienteJDBC.deleteClient(4));
            System.out.println();

            listClients1 = ClienteJDBC.getAllCients();
            listClients1.forEach(c -> System.out.println(c.toString()));
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }*/

        // Ejecutando la conexión Transaccional
        Connection connectionTransaccional = null;
        try {
            connectionTransaccional = Conexion.getConexion();

            connectionTransaccional.setAutoCommit(false);

            ClienteJDBCTransacciones jdbcTransacciones = new ClienteJDBCTransacciones(connectionTransaccional);
            // update
            //jdbcTransacciones.updateClient("correo30@mail.com", 3);

            // insert
            Cliente cliente2 = new Cliente();
            cliente2.setId("5");
            cliente2.setPhone("444-4444");
            cliente2.setAddress("Direccion 4");
            cliente2.setEmail("Email4@mail.com");
            cliente2.setName("nombre 4");
            //jdbcTransacciones.insertClient(cliente2);

            int i = jdbcTransacciones.deleteClient(4);
            int j = jdbcTransacciones.deleteClient(5);
            int h = jdbcTransacciones.updateClient("email3@mail.com.pe", 3);

            // listando
            List<Cliente> clientes = jdbcTransacciones.getAllCients();
            clientes.forEach(c -> System.out.println(c.toString()));

            connectionTransaccional.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connectionTransaccional.rollback();
                System.out.println("Se ejecuta rollback.");
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionTransaccional.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace(System.out);
            }
        }
    }
}
