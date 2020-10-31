import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginForm {
    private JPanel Main;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel username;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JButton submit;
    private JButton clear;
    private JLabel title;
    private JButton signup;
    private JPanel panel4;

    public static void LogIn() {
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public LoginForm() {
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Dashboard.dashboard();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpForm.signUp();
            }
        });


    }
}
