package org.example.config;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;

public class settings {

/**/
    private static DataSource setDataSource(){
        HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl("jdbc:mysql://10.0.0.22:3306/ebgsolut_abejas");
            ds.setUsername("root");
            ds.setPassword("Padames08$");
        return ds;
    }

    public static DataSource Connection(){
        DataSource connection = setDataSource();
        return connection;
    }
}
