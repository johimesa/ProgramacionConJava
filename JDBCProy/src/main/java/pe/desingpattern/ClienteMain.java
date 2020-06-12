package pe.desingpattern;

import pe.com.datos.Conexion;
import pe.desingpattern.datos.*;
import java.sql.*;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 24/05/2020
 **/
public class ClienteMain {

    public static void main(String[] args) {

        //Connection connection = null;
        try {
            //connection = Conexion.getConexion();
            //connection.setAutoCommit(false);

            //ClienteDAO clienteDAO = new ClienteDaoJDBC(connection);
            ClienteDAO clienteDAO = new ClienteDaoJDBC();

            (clienteDAO.getAllCients()).forEach(clienteDTO -> System.out.println(clienteDTO.toString()));

            //connection.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            /*try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            /*try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }*/
        }
    }
}
