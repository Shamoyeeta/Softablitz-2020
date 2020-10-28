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

    String username;
    String pswd;


    public DatabaseCredentials() {
//        usernametextField=new JTextField();
//        pswdField=new JPasswordField();
//        submitButton = new JButton();
//        title = new JLabel();
//        usernameLabel = new JLabel();
//        pswdLabel = new JLabel();
//        JFrame frame = new JFrame("Database credentials");
//
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        frame.setSize(500,500);
//        frame.add(panel1);
//        frame.add(panel2);
//        frame.add(panel3);
//
//
//        panel1.add(title);
//        panel2.add(usernameLabel);


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username = usernametextField.getText();
                pswd = pswdField.getPassword().toString();
                System.out.println(username+"  "+pswd);
//                DatabaseConnector.getUser(username);
//                DatabaseConnector.getPswd(pswd);
            }
        }

        );
    }

    public static void datebaseCredentialForm() {
        JFrame frame = new JFrame("DatabaseCredentials");
        frame.setContentPane(new DatabaseCredentials().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

