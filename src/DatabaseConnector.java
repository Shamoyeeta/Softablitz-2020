import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class DatabaseConnector {
    Connection connection=null;
    private final static String user=getUser() ;
    private final static String pswd=getPswd();
  //  private static String username;
  //  private static String pass;

//    static {
//        DatabaseCredentials form = new DatabaseCredentials();
//        username=form.getUsername();
//        pass=form.getPass();
//    }

    static String getUser() {
        System.out.println("Enter user name of database: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    static String getPswd() {
        System.out.println("Enter password of database: ");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/FOODPILE";
            connection = DriverManager.getConnection(url, user, pswd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
