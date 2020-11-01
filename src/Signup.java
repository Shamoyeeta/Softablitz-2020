import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Signup {

    public User createNewUser(String username,String name,String email,String password) {
        DatabaseConnector connector=new DatabaseConnector();
        String sql= "INSERT into user(username,email,name,password) values(?,?,?,?);";
        PreparedStatement statement= null;
        User user=null;
        try {
            statement = connector.connection.prepareStatement(sql);
            statement.setString(1,username);
            statement.setString(2,email);
            statement.setString(3,name);
            statement.setString(4,password);
            int i= statement.executeUpdate();
            if (i>0)  {

                user= new User();
                user.setName(name);
                user.setPassword(password);
                user.setUsername(username);
                user.setEmail(email);
            }
//            else  {
//                //registration unsuccessful
//            }
            connector.connection.close();
        } catch (SQLException throwables) {
            //JOptionPane.showMessageDialog(new JFrame(),"Could not sign up, probably due to non-unique username. Try with another username.","Sign Up error",JOptionPane.ERROR_MESSAGE);
            throwables.printStackTrace();
        }
        finally {
            return user;
        }
    }
}
