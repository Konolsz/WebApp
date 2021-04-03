//package baza;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import model.Cennik;
//
//public class DB {
//	
//	
//	private String jdbcURL = "jdbc:mysql://localhost:3306/zamowienia?autoReconnect=true&useSSl=false";
//    private String jdbcUsername = "root";
//    private String jdbcPassword = "root";
//
//    private static final String INSERT_USERS_SQL = "INSERT INTO zamowienia.historia" +
//            "  (idHistoria, pizza, dodatkiPizza, danie, dodatkiDanie, zupy, napoje,uwagi,koszt) VALUES " +
//            " (?, ?, ?, ?, ?,?,?,?,?);";
//  
//    private static final String SELECT_ALL_USERS = "select * from zamowienia.historia";
// 
//
//    public DB() {}
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        return connection;
//    }
//
//    public void registerEmployee(Cennik c) throws ClassNotFoundException {
//    	 System.out.println(INSERT_USERS_SQL);
//         // try-with-resource statement will auto close the connection.
//         try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//
//        
//
//            // Step 2:Create a statement using connection object
//           
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, c.getPizza());
//            preparedStatement.setString(3, c.getDodatkiPizza());
//            preparedStatement.setString(4, c.getDanie());
//            preparedStatement.setString(5, c.getDodatkiDanie());
//            preparedStatement.setString(6, c.getZupy());
//            preparedStatement.setString(7, c.getNapoje());
//            preparedStatement.setString(8, c.getUwagi());
//            preparedStatement.setString(9, c.getKoszt());
//       
//
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//    }
//    public List < Cennik > selectAllUsers() {
//
//        // using try-with-resources to avoid closing resources (boiler plate code)
//        List < Cennik > users = new ArrayList < > ();
//        // Step 1: Establishing a Connection
//        try (Connection connection = getConnection();
//
//            // Step 2:Create a statement using connection object
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
//            System.out.println(preparedStatement);
//            // Step 3: Execute the query or update query
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Step 4: Process the ResultSet object.
//            while (rs.next()) {
//                int id = rs.getInt("idHistoria");
//                String pizza = rs.getString("pizza");
//                String dodatkiPizza = rs.getString("dodatkiPizza");
//                String danie = rs.getString("danie");
//                String dodatkiDanie = rs.getString("dodatkiDanie");
//                String zupy = rs.getString("zupy");
//                String napoje = rs.getString("napoje");
//                String uwagi = rs.getString("uwagi");
//                String koszt = rs.getString("koszt");
//                users.add(new Cennik(id, pizza, dodatkiPizza, danie,dodatkiDanie,zupy,napoje,uwagi,koszt));
//            }
//        } catch (SQLException e) {
//            printSQLException(e);
//        }
//        return users;
//    }
//    private void printSQLException(SQLException ex) {
//        for (Throwable e: ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
//}


package baza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Cennik;
 

public class DB {
    private String jdbcURL ="jdbc:mysql://localhost:3306/zamowienia";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root";
    private Connection jdbcConnection;
    

 

     
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
 
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     
    public boolean dodaj(Cennik c) throws SQLException {
        String sql = "INSERT INTO cennik" +
              "  (idCennik, pizza, dodatkiPizza, danie, dodatkiDanie, zupy, napoje,uwagi,koszt) VALUES " +
              " (?, ?, ?, ?, ?,?,?,?,?);";
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setInt(1, c.getIdCennik());
        statement.setString(2, c.getPizza());
        statement.setString(3, c.getDodatkiPizza());
        statement.setString(4, c.getDanie());
        statement.setString(5, c.getDodatkiDanie());
        statement.setString(6, c.getZupy());
        statement.setString(7, c.getNapoje());
        statement.setString(8, c.getUwagi());
        statement.setString(9, c.getKoszt());
         
        boolean dodaj = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return dodaj;
    }
     
    public List<Cennik> wyswietl() throws SQLException {
        List<Cennik> wyswietl = new ArrayList<>();
         
        String sql = "SELECT * FROM cennik";
         
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            int idCennik = resultSet.getInt("idCennik");
            String pizza = resultSet.getString("pizza");
            String dodatkiPizza = resultSet.getString("dodatkiPizza");
            String danie = resultSet.getString("danie");
            String dodatkiDanie = resultSet.getString("dodatkiDanie");
            String zupy = resultSet.getString("zupy");
            String napoje = resultSet.getString("napoje");
            String uwagi = resultSet.getString("uwagi");
            String koszt = resultSet.getString("koszt");
             
            Cennik c = new Cennik(idCennik, pizza, dodatkiPizza, danie, dodatkiDanie,zupy,napoje,uwagi,koszt);
            wyswietl.add(c);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return wyswietl;
    }
     
   
}