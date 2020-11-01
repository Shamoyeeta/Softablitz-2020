import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
    private static JFrame frame;

    public static void signUp() {
        frame = new JFrame("Sign Up Form");
        frame.setContentPane(new SignUpForm().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SignUpForm() {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                passwordField1.setText("");
                emailTextField.setText("");
                usernameTextField.setText("");
            }
        });


        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User currentUser=new Signup().createNewUser(usernameTextField.getText(),nameTextField.getText(),emailTextField.getText(), new String(passwordField1.getPassword()));
                if (currentUser!=null){
                    frame.dispose();
                    Dashboard.dashboard(currentUser);
                }
                else {
                    JOptionPane.showMessageDialog(new JFrame(),"Could not sign up, probably due to non-unique username. Try with another username.","Sign Up error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               frame.dispose();
               LoginForm.LogIn();
            }
        });
    }
}
