import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;


class User {
    private String name, username, email;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    void addItem(String pname, String category, String ID, double price, double quantity, double threshold) {
        Product product = new Product(pname, category, ID, price, quantity, threshold);
        String sql = "INSERT INTO product(id,category,name,price,quantity,threshold_value) values(?,?,?,?,?,?);";
        PreparedStatement statement = null;
        try {
            DatabaseConnector connector = new DatabaseConnector();
            statement = connector.connection.prepareStatement(sql);statement.setString(1, ID);
            statement.setString(2, category);
            statement.setString(3, pname);
            statement.setDouble(4, price);
            statement.setDouble(5, quantity);
            statement.setDouble(6, threshold);
            int i = statement.executeUpdate();
            if (i > 0) {
                product.updateLog(this.username, "Added new product");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "Could not insert lement, likely due to non-unique product ID", "Dialog",
                        JOptionPane.ERROR_MESSAGE);//Unsuccessful
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    Product updateItem(String pname, String category, String ID, double price, double quantity, double threshold) {

        Product initialState=new SearchProducts().searchByID(ID);
        if (!initialState.checkThresholdValue(quantity,threshold)){
            return initialState;
        }
        DatabaseConnector connector = new DatabaseConnector();
        String query = "UPDATE product SET name = ?, category = ? , price = ? , quantity = ? , threshold_value = ?  WHERE id = ?";
        PreparedStatement statement = null;
        Product product=null;
        try {
            statement = connector.connection.prepareStatement(query);
            statement.setString(1, pname);
            statement.setString(2, category);
            statement.setDouble(3, price);
            statement.setDouble(4, quantity);
            statement.setDouble(5, threshold);
            statement.setString(6, ID);
            int i = statement.executeUpdate();
            connector.connection.close();
            if (i > 0) {
                //successful execution
                product.updateLog(this.username, "Changed product specifications.");
                product = new SearchProducts().searchByID(ID);
            } else {
                //updation unsuccessful updation,show alert
                //function returns null
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    void removeItem(Product product) {
        DatabaseConnector connector = new DatabaseConnector();
        String sql = "DELETE FROM product WHERE id =  ?";
        PreparedStatement statement = null;
        try {
            statement = connector.connection.prepareStatement(sql);
            statement.setString(1, product.getID());
            int i = statement.executeUpdate();
            connector.connection.close();
            if (i > 0) {
                //product.updateLog(this.username,"Deleted item from inventory.");
                //successful execution

            } else {
                //deletion unsuccessful,show alert
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}