package Control;

import Util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Swapnil on 1/21/2016.
 */
@SuppressWarnings("SqlDialectInspection")
public class getNote {
    public static String get(int id) {
        Connection con = DBConnect.Connect();
        String sqlStr = "SELECT notes FROM notes WHERE " +
                "(noteid=(SELECT MAX(noteid) FROM notes WHERE userid=" +
                id+"));";
        Statement stat = null;
        String str = null;
        try {
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sqlStr);
            rs.next();
            str = rs.getString("notes");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }
}
