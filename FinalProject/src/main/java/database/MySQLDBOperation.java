package database;

import Helper.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBOperation extends Logger {
    protected Connection con;
    protected PreparedStatement statement;
    protected ResultSet resultSet;

    private String url = "jdbc:mysql://localhost:3306/java_final_project";
    private String driver = "com.mysql.cj.jdbc.Driver";
    public void connect(){
        try {
            Class.forName(driver);
            this.con = DriverManager.getConnection(url,"root","root123");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void search(String query){
        try {
            statement = con.prepareStatement(query);
            this.resultSet = statement.executeQuery();
        } catch (SQLException e) {
            print(e.getMessage());
        }
    }

    public void insert(String query) throws SQLException {
        statement = con.prepareStatement(query);

    }
    public ResultSet returnResult()
    {
        return this.resultSet;
    }
    public void disconnectDb()
    {
        try {
            con.close();
        } catch (SQLException e) {
            print(e.getMessage());
        }
    }

}
