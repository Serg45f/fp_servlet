package com.sgsavch.model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class ConnectionPoolHolder {
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){
        ResourceBundle bundle = ResourceBundle.getBundle("application");

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(bundle.getString("datasource.url"));
                    ds.setDriverClassName(bundle.getString("datasource.driver"));//
                    ds.setUsername(bundle.getString("datasource.username"));
                    ds.setPassword(bundle.getString("datasource.password"));
                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(100);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }


}
