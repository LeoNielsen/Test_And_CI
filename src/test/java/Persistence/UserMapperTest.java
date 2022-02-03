package Persistence;

import entities.User;
import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {

    @BeforeEach
    void setUp() {
        System.out.println("TESTINNNNGGGG");
        Connection con = null;
        try {
            con = DBConnector.connection();
            String emptyTable = "DROP TABLE startcode_test.usertable";
            con.prepareStatement(emptyTable).executeUpdate();
            String createTable = "CREATE TABLE IF NOT EXISTS `startcode_test`.`usertable` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `fname` VARCHAR(45) NULL,\n" +
                    "  `lname` VARCHAR(45) NULL,\n" +
                    "  `pw` VARCHAR(45) NULL,\n" +
                    "  `phone` VARCHAR(45) NULL,\n" +
                    "  `address` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`id`));";
            con.prepareStatement(createTable).executeUpdate();
            String SQL = "INSERT INTO startcode_test.usertable (fname, lname, pw, phone, address) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "Hans");
            ps.setString(2, "Hansen");
            ps.setString(3, "Hemmelig123");
            ps.setString(4, "40404040");
            ps.setString(5,"Rolighedsvej 3");
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllUserNamesTest(){
        ArrayList<String> expected = new ArrayList<>(List.of("Hans"));
        ArrayList<String> actual = new UserMapper().getAllUserNames();

        assertEquals(expected, actual);
    }

//    @Test
//    public void getUserByIDTest(){
//        ArrayList<User> expected = new ArrayList<>(List.of(new User("Hans", "Hansen", "Hemmelig123","40404040", "Rolighedsvej 3")));
//        ArrayList<User> actual = new UserMapper().getUserByID(1);
//
//        assertEquals(expected, actual);
//    }



}