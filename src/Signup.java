import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup {

    public User createNewUser(String username,String name,String email,String password) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector=new DatabaseConnector();
        String sql= "INSERT into user(username,email,name,password) values(?,?,?,?);";
        PreparedStatement statement=connector.connection.prepareStatement(sql);
        statement.setString(1,username);
        statement.setString(2,email);
        statement.setString(3,name);
        statement.setString(4,password);
        int i= statement.executeUpdate();
        User user=null;
        if (i>0)  {
            //successful registration,show a dialog box
            user= new User();
            user.setName(name);
            user.setPassword(password);
            user.setUsername(username);
            user.setEmail(email);
        }
        else  {
            //registration unsuccessful
        }
        connector.connection.close();
        return user;
    }
}
