import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DatabaseCredentials {

    private JPanel panel1;
    private JLabel usernameLabel;
    private JTextField usernametextField;
    private JLabel pswdLabel;
    private JPasswordField pswdField;
    private JLabel title;
    private JButton submitButton;
    private JPanel panel2;
    private JPanel panel3;
    private static JFrame frame;

    private static String username;
    private static String pswd;

    public static String getUsername() {
        return username;
    }

    public static String getPswd() {
        return pswd;
    }

    public DatabaseCredentials() {
        username = "";
        pswd="";

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernametextField.getText();
                pswd =new String(pswdField.getPassword());

                DatabaseConnector db =new DatabaseConnector();
                if (db.getStatus()==true){
                    frame.dispose();
                    new LoginForm().LogIn();
                }
//                DatabaseConnector.getUser(username);
//                DatabaseConnector.getPswd(pswd);
            }
        }

        );
    }

    public static void databaseCredentialForm() {
        frame = new JFrame("DatabaseCredentials");
        frame.setContentPane(new DatabaseCredentials().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

