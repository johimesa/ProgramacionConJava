package pe.com.datos;

import pe.com.domain.Cliente;
import java.sql.*;
import java.util.*;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 21/05/2020
 **/
public class ClienteJDBC {

    private static String getAllClient = "select c.codcliente, c.nomcliente, c.email, c.dircliente, c.telfcliente from cliente c order by c.codcliente";
    private static String updateClient = "update cliente c set c.email = ? where c.codcliente = ?";
    private static String deleteClient = "delete from cliente c where c.codcliente = ?";
    private static String insertClient = "insert into cliente(codcliente, nomcliente, email, dircliente, telfcliente) values(?, ?, ?, ?, ?)";

    public static List<Cliente> getAllCients() {
        List<Cliente> listaClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long timeInit = System.currentTimeMillis();

        try {

            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(getAllClient);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Cliente cliente = new Cliente();
                cliente.setAddress(resultSet.getString("dircliente"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setId(resultSet.getString("codcliente"));
                cliente.setName(resultSet.getString("nomcliente"));
                cliente.setPhone(resultSet.getString("telfcliente"));

                listaClients.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(resultSet);
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - timeInit) + " ms.");
        return listaClients;
    }

    public static int updateClient(String email, int id) {
        int rows = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Long timeInit = System.currentTimeMillis();

        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(updateClient);
            preparedStatement.setString(1, email);
            preparedStatement.setInt(2, id);

            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - timeInit) + " ms.");
        return rows;
    }

    public static int insertClient(Cliente cliente) {
        int result = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            int index = 1;
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(insertClient);
            preparedStatement.setInt(index++, Integer.parseInt(cliente.getId()));
            preparedStatement.setString(index++, cliente.getName());
            preparedStatement.setString(index++, cliente.getEmail());
            preparedStatement.setString(index++, cliente.getAddress());
            preparedStatement.setString(index, cliente.getPhone());

            result = preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }

        return result;
    }

    public static int deleteClient(int id) {
        int result = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = Conexion.getConexion();
            preparedStatement = connection.prepareStatement(deleteClient);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(preparedStatement);
            Conexion.close(connection);
        }

        return result;
    }

}
