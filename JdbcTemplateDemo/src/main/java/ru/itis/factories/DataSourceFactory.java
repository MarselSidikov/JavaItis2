package ru.itis.factories;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataSourceFactory {
    private static DataSourceFactory dataSourceFactory;

    private DataSource dataSource;

    private Properties properties;

    private DataSourceFactory() {
        Properties properties = new Properties();

        try {
            properties.load(new
                    FileInputStream("C:\\Users" +
                    "\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\JavaItis2\\JdbcTemplateDemo\\src\\main\\resources\\datasource.properties"));

            String driverName = properties.getProperty("database.driver");
            String url = properties.getProperty("database.url");
            String name = properties.getProperty("database.name");
            String password = properties.getProperty("database.password");

            DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
            driverManagerDataSource.setDriverClassName(driverName);
            driverManagerDataSource.setUrl(url);
            driverManagerDataSource.setUsername(name);
            driverManagerDataSource.setPassword(password);

            this.dataSource = driverManagerDataSource;

        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    static {
        dataSourceFactory = new DataSourceFactory();
    }

    public static DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
