import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductLogs {
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
    String[] columns={"User","Changes"};

    public ProductLogs() {
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
        JScrollPane scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(new EmptyBorder(20,20,20,20));
        //fillTable(model);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ProductLogs");
        frame.setContentPane(new ProductLogs().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
