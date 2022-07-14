import org.springframework.security.crypto.bcrypt.BCrypt;
import pl.coderslab.entity.User;
import java.sql.*;

public class UserDAO {
    public static final String CREATE_USER_QUERY = "INSERT INTO workshop2.users(username, email, password) VALUES (?, ?, ?)";

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    ;

    public static User create(User user) {

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User read(int userId) {
        int i = 1;
        try (Connection conn = DbUtil.getConnection()) {
            String readUsersId = "select * from workshop2.users where id='" + userId + "'";
            PreparedStatement statement = conn.prepareStatement(readUsersId, Statement.RETURN_GENERATED_KEYS);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(readUsersId);
            String id = null;
            String email = null;
            String username = null;
            String password = null;
            while (rs.next()) {
                id = rs.getString(1);
                username = rs.getString(2);
                email = rs.getString(3);
                password = rs.getString(4);
                System.out.println("id: " + id + '\n' + "username: " + username + '\n' + "email: " + email + '\n' + "password: " + password);
            }
            return new User (Integer.parseInt(id), email, username, password);

        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            System.out.println("Nie ma usera o takim id!");
            return null;
        }

    }
}
