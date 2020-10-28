import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpForm {
    private JPanel Main;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JTextField usernameTextField;
    private JLabel usernameLabel;
    private JPasswordField passwordField1;
    private JLabel passwordLabel;
    private JLabel title;
    private JButton clearButton;
    private JButton signUpButton;
    private JLabel loginLabel;
    private JButton logInButton;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;

    public static void signUp(String[] args) {
        JFrame frame = new JFrame("Sign Up Form");
        frame.setContentPane(new SignUpForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SignUpForm() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
