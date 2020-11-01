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
    private static JFrame frame;

    public static void LogIn() {
        frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public LoginForm() {
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
            }
        });
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User currentuser= new Login().checkLogin(usernameField.getText(), new String(passwordField.getPassword()));
                if (currentuser==null){
                    JOptionPane.showMessageDialog(new JFrame(),"No such User exists. Please check your credentials or try Signing up instead","Log In Error",JOptionPane.ERROR_MESSAGE);
                }
                else{
                    frame.dispose();
                    Dashboard.dashboard(currentuser);
                }
            }
        });
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                SignUpForm.signUp();
            }
        });


    }
}
