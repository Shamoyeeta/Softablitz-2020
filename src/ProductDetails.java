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
    private double lastDouble=0.0;


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

    public ProductDetails() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
    }

    public static void main(String[] args) {//addProduct() {
        JFrame frame = new JFrame("ProductDetails");
        frame.setContentPane(new ProductDetails().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
