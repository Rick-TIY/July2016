package toolbox.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestdbMinimum {
    public static void main(String[] args) {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            Connection conn = DriverManager.getConnection("jdbc:hsqldb:db_file","sa","");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sample_table");
            while(rs.next()) {
                String rowResults = rs.getInt(1)+" -- "+rs.getString(2)+" -- "+rs.getInt(3);
                System.out.println(rowResults);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
