import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

public class Dashboard {
    private JPanel main;
    private JTable table1;
    private JScrollPane scroll;
    private JButton logOutButton;
    private JPanel panel1;
    private JPanel panel2;
    private JButton myProfileButton;
    private JButton addNewProductButton;
    private JButton searchProductButton;
    String[] columns= {"Product ID","Product Name","Category","Price"};

    public Dashboard() {
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2) {
                    JTable target = (JTable) e.getSource();
                    int row = target.getSelectedRow();
                    String ID = (String) table1.getValueAt(row, 0);
                    System.out.println(ID);
                }
            }
        });

        myProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        addNewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
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

    public static void main(String[] args) throws SQLException {
        DatabaseConnector connector = new DatabaseConnector();
        connector.connection.close();
        JFrame frame = new JFrame("Dashboard");
        frame.setContentPane(new Dashboard().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void fillTable(DefaultTableModel model) {

        try {
            List<Product> products = new SearchProducts().searchAll();
            for (Product product : products) {
                model.addRow(new Object[]{product.getID(),product.getName(),product.getCategory(),product.getPrice()});
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
