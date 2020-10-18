import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    public User checkLogin(String username, String password) {
        DatabaseConnector connector = new DatabaseConnector();
        String sql = "SELECT * from user where username = ? and password = ?;";
        PreparedStatement statement = null;
        User user = null;
        try {
            statement = connector.connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                user = new User();
                user.setName(result.getString("name"));
                user.setEmail(result.getString("email"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }
}
