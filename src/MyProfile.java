import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MyProfile {
    private JPanel main;
    private JScrollPane scroll;
    private JTable table1;
    private JLabel usernameLabel;
    private JButton logOutButton;
    private JPanel panel2;
    private JTextField usernameTextField;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JButton goBackButton;
    private JPanel main1;
    String[] columns={"Product","Changes"};
    private static JFrame frame;
    User currentUser;

    public MyProfile(User user) {
        this.currentUser=user;
        usernameTextField.setText(currentUser.getUsername());
        usernameLabel.setText("Welcome, "+currentUser.getUsername());
        nameTextField.setText(currentUser.getName());
        emailTextField.setText(currentUser.getEmail());

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginForm.LogIn();
            }
        });
    }

    public static void viewMyProfile(User user) {
        frame = new JFrame("MyProfile");
        frame.setContentPane(new MyProfile(user).main1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table1 = new JTable();
        table1.setModel(model);
        //table1.getAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setFillsViewportHeight(true);
        scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(new EmptyBorder(20,20,20,20));
        fillTable(model);
    }

    private void fillTable(DefaultTableModel model) {
        List<ProductLog> productLogs = new SearchLogs().userLogsList(currentUser.getUsername());
        for (ProductLog log : productLogs) {
            model.addRow(new Object[]{log.getProductID(),log.getChanges()});
        }
    }
}
