package pe.com.dao;

import pe.com.domain.ClientDTO;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 09/06/2020
 **/
public interface ClientDao {

    List<ClientDTO> getClients() throws SQLException;
    ClientDTO getClientById(ClientDTO client) throws SQLException;
    int addClient(ClientDTO client) throws SQLException;
    int updateClient(ClientDTO client) throws SQLException;
    int deleteClient(ClientDTO client) throws SQLException;

}
