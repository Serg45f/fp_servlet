package com.sgsavch.model.dao.impl;


import com.sgsavch.model.dao.DaoFactory;

public class JDBCVehicleDaoTest {
    DaoFactory daoFactory = DaoFactory.getInstance();
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
//            String sql = "CREATE TABLE IF NOT EXISTS users ( \n" +
//                    "id INTEGER(11) NOT NULL AUTO_INCREMENT, \n" +
//                    "login VARCHAR(20) NOT NULL, \n" +
//                    "PRIMARY KEY (id)); \n" +
//                    "CREATE TABLE IF NOT EXISTS teams (\n" +
//                    "  id INTEGER(11) NOT NULL AUTO_INCREMENT,\n" +
//                    " name VARCHAR(20) NOT NULL, \n" +
//                    "  PRIMARY KEY (id)); \n" +
//                    "CREATE TABLE IF NOT EXISTS users_teams ( \n" +
//                    "user_id INTEGER(11) REFERENCES users(id) ON DELETE CASCADE, \n" +
//                    "team_id INTEGER(11) REFERENCES teams(id) ON DELETE CASCADE, \n" +
//                    "UNIQUE (user_id, team_id));";
//
//            statement.executeUpdate(sql);
//
//        }
//    }
//
//    @Test
//    public  void shouldReturnNullIfWrongUser() throws SQLException{
//        User user = dbManager.getUser("man");
//        assertNull(user);
//    }
//
//    @Test
//    public  void shouldReturnNullIfWrongTeam() throws SQLException{
//        Team team = dbManager.getTeam("teamD");
//        assertNull(team);
//    }
//
//    @Test(timeout = 1000)
//    public  void getConnectionShouldReturnFasterThenOneSecond(){
//        Connection con = null;
//        try {
//            con = DriverManager.getConnection(DB_URL, USER, PASS);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        assertNotNull(con);
//    }
//
//    @Test
//    public  void shouldReturnTeamFromResultSet() throws SQLException, InvocationTargetException, IllegalAccessException {
//        Team team = null;
//
//        ResultSet rs = null;
//
//        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//             PreparedStatement pstmt = con.prepareStatement(SQL_FIND_TEAM_BY_NAME)) {
//            int k = 1;
//            pstmt.setString(k++, "ivanov");
//            rs = pstmt.executeQuery();
//            if (rs.next()) {
//
//                Method m = dbManager.getClass().getMethod("com.epam.rd.java.basic.practice8.DBManager.mapTeam", ResultSet.class);
//                team = (Team)m.invoke(dbManager,rs);
//            }
//        } catch (SQLException | NoSuchMethodException e) {
//            e.printStackTrace();
//
//        } finally {
//            rs.close();
//
//            assertEquals("ivanov", team);
//        }
//    }
//
//    @AfterClass
//    public static void afterTest() throws SQLException, ClassNotFoundException, IOException {
//        /*
//        Class.forName(JDBC_DRIVER);
//        try (OutputStream output = new FileOutputStream("app.properties")) {
//            Properties prop = new Properties();
//            prop.setProperty("connection.url", URL_CONNECTION);
//            prop.setProperty("useSSl", USE_SSL);
//            prop.store(output, null);
//        } catch (FileNotFoundException io) {
//            io.printStackTrace();
//        }
//
//         */
//        dbManager = DBManager.getInstance();
//        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
//             Statement statement = con.createStatement()) {
//            String sql = "DROP SCHEMA test IF EXISTS";
//            statement.executeUpdate(sql);
//
//        }
//    }


}