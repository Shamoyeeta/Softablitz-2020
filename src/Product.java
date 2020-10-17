import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public Product(String name) throws SQLException {
        this.name = name;
        DatabaseConnector connector=new DatabaseConnector();
        String query2 = "SELECT * FROM PRODUCT where name = ?;";
        PreparedStatement preStat = null;
        try {
            preStat = connector.connection.prepareStatement(query2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        preStat.setString(1, name);
        ResultSet result = preStat.executeQuery();

        while(result.next()) {
            int regno = result.getInt("Roll_No");
            String Resultname = result.getString("Name");
            String branch = result.getString("Branch");
            System.out.println("Name - " + Resultname);
            System.out.println("Branch - " + branch);
            System.out.println("Registration number - " + regno);
    }
}}
