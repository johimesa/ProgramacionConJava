package pe.com.data;

import org.apache.commons.dbcp2.BasicDataSource;
import pe.com.util.Constants;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: Hilario
 * @Version: 1.0
 * Date: 09/06/2020
 **/
public class Conexion {
	
	// esto es una mejora, esto para que no se cree cada vez q sea llamado
	private static BasicDataSource basicDataSource;
	
    public static DataSource getDataSource() {
    	/*
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(Constants.JDBC_URL);
        basicDataSource.setUsername(Constants.JDBC_USER);
        basicDataSource.setPassword(Constants.JDBC_PASS);
        basicDataSource.setInitialSize(50);*/
    	
    	if(basicDataSource == null) {
    		basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(Constants.JDBC_URL);
            basicDataSource.setUsername(Constants.JDBC_USER);
            basicDataSource.setPassword(Constants.JDBC_PASS);
            basicDataSource.setInitialSize(50);
    	}
    	
        return basicDataSource;
    }

    public static Connection getConection() throws SQLException {
        return getDataSource().getConnection();
    }

    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement ps) {
        try {
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }

    public static void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace(System.out);
        }
    }
}
