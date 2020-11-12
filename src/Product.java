import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name,category,ID;
    private double price, quantity, threshold;

    public Product(String name, String category, String ID, double price, double quantity, double threshold) {
        this.name = name;
        this.category = category;
        this.ID = ID;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public boolean checkThresholdValue(double newQuantity,double newThreshold){
        if (newQuantity<newThreshold){
            //The quantity is less than threshold value. returns false
            return false;
        }
        else
            return true;
    }


    void updateLog(String username, String change) {

        String sql= "INSERT into product_log(product_ID , username , changes) values( ? , ? , ? );";
        try {
            DatabaseConnector connector=new DatabaseConnector();
            PreparedStatement statement = connector.connection.prepareStatement(sql);
            statement.setString(1,this.ID);
            statement.setString(2,username);
            statement.setString(3,change);
            statement.execute();
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

class SearchProducts{

    List<Product> searchAll()  {
        List<Product> products=new ArrayList<Product>();
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product;";
        try {
            PreparedStatement statement = connector.connection.prepareStatement(query);
            ResultSet result = null;
            result = statement.executeQuery();
            //products = new ArrayList<Product>();
            while (result.next()) {
                products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value")));
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    List<Product> searchByName(String pname) {
        List<Product> products=new ArrayList<Product>();
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where name = ?;";
        try {
            PreparedStatement statement = connector.connection.prepareStatement(query);
            statement.setString(1, pname);
            ResultSet result = null;
            result = statement.executeQuery();
            //products = new ArrayList<Product>();
            while (result.next()) {
                products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value")));
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;

//        DatabaseConnector connector = new DatabaseConnector();
//        String query = "SELECT * from product where name = ?;";
//        PreparedStatement statement = connector.connection.prepareStatement(query);
//        statement.setString(1, pname);
//        ResultSet result = statement.executeQuery();
//        List<Product> products = new ArrayList<Product>();
//        while (result.next()) {
//            products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value")));
//        }
//        connector.connection.close();
//        return products;
    }

    List<Product> searchByCategory(String category) {
        List<Product> products=new ArrayList<Product>();
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where category = ?;";
        try {
            PreparedStatement statement = connector.connection.prepareStatement(query);
            statement.setString(1, category);
            ResultSet result = null;
            result = statement.executeQuery();
            //products = new ArrayList<Product>();
            while (result.next()) {
                products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value")));
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;

//        DatabaseConnector connector = new DatabaseConnector();
//        String query = "SELECT * from product where category = ?;";
//        PreparedStatement statement = connector.connection.prepareStatement(query);
//        statement.setString(1, category);
//        ResultSet result = statement.executeQuery();
//        List<Product> products = new ArrayList<Product>();
//        while (result.next()) {
//            products.add(new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value")));
//        }
//        connector.connection.close();
//        return products;
    }

    Product searchByID(String productID) {
        Product product=null;
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product where id = ?;";
        try {
            PreparedStatement statement = connector.connection.prepareStatement(query);
            statement.setString(1, productID);
            ResultSet result = statement.executeQuery();
            //products = new ArrayList<Product>();
            while (result.next()) {
                product=new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value"));
            }
            connector.connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;

//        DatabaseConnector connector = new DatabaseConnector();
//        String query = "SELECT * from product where id = ?;";
//        PreparedStatement statement = connector.connection.prepareStatement(query);
//        statement.setString(1, productID);
//        ResultSet result = statement.executeQuery();
//        Product product=null;
//        while (result.next()) {
//            product= new Product(result.getString("name"), result.getString("category"), result.getString("id"), result.getDouble("price"), result.getDouble("quantity"), result.getDouble("threshold_value"));
//        }
//        connector.connection.close();
//        return product;
    }
}
