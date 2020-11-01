import com.sun.jdi.DoubleValue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductDetails {
    private JPanel Main;
    private JPanel panel1;
    private JLabel title;
    private JTextField nameTextField;
    private JTextField thresholdTextField;
    private JTextField categoryTextField;
    private JTextField idTextField;
    private JTextField priceTextField;
    private JTextField quantityTextField;
    private JButton resetButton;
    private JButton submitButton;
    private JLabel validationLabel;
    private JButton cancelButton;
    private JButton updateButton;
    private double lastDouble=0.0;
    private static JFrame frame;
    private User currentUser;

    private void handleKeyReleased(JTextField textField){
        String text = textField.getText();
        if (text.isEmpty()) return;
        try {
            lastDouble = Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            textField.setText(lastDouble + "");
            validationLabel.setText("*Enter only decimal numbers");
        }
    }

    public ProductDetails(User currentUser) {
        this.currentUser=currentUser;
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentUser.addItem(nameTextField.getText(),categoryTextField.getText(),idTextField.getText(), Double.parseDouble(priceTextField.getText()),Double.parseDouble(quantityTextField.getText()),Double.parseDouble(thresholdTextField.getText()));
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                priceTextField.setText("");
                quantityTextField.setText("0");
                priceTextField.setText("0");
                categoryTextField.setText("");
                thresholdTextField.setText("0");
                idTextField.setText("");
            }
        });

        priceTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyReleased(priceTextField);
            }
        });

        quantityTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        thresholdTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
        updateButton.addActionListener(new ActionListener() {//TODO: Fix bug in update query
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.updateItem(nameTextField.getText(),categoryTextField.getText(),idTextField.getText(), Double.parseDouble(priceTextField.getText()),Double.parseDouble(quantityTextField.getText()),Double.parseDouble(thresholdTextField.getText()));
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
        updateButton.setVisible(false);
    }

    public static void addProductForm(User user) {//addProduct() {
        frame = new JFrame("ProductDetails");
        frame.setContentPane(new ProductDetails(user).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //submitButton.setVisible(true);
        //updateButton.setVisible(false);
        //idTextField.setEditable(true);
    }


    public ProductDetails(User currentUser, Product product) {
        this.currentUser=currentUser;
        idTextField.setEditable(false);
        idTextField.setText(product.getID());
        categoryTextField.setText(product.getCategory());
        nameTextField.setText(product.getName());
        priceTextField.setText(String.valueOf(product.getPrice()));
        quantityTextField.setText(String.valueOf(product.getQuantity()));
        thresholdTextField.setText(String.valueOf(product.getThreshold()));

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentUser.addItem(nameTextField.getText(),categoryTextField.getText(),idTextField.getText(), Double.parseDouble(priceTextField.getText()),Double.parseDouble(quantityTextField.getText()),Double.parseDouble(thresholdTextField.getText()));
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
        submitButton.setVisible(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                priceTextField.setText("");
                quantityTextField.setText("0");
                priceTextField.setText("0");
                categoryTextField.setText("");
                thresholdTextField.setText("0");
                idTextField.setText("");
            }
        });

        priceTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                handleKeyReleased(priceTextField);
            }
        });

        quantityTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        thresholdTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentUser.updateItem(nameTextField.getText(),categoryTextField.getText(),idTextField.getText(), Double.parseDouble(priceTextField.getText()),Double.parseDouble(quantityTextField.getText()),Double.parseDouble(thresholdTextField.getText()));
                frame.dispose();
                Dashboard.dashboard(currentUser);
            }
        });
    }

    public static void updateProductForm(User user,Product product) {

        frame = new JFrame("ProductDetails");
        frame.setContentPane(new ProductDetails(user,product).Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        //updateButton.setVisible(true);
        //submitButton.setVisible(false);
        //idTextField.setEditable(false);
    }
}
