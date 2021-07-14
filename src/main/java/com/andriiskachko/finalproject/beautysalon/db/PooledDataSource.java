package com.andriiskachko.finalproject.beautysalon.db;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class PooledDataSource {

    private static BasicDataSource basicDS;
    static {
        try {
            basicDS = new BasicDataSource();
            Properties properties = new Properties();
            InputStream inputStream = new FileInputStream("C:\\Users\\Andrii\\IdeaProjects\\beautysalon\\src\\main\\resources\\db.properties");
            properties.load(inputStream);
            basicDS.setDriverClassName(properties.getProperty("DRIVER_CLASS")); //loads the jdbc driver
            basicDS.setUrl(properties.getProperty("DB_CONNECTION_URL"));
            basicDS.setUsername(properties.getProperty("DB_USER"));
            basicDS.setPassword(properties.getProperty("DB_PWD"));
            basicDS.setInitialSize(Integer.parseInt(properties.getProperty("DB_INITIAL_POOL_SIZE")));
            basicDS.setMaxTotal(Integer.parseInt(properties.getProperty("DB_MAX_POOL_SIZE")));

        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    private PooledDataSource() {
        throw new IllegalStateException("Utility class");
    }

    public static Connection getConnection() throws SQLException {
        Connection con = basicDS.getConnection();
        con.setAutoCommit(false);
        return con;
    }

    public static DataSource getDataSource() {
        return basicDS;
    }

    public static void commitAndClose(Connection con) {
        try {
            con.commit();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void rollbackAndClose(Connection con) {
        try {
            con.rollback();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
