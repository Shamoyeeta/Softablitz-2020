import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        SignUpForm.signUp();
        DatabaseCredentials.datebaseCredentialForm();
        DatabaseConnector connector=new DatabaseConnector();
        connector.connection.close();
        User user;
        user= new Login().checkLogin("Kiwi","123456");
        //user= new Signup().createNewUser("qwerty","Keyboard","qwerty@gmail.com","123456");
        Product product=new Product("Eggs","FOOD","EGG",90,12,5);
        user.removeItem(product);
        System.out.println("User:");
        System.out.println(user.getEmail()+"\t"+user.getName()+"\t"+user.getUsername());
        User user1=new Signup().createNewUser("pixel","Raindrop","qwerty@gmail.com","123456");
        System.out.println(user1.getEmail()+"\t"+user1.getName()+"\t"+user1.getUsername());
    }
}
