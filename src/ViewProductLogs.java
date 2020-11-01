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
    private User currentUser;
    private Product product;

    public ViewProductLogs(Product product,User user) {
        usernameLabel.setText("Welcome, "+user.getUsername());
        this.currentUser=user;
        this.product=product;

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
                Dashboard.dashboard(currentUser);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.removeItem(product);
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });

        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductDetails.updateProductForm(currentUser,product);
                //currentUser.updateItem(nameTextField.getText(),categoryTextField.getText(), IDtextField.getText(),Double.parseDouble(priceTextField.getText()),Double.parseDouble(quantityTextField.getText()),Double.parseDouble(thresholdTextField.getText()));
            }
        });
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
        //fillTable(model);

    }

    private void fillTable(DefaultTableModel model) { //TODO: fix bug in fillTable for product logs
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
