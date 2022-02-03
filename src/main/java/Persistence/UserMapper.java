package Persistence;

import entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {

    public ArrayList<String> getAllUserNames() {
        ArrayList<String> names = new ArrayList<>();
        try (Connection connection = DBConnector.connection()){
            String SQL = "Select fname from usertable";
            try (PreparedStatement ps = connection.prepareStatement(SQL)){
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String fname =rs.getString("fname");
                    names.add(fname);
                }
                return names;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    public ArrayList<User> getUserByID(int i) {
        return null;
    }
}
