import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class GUI extends JFrame implements ActionListener {
    JButton Login = new JButton("LOGIN");
    JButton SignUp = new JButton("SIGN UP");

    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(100, 100);
        Login.addActionListener(this);
        SignUp.addActionListener(this);
        JFrame firstFrame = null;
        firstFrame.add(Login);
        firstFrame.add(SignUp);
        firstFrame = new JFrame();
        firstFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == Login)
        {
            new LoginGUI();
            dispose();
        } else if(source == SignUp)
        {
            new SignUpGUI();
            dispose();
        }
    }
