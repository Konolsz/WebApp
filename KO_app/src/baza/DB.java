
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
