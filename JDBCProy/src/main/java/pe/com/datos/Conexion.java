package pe.com.datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 21/05/2020
 **/
public class Conexion {

    private static final String URL_JDBC = "jdbc:oracle:thin:@172.19.74.144:1521:TIMDEV";
    private static final String USER_JDBC = "pvu";
    private static final String PASS_JDBC = "pvu";

    // Pool de conexiones 24/05/2020
    public static DataSource getDataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(URL_JDBC);
        basicDataSource.setUsername(USER_JDBC);
        basicDataSource.setPassword(PASS_JDBC);
        basicDataSource.setInitialSize(5); // numero de conexiones

        return basicDataSource;
    }
    /*
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(URL_JDBC, USER_JDBC, PASS_JDBC);
    } */

    // Pool de conexiones 24/05/2020
    public static Connection getConexion() throws SQLException, ClassNotFoundException {
        return getDataSource().getConnection();
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            if(preparedStatement != null)
                preparedStatement.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            if(resultSet != null)
                resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection connection) {
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
