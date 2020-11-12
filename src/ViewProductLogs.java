import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ViewProductLogs {
    private JTable table1;
    private JButton logOutButton;
    private JPanel panel2;
    private JPanel main;
    private JButton deleteProductButton;
    private JButton updateProductButton;
    private JTextField IDtextField;
    private JTextField nameTextField;
    private JTextField categoryTextField;
    private JTextField priceTextField;
    private JTextField quantityTextField;
    private JTextField thresholdTextField;
    private JLabel usernameLabel;
    private JButton goBackButton;
    private JScrollPane scroll;
    private static JFrame frame;
    String[] columns={"User","Changes"};
    //private User currentUser;
    //private Product product;
    DefaultTableModel model;

    public static JFrame getFrame() {
        return frame;
    }

    public ViewProductLogs(Product product, User user) {
        usernameLabel.setText("Welcome, "+user.getUsername());

        IDtextField.setText(product.getID());
        nameTextField.setText(product.getName());
        categoryTextField.setText(product.getCategory());
        priceTextField.setText(String.valueOf(product.getPrice()));
        quantityTextField.setText(String.valueOf(product.getQuantity()));
        thresholdTextField.setText(String.valueOf(product.getThreshold()));


        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                LoginForm.LogIn();
            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Dashboard.dashboard(user);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.removeItem(product);
                frame.dispose();
                Dashboard.dashboard(user);
            }
        });

        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDetails.updateProductForm(user,product);
            }
        });
        fillTable(model,product);
    }

    private void createUIComponents() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);
        table1 = new JTable();
        table1.setModel(model);
        table1.setFillsViewportHeight(true);
        scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(new EmptyBorder(20,20,20,20));
    }

    private void fillTable(DefaultTableModel model,Product product) {
        List<ProductLog> logs=new SearchLogs().productLogsList(product.getID());
        for (ProductLog log:logs) {
            model.addRow(new Object[]{log.getUsername(),log.getChanges()});
        }
    }


    public static void viewProductDetails(Product product,User currentUser) {

        frame = new JFrame("ProductLogs");
        frame.setContentPane(new ViewProductLogs(product,currentUser).main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
