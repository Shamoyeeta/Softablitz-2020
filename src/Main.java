import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user;
        user= new Login().checkLogin("Kiwi","123456");
        //user= new Signup().createNewUser("qwerty","Keyboard","qwerty@gmail.com","123456");
        System.out.println("User:");
        System.out.println(user.getEmail()+"\t"+user.getName()+"\t"+user.getUsername());
    }
}
