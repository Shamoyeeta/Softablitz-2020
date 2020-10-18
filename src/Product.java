import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    void updateLog(String username, String change) throws SQLException, ClassNotFoundException {
        DatabaseConnector connector=new DatabaseConnector();
        String sql= "INSERT into product_log(product_ID,username,changes) values(?,?,?);";
        PreparedStatement statement=connector.connection.prepareStatement(sql);
        statement.setString(1,this.ID);
        statement.setString(2,username);
        statement.setString(3,change);
        statement.execute();
        connector.connection.close();
    }

}

//    public Product(String name) throws SQLException, ClassNotFoundException {
//        this.name = name;
//        DatabaseConnector connector=new DatabaseConnector();
//        String query2 = "SELECT * FROM PRODUCT where name = ?;";
//        PreparedStatement preStat = null;
//        try {
//            preStat = connector.connection.prepareStatement(query2);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        preStat.setString(1, name);
//        ResultSet result = preStat.executeQuery();
//
//        while(result.next()) {
//            int regno = result.getInt("Roll_No");
//            String Resultname = result.getString("Name");
//            String branch = result.getString("Branch");
//            System.out.println("Name - " + Resultname);
//            System.out.println("Branch - " + branch);
//            System.out.println("Registration number - " + regno);
//        }
//    }

