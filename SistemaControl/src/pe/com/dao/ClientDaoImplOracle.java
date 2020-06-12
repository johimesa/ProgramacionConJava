package pe.com.dao;

import pe.com.data.Conexion;
import pe.com.domain.ClientDTO;
import pe.com.util.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 09/06/2020
 **/
public class ClientDaoImplOracle implements ClientDao {

    public ClientDaoImplOracle(){}

    public List<ClientDTO> getClients() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ClientDTO> lista = new ArrayList<>();

        con = Conexion.getConection();
        ps = con.prepareStatement(Constants.SQL_SELECT);
        rs = ps.executeQuery();

        while (rs.next()) {
            ClientDTO client = new ClientDTO();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("nombre"));
            client.setLastname(rs.getString("apellidos"));
            client.setBalance(rs.getDouble("saldo"));

            lista.add(client);
        }

        // Cerrando recursos
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(con);

        return lista;
    }

    public ClientDTO getClientById(ClientDTO client) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        con = Conexion.getConection();
        ps = con.prepareStatement(Constants.SQL_SELECT_BY_ID);
        ps.setInt(1, client.getId());

        rs = ps.executeQuery();
        //rs.absolute(1);
        
        while(rs.next()) {
        	client = new ClientDTO();
            client.setId(rs.getInt("id"));
            client.setName(rs.getString("nombre"));
            client.setLastname(rs.getString("apellidos"));
            client.setBalance(rs.getDouble("saldo"));
        }
        System.out.println("Cliente obtenido: " + client);
        // Cerrando recursos
        Conexion.close(rs);
        Conexion.close(ps);
        Conexion.close(con);

        return client;
    }

    public int addClient(ClientDTO client) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        con = Conexion.getConection();
        ps = con.prepareStatement(Constants.SQL_INSERT);
        ps.setInt(1, client.getId());
        ps.setString(2, client.getName());
        ps.setString(3, client.getLastname());
        ps.setDouble(4, client.getBalance());

        int result = ps.executeUpdate();

        // Cerrando recursos
        Conexion.close(ps);
        Conexion.close(con);

        return result;
    }

    public int updateClient(ClientDTO client) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        con = Conexion.getConection();
        ps = con.prepareStatement(Constants.SQL_UPDATE);
        ps.setString(1, client.getLastname());
        ps.setDouble(2, client.getBalance());
        ps.setInt(3, client.getId());

        int result = ps.executeUpdate();

        // Cerrando recursos
        Conexion.close(ps);
        Conexion.close(con);

        return result;
    }

    public int deleteClient(ClientDTO client) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;

        con = Conexion.getConection();
        ps = con.prepareStatement(Constants.SQL_DELETE);
        ps.setInt(1, client.getId());
        
        int result = ps.executeUpdate();
        
        // Cerrando recursos
        Conexion.close(ps);
        Conexion.close(con);
        
        return result;
    }
}
