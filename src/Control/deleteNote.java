package Control;

import Util.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Swapnil on 1/21/2016.
 */
public class deleteNote {
    public static void delete(String note) {
        Connection con = DBConnect.Connect();
        String sqlStr = "DELETE FROM notes WHERE " +
                "notes=\"" +  note +"\";";
        Statement stat = null;
        try {
            stat = con.createStatement();
            int rs = stat.executeUpdate(sqlStr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
