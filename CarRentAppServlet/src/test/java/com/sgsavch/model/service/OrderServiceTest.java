package com.sgsavch.model.service;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class OrderServiceTest {
//    private static final String JDBC_DRIVER = "org.h2.Driver";
//    private static final String DB_URL = "jdbc:h2:~/test";
//    private static final String URL_CONNECTION = "jdbc:h2:~/test;user=root;password=root;";
//    private static final String USER = "root";
//    private static final String PASS = "root";
//    private static final String USE_SSL = "false";
//    //@Spy //actually this annotation is not necessary here
//    private static DBManager dbManager;
//    @BeforeClass
//    public static void beforeTest() throws SQLException, ClassNotFoundException, IOException {
//        Class.forName(JDBC_DRIVER);
//        try (OutputStream output = new FileOutputStream("app.properties")) {
//            Properties prop = new Properties();
//            prop.setProperty("connection.url", URL_CONNECTION);
//            prop.setProperty("useSSl", USE_SSL);
//            prop.store(output, null);
//        } catch (FileNotFoundException io) {
//            io.printStackTrace();
//        }
//        dbManager = DBManager.getInstance();
//        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement statement = con.createStatement()) {
//            String sql = "CREATE TABLE IF NOT EXISTS teams (\n" +
//                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
//                    " name VARCHAR(20) NOT NULL, \n" +
//                    "  PRIMARY KEY (id)); \n";
//            statement.executeUpdate(sql);
//
//        }
//    }
//    @Test
//    public  void shouldReturnOneTeam() throws SQLException{
//        //teams = [teamB, teamX]
//        Team teamX = dbManager.getTeam("teamX");
//        String expected = "teamX";
//        String result = teamX.toString();
//
//
//        assertEquals(expected,result);
//    }
//
//    @Test
//    public  void shouldDeleteOneTeam() throws SQLException{
//        //teams = [teamB, teamX]
//        Team teamB = dbManager.getTeam("teamB");
//        dbManager.deleteTeam(teamB);
//        String expected = "[teamX]";
//        String result = dbManager.findAllTeams().toString();
//        //teams = [teamX]
//
//        assertEquals(expected,result);
//    }
//
//    @AfterClass
//    public static void afterTest() throws SQLException, ClassNotFoundException, IOException {
//        Class.forName(JDBC_DRIVER);
//        try (OutputStream output = new FileOutputStream("app.properties")) {
//            Properties prop = new Properties();
//            prop.setProperty("connection.url", URL_CONNECTION);
//            prop.setProperty("useSSl", USE_SSL);
//            prop.store(output, null);
//        } catch (FileNotFoundException io) {
//            io.printStackTrace();
//        }
//        dbManager = DBManager.getInstance();
//        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement statement = con.createStatement()) {
//            String sql = "DROP SCHEMA test IF EXISTS";
//            statement.executeUpdate(sql);
//
//        }
//    }
//

}