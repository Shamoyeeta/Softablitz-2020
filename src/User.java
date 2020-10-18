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

    void addItem(String pname, String category, String ID, double price, double quantity, double threshold) throws SQLException, ClassNotFoundException {
        Product product = new Product(pname, category, ID, price, quantity, threshold);
        DatabaseConnector connector = new DatabaseConnector();
        String sql = "INSERT INTO product(id,category,name,price,quantity,threshold_value) values(?,?,?,?,?,?);";
        PreparedStatement statement = connector.connection.prepareStatement(sql);
        statement.setString(1, ID);
        statement.setString(2, category);
        statement.setString(3, pname);
        statement.setDouble(4, price);
        statement.setDouble(5, quantity);
        statement.setDouble(6, threshold);
        int i = statement.executeUpdate();
        if (i > 0) {
            product.updateLog(this.username, "Added new product");
        } else {
            //Unsuccessful
        }
        connector.connection.close();
    }


    Product updateItem(String pname, String category, String ID, double price, double quantity, double threshold) throws SQLException, ClassNotFoundException {

        Product initialState=new SearchProducts().searchByID(ID);
        if (!initialState.checkThresholdValue(quantity,threshold)){
            return initialState;
        }
        DatabaseConnector connector = new DatabaseConnector();
        String query = "UPDATE product SET name = ?, category = ? , price = ? , quantity = ? , threshold_value = ?  WHERE id = ?";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, pname);
        statement.setString(2, category);
        statement.setDouble(3, price);
        statement.setDouble(4, quantity);
        statement.setDouble(5, threshold);
        statement.setString(6, ID);
        int i = statement.executeUpdate();
        connector.connection.close();
        Product product = null;
        if (i > 0) {
            //successful execution
            product.updateLog(this.username, "Changed product specifications.");
            product = new SearchProducts().searchByID(ID);
        } else {
            //updation unsuccessful updation,show alert
            //function returns null
        }
        return product;
    }

    void removeItem(Product product) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector = new DatabaseConnector();
        String sql = "DELETE FROM product WHERE id =  ?";
        PreparedStatement statement = connector.connection.prepareStatement(sql);
        statement.setString(1, product.getID());
        int i = statement.executeUpdate();
        connector.connection.close();
        if (i > 0) {
            //product.updateLog(this.username,"Deleted item from inventory.");
            //successful execution

        } else {
            //deletion unsuccessful,show alert
        }

    }
}