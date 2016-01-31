package Control;

import Util.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Swapnil on 1/21/2016.
 */
public class modifyNote {
    public static void modify(String note, String oldNote) {
        Connection con = DBConnect.Connect();
        String sqlStr = "UPDATE notes SET notes=\'"+note+"\' WHERE notes=\'"+oldNote+"\';";
        Statement stat = null;
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}