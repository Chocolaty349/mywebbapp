import java.sql.*;
import util.DBUtil;

public class LoginDao {
    String warn;

    public boolean validate(String name, String pass)
            throws SQLException {
        boolean status = false;
        try {
            Connection con = DBUtil.getConnection("jdbc:mysql://mysql-database:3306/User?autoReconnect=true&useSSL=false", "user", "password");

            Statement statem = con.createStatement();
            String sql = "SELECT * FROM employee WHERE name = '" + name + "' AND password = '" + pass + "'";
            ResultSet rs = statem.executeQuery(sql);
            
            status = rs.next();
            statem.close();

        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
}