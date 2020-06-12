package pe.desingpattern.datos;

import pe.com.datos.Conexion;
import pe.desingpattern.domain.ClienteDTO;
import java.sql.*;
import java.util.*;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 23/05/2020
 **/
public class ClienteDaoJDBC implements ClienteDAO {

    private Connection connectionTransaccional = null;

    private String getAllClient = "select c.codcliente, c.nomcliente, c.email, c.dircliente, c.telfcliente from cliente c order by c.codcliente";
    private String updateClient = "update cliente c set c.email = ? where c.codcliente = ?";
    private String deleteClient = "delete from cliente c where c.codcliente = ?";
    private String insertClient = "insert into cliente(codcliente, nomcliente, email, dircliente, telfcliente) values(?, ?, ?, ?, ?)";

    public ClienteDaoJDBC() { }

    public ClienteDaoJDBC(Connection connection) {
        this.connectionTransaccional = connection;
    }

    public List<ClienteDTO> getAllCients() throws SQLException, ClassNotFoundException {
        List<ClienteDTO> listaClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Long timeInit = System.currentTimeMillis();

        try {
            connection = this.connectionTransaccional != null ? this.connectionTransaccional : Conexion.getConexion();
            System.out.println(connection);
            preparedStatement = connection.prepareStatement(getAllClient);
            resultSet = preparedStatement.executeQuery();
            System.out.println("Llega acá");
            while (resultSet.next()){
                ClienteDTO cliente = new ClienteDTO();
                cliente.setAddress(resultSet.getString("dircliente"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setId(resultSet.getString("codcliente"));
                cliente.setName(resultSet.getString("nomcliente"));
                cliente.setPhone(resultSet.getString("telfcliente"));

                listaClients.add(cliente);
            }
        } finally {
            Conexion.close(resultSet);
            Conexion.close(preparedStatement);
            if(this.connectionTransaccional == null)
                Conexion.close(connection);
        }
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - timeInit) + " ms.");
        return listaClients;
    }

    public int updateClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException {
        int rows = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Long timeInit = System.currentTimeMillis();

        try {
            connection = this.connectionTransaccional != null ? this.connectionTransaccional : Conexion.getConexion();
            preparedStatement = connection.prepareStatement(updateClient);
            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setInt(2, Integer.parseInt(cliente.getId()));

            rows = preparedStatement.executeUpdate();
        } finally {
            Conexion.close(preparedStatement);
            if(this.connectionTransaccional == null)
                Conexion.close(connection);
        }
        System.out.println("Tiempo total: " + (System.currentTimeMillis() - timeInit) + " ms.");
        return rows;
    }

    public int insertClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            int index = 1;
            connection = this.connectionTransaccional != null ? this.connectionTransaccional : Conexion.getConexion();
            preparedStatement = connection.prepareStatement(insertClient);
            preparedStatement.setInt(index++, Integer.parseInt(cliente.getId()));
            preparedStatement.setString(index++, cliente.getName());
            preparedStatement.setString(index++, cliente.getEmail());
            preparedStatement.setString(index++, cliente.getAddress());
            preparedStatement.setString(index, cliente.getPhone());

            result = preparedStatement.executeUpdate();

        } finally {
            Conexion.close(preparedStatement);
            if(this.connectionTransaccional == null)
                Conexion.close(connection);
        }

        return result;
    }

    public int deleteClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException {
        int result = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = this.connectionTransaccional != null ? this.connectionTransaccional : Conexion.getConexion();
            preparedStatement = connection.prepareStatement(deleteClient);
            preparedStatement.setInt(1, Integer.parseInt(cliente.getId()));

            result = preparedStatement.executeUpdate();
        } finally {
            Conexion.close(preparedStatement);
            if(this.connectionTransaccional == null)
                Conexion.close(connection);
        }

        return result;
    }
}
