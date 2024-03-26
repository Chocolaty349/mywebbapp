import java.sql.*;
import util.DBUtil;
public class LoginDao {

    public static boolean validate(String name, String pass)
            throws SQLException {
        boolean status = false;
        try {
            // Class.forName("com.mysql.jdbc.Driver");
            // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root",
            //         "password");
            Connection con =  DBUtil.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root","password");
            
            // PreparedStatement ps = con.prepareStatement("select * from mytable where
            // name=? and password=?");
            // ps.setString(1, name);
            // ps.setString(2, pass);
            Statement statem = con.createStatement();
            String sql = "SELECT * FROM customers WHERE customerName = '" + name + "' AND customerNumber = " + pass;

            ResultSet rs = statem.executeQuery(sql);
            // ResultSet rs = ps.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }
}