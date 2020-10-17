import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DatabaseConnector {
    public Connection connection;

    public void startConnection(String user,String password) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/FOODPILE";
        Connection connection = DriverManager.getConnection(url, "root", "RwitiSaha@258");
    }

    public static void main(String[] args) {

    }
}




    //public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("Enter Name:");
//        String name = br.readLine();



//        String query2 = "SELECT * FROM STUDENT where name = ?;";
//        PreparedStatement preStat = connection.prepareStatement(query2);
//        preStat.setString(1, name);
//        ResultSet result = preStat.executeQuery();

//        while(result.next()) {
//            int regno = result.getInt("Roll_No");
//            String Resultname = result.getString("Name");
//            String branch = result.getString("Branch");
//            System.out.println("Name - " + Resultname);
//            System.out.println("Branch - " + branch);
//            System.out.println("Registration number - " + regno);
     //   }
    //}
//}
