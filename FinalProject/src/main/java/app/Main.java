package app;

import model.BloodRequest;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main{

    public static void main(String[] args) throws SQLException {
        Application app = new Application();
        app.startApp();

        BloodRequest b = new BloodRequest();
        b.user_id = 8;
        b.status = true;
        b.blood = "A+";
    }
}