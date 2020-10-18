import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductLog {
    private String productID, username, changes;

    public ProductLog(String productID, String username, String changes) {
        this.productID = productID;
        this.username = username;
        this.changes = changes;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChanges() {
        return changes;
    }

    public void setChanges(String changes) {
        this.changes = changes;
    }

}

class SearchLogs{

    List<ProductLog> userLogsList(String username) throws SQLException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product_log where username = ?;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, username);
        ResultSet result = statement.executeQuery();
        List<ProductLog> products = new ArrayList<ProductLog>();
        while (result.next()) {
            products.add(new ProductLog(result.getString("product_ID"), result.getString("username"), result.getString("changes")));
        }
        connector.connection.close();
        return products;
    }

    List<ProductLog> productLogsList(String productId) throws SQLException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product_log where product_ID = ?;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        statement.setString(1, productId);
        ResultSet result = statement.executeQuery();
        List<ProductLog> products = new ArrayList<ProductLog>();
        while (result.next()) {
            products.add(new ProductLog(result.getString("product_ID"), result.getString("username"), result.getString("changes")));
        }
        connector.connection.close();
        return products;
    }

    List<ProductLog> allLogsList() throws SQLException {
        DatabaseConnector connector = new DatabaseConnector();
        String query = "SELECT * from product_log;";
        PreparedStatement statement = connector.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<ProductLog> products = new ArrayList<ProductLog>();
        while (result.next()) {
            products.add(new ProductLog(result.getString("product_ID"), result.getString("username"), result.getString("changes")));
        }
        connector.connection.close();
        return products;
    }



}
