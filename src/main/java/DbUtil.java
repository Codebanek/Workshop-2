import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.coderslab.entity.User;

import java.sql.*;
import java.util.Arrays;

public class DbUtil {
    //list of queries
    public static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    public static final String  DB_USER = "root";
    public static final String  DB_PASS = "ciapek123";
    public static final String CREATE_USER_QUERY = "INSERT INTO workshop2.users(username, email, password) VALUES (?, ?, ?)";
    public static final String UPDATE_USER_QUERY =
            "UPDATE users SET username = ?, email = ?, password = ? where id = ?";

    public static final String READ_USER_QUERY =
            "SELECT * FROM users where id = ?";
    public static final String DELETE_USER_QUERY =
            "DELETE FROM users WHERE id = ?";
    public static final String FIND_ALL_USERS_QUERY =
            "SELECT * FROM users";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    }
    public static User[] addToArray(User u, User[] users) {

        User[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
        tmpUsers[users.length] = u; // Dodajemy obiekt na ostatniej pozycji.
        System.out.print(tmpUsers[tmpUsers.length-1].getId()+", ");
        System.out.print(tmpUsers[tmpUsers.length-1].getEmail()+", ");
        System.out.println(tmpUsers[tmpUsers.length-1].getUserName()+", ");
      //  System.out.println(Arrays.toString(tmpUsers));
        return tmpUsers; // Zwracamy nową tablicę.
    }






}


