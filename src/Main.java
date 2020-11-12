import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DatabaseCredentials.databaseCredentialForm();
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/FOODPILE";
//        Connection connection = DriverManager.getConnection(url, "root", "RwitiSaha@258");
//        List<ProductLog> productLogList=new ArrayList<ProductLog>();
//        //DatabaseConnector connector = new DatabaseConnector();
//        String query = "SELECT * from product_log where product_ID = ? ;";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, "QQQ");
//        ResultSet result = statement.executeQuery();
//        //products = new ArrayList<ProductLog>();
//        while (result.next()) {
//            productLogList.add(new ProductLog(result.getString("product_ID"), result.getString("username"), result.getString("changes")));
//        }
//        for (ProductLog products:productLogList) {
//            System.out.println(products.getUsername()+" "+products.getChanges()+" "+products.getProductID());
//        }
    }
}
