package pe.com.util;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 09/06/2020
 **/
public class Constants {

    // Clase Conexion
    public static final String JDBC_URL = "jdbc:oracle:thin:@172.19.74.144:1521:TIMDEV";
    public static final String JDBC_USER = "PVU";
    public static final String JDBC_PASS = "pvu";

    // Clase ClientDaoImplOracle
    public static final String SQL_SELECT = "select c.id, c.nombre, c.apellidos, c.saldo from cliente_web c order by c.id";
    public static final String SQL_SELECT_BY_ID = "select c.id, c.nombre, c.apellidos, c.saldo from cliente_web c where c.id=?";
    public static final String SQL_INSERT = "insert into cliente_web (id, nombre, apellidos, saldo) values (?, ?, ?, ?)";
    public static final String SQL_UPDATE = "update cliente_web c set c.apellidos=?, c.saldo=? where c.id=?";
    public static final String SQL_DELETE = "delete from cliente_web c where c.id=?";
}
