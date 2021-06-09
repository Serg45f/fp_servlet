package com.sgsavch.model.dao.impl;


import com.sgsavch.model.dao.DaoFactory;
import com.sgsavch.model.dao.VehicleDao;
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

public class JDBCCarModelDaoTest {
    private static final String JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String URL_CONNECTION = "jdbc:h2:~/test;user=root;password=root;";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String USE_SSL = "false";
    //@Spy //actually this annotation is not necessary here
    DaoFactory daoFactory = DaoFactory.getInstance();
    @BeforeClass
    public static void beforeTest() throws SQLException, ClassNotFoundException, IOException {
        Class.forName(JDBC_DRIVER);
        try (OutputStream output = new FileOutputStream("app.properties")) {
            Properties prop = new Properties();
            prop.setProperty("connection.url", URL_CONNECTION);
            prop.setProperty("useSSl", USE_SSL);
            prop.store(output, null);
        } catch (FileNotFoundException io) {
            io.printStackTrace();
        }
        //dbManager = DBManager.getInstance();
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS users ( \n" +
                    "id INTEGER(11) NOT NULL AUTO_INCREMENT, \n" +
                    "login VARCHAR(20) NOT NULL, \n" +
                    "PRIMARY KEY (id)); \n" +
                    "CREATE TABLE IF NOT EXISTS teams (\n" +
                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
                    " name VARCHAR(20) NOT NULL, \n" +
                    "  PRIMARY KEY (id)); \n" +
                    "CREATE TABLE IF NOT EXISTS users_teams ( \n" +
                    "user_id INTEGER(11) REFERENCES users(id) ON DELETE CASCADE, \n" +
                    "team_id INTEGER(11) REFERENCES teams(id) ON DELETE CASCADE, \n" +
                    "UNIQUE (user_id, team_id));";

            statement.executeUpdate(sql);

        }
    }

    @Test
    public  void shouldReturnVehicleById() throws SQLException{
        VehicleDao dao = daoFactory.createVehicleDao();
        String expected = "Vehicle(id=191, carmodel=CarModel(id=187, name=BMW-i3, seatsNumb=5, doorsNumb=4, picture=0b70617a-6ee9-4de2-8b1f-5501366d8132.bmw-i3.png, type=ELECTRIC, status=PREMIUM, price=100.0, deposit=1000.0), regNumber=ВН0377ВТ, yearIssue=2014-06-03T00:00, color=BLACK, transmission=MANUAL, discount=0.0, manager=User(id=3, email=iii@gmail.com, phone=null, activationCode=null, password=$2a$12$N1FeRkVz34UGV5g1D3OS0u3XfT9i3DWozksNl4YF/RV41gkMQuaKe, firstName=Ivan, lastName=Ivanov, roles=[USER], status=ACTIVE, passportNumb=null, passDateExp=null, country=null, licenseNumb=null, cardNumb=null))";
        String result = dao.findById(191).toString();

        assertEquals(expected,result);
    }

//    @Test
//    public  void shouldReturnTeam() throws SQLException{
//
//        String expected = "teamB";
//       // String result = dbManager.getTeam("teamB").toString();
//
//        assertEquals(expected,result);
//        //teams = [teamB]
//    }
//
//    @Test
//    public  void shouldSetTeamsForUser() throws SQLException{
//        User userIvanov = dbManager.getUser("ivanov");
//        Team teamB = dbManager.getTeam("teamB");
//        dbManager.setTeamsForUser(userIvanov,teamB);
//        String expected = "[teamB]";
//        String result = dbManager.getUserTeams(userIvanov).toString();
//        //teams = [teamB]
//
//        assertEquals(expected,result);
//    }

    @AfterClass
    public static void afterTest() throws SQLException, ClassNotFoundException, IOException {
        Class.forName(JDBC_DRIVER);
        try (OutputStream output = new FileOutputStream("app.properties")) {
            Properties prop = new Properties();
            prop.setProperty("connection.url", URL_CONNECTION);
            prop.setProperty("useSSl", USE_SSL);
            prop.store(output, null);
        } catch (FileNotFoundException io) {
            io.printStackTrace();
        }
      //  dbManager = DBManager.getInstance();
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement statement = con.createStatement()) {
            String sql = "DROP SCHEMA test IF EXISTS";
            statement.executeUpdate(sql);

        }
    }


}