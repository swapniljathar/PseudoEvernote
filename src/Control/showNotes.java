package Control;

import Util.DBConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Swapnil on 1/21/2016.
 */
public class showNotes {
    public static ArrayList showNotes(int id) {
        Connection con = DBConnect.Connect();
        String sqlStr = "SELECT notes FROM notes WHERE userid=" + id + ";";
        Statement stat = null;
        ArrayList<String> str = new ArrayList<String>();
        try {
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(sqlStr);
            while (rs.next()) {
                str.add(rs.getString("notes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }
}