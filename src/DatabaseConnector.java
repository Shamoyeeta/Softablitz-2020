import javax.swing.*;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

class DatabaseConnector {
    Connection connection=null;
    private static String user=getUser() ;
    private static String pswd=getPswd();
    boolean statusVal=false;

  //  private static String username;
  //  private static String pass;

//    static {
//        DatabaseCredentials form = new DatabaseCredentials();
//        username=form.getUsername();
//        pass=form.getPass();
//    }

    static String getUser() {
//        System.out.println("Enter user name of database: ");
//        Scanner sc = new Scanner(System.in);
//        return sc.next();
        return DatabaseCredentials.getUsername();
    }

    static String getPswd() {
//        System.out.println("Enter password of database: ");
//        Scanner sc = new Scanner(System.in);
//        return sc.next();
        return DatabaseCredentials.getPswd();
    }
    boolean getStatus()
    {
        return statusVal;
    }

    public DatabaseConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/FOODPILE";
            connection = DriverManager.getConnection(url, user, pswd);
            statusVal=true;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(new JFrame(),"Could not find JDBC driver!","Database Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(),"Could not connect to Database, please check credentials again!","Database Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            new DatabaseCredentials();
        }


    }

}
