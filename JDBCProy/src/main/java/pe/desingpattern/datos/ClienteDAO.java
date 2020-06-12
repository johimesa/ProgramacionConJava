package pe.desingpattern.datos;

import pe.desingpattern.domain.ClienteDTO;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 24/05/2020
 **/
public interface ClienteDAO {

    List<ClienteDTO> getAllCients() throws SQLException, ClassNotFoundException;
    int updateClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException;
    int insertClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException;
    int deleteClient(ClienteDTO cliente) throws SQLException, ClassNotFoundException;
}
