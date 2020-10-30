import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProfile {
    private JPanel main;
    private JScrollPane scroll;
    private JTable table1;
    private JLabel usernameLabel;
    private JButton logOutButton;
    private JPanel panel2;
    private JTextField IDtextField;
    private JTextField nameTextField;
    private JTextField quantityTextField;
    private JButton goBackButton;
    String[] columns={"Product","Changes"};

    public MyProfile() {
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logOutButton.addActionListener(new ActionListener() {
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
        scroll = new JScrollPane(table1);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(new EmptyBorder(20,20,20,20));
        //fillTable(model);
    }
}
