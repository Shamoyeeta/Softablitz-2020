import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class User {
    private String name,username,email;
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
        Product product=new Product(pname,category,ID,price,quantity,threshold);
        DatabaseConnector connector = new DatabaseConnector();
        String sql= "INSERT INTO product(id,category,name,price,quantity,threshold_value) values(?,?,?,?,?,?);";
        PreparedStatement statement = connector.connection.prepareStatement(sql);
        statement.setString(1,ID);
        statement.setString(2,category);
        statement.setString(3,pname);
        statement.setDouble(4, price);
        statement.setDouble(5, quantity);
        statement.setDouble(6, threshold);
        int i= statement.executeUpdate();
        if (i>0) {
            product.updateLog(this.username,"Added new product");
        }
        else {
            //Unsuccessful
        }
        connector.connection.close();
    }


    List<Product> searchByName(String pname) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where name = ?;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, pname);
        ResultSet result = statement.executeQuery();
        List<Product> products = new ArrayList<Product>();
        while (result.next()) {
            products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold")));
        }
        connector.connection.close();
        return products;
    }

    List<Product> searchByCategory(String category) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where category = ?;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, category);
        ResultSet result = statement.executeQuery();
        List<Product> products = new ArrayList<Product>();
        while (result.next()) {
            products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold")));
        }
        connector.connection.close();
        return products;
    }

    Product searchByID(String productID) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where id = ?;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, productID);
        ResultSet result = statement.executeQuery();
        Product product=null;
        while (result.next()) {
            product= new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold"));
        }
        connector.connection.close();
        return product;
    }

    Product updateItem(String pname, String category, String ID, double price, double quantity, double threshold) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "UPDATE product SET name = ?, category = ? , price = ? , quantity = ? , threshold_value = ? WHERE id= ?";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, pname);
        statement.setString(2, category);
        statement.setDouble(3, price);
        statement.setDouble(4, quantity);
        statement.setDouble(5, threshold);
        statement.setString(6, ID);
        int i=statement.executeUpdate();
        connector.connection.close();
        Product product=null;
        if (i>0){
            //successful execution
            product.updateLog(this.username,"Changed product specifications.");
            product=searchByID(ID);
        }
        else{
            //updation unsuccessful updation,show alert
            //function returns null
        }
        return product;
    }

    void removeItem(Product product) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector=new DatabaseConnector();
        String sql = "DELETE FROM user WHERE id= ?";
        PreparedStatement statement = connector.connection.prepareStatement(sql);
        statement.setString(1,product.getID());
        int i=statement.executeUpdate();
        connector.connection.close();
        if (i>0){
            product.updateLog(this.username,"Deleted item from inventory.");
            //successful execution

        }
        else{
            //deletion unsuccessful,show alert
        }

    }

}