import java.sql.*;
import util.DBUtil;
public class LoginDao {
    static String warn;

    public static boolean validate(String name, String pass)
            throws SQLException {
        boolean status = false;
        try {
            Connection con =  DBUtil.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root","password");
            
            Statement statem = con.createStatement();
            String sql = "SELECT * FROM customers WHERE customerName = '" + name + "' AND customerNumber = " + pass;

            ResultSet rs = statem.executeQuery(sql);
            warn = statem.getWarnings().getMessage();
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