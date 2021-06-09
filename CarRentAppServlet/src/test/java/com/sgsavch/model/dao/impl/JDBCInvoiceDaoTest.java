package com.sgsavch.model.dao.impl;


public class JDBCInvoiceDaoTest {
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
//
//    @Test
//    public  void shouldReturnListOfTeams() throws SQLException{
//
//        String expected = "[teamB, teamX]";
//        String result = dbManager.findAllTeams().toString();
//        //teams = [teamB, teamX]
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