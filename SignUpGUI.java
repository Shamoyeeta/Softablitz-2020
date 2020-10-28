import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUpGUI extends JFrame {
//    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField name;
    private JTextField email;
    private JTextField username;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    public SignUpGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("SIGN UP");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("Name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblEmailAddress = new JLabel("Email\r\n address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(58, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        name = new JTextField();
       name.setFont(new Font("Tahoma", Font.PLAIN, 32));
       name.setBounds(214, 151, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(214, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(542, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);
        SignUpGUI frame = new SignUpGUI();
        frame.setVisible(true);

        btnNewButton = new JButton("SIGN UP");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = name.getText();
                String emailId = email.getText();
                String userName = username.getText();
                String password = passwordField.getText();
                Signup.User.createNewUser(firstName, emailId, userName, password);

            }
        }
    }
}