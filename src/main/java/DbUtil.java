import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.coderslab.entity.User;

import java.sql.*;
import java.util.Arrays;

public class DbUtil {
    //list of queries
    public static final String DB_URL = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    public static final String  DB_USER = "root";
    public static final String  DB_PASS = "ciapek123";
    public static final String DELETE_QUERY = "";
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

    public static void insert(Connection conn, String query, String... params) {
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
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


