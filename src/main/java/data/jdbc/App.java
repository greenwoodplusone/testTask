package data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Simple example of JDBC usage.
 */
public final class App {
    public static String output = "Non null, text";
    /**
     * Query that create table.
     */
    private static final String CREATE_QUERY =
            "CREATE TABLE EXAMPLE (GREETING VARCHAR(30), TARGET VARCHAR(30))";
    /**
     * Query delete table.
     */
    private static final String DELETE_QUERY =
            "DELETE FROM EXAMPLE";
    /**
     * Quaery that populates table with data.
     */
    private static final String DATA_QUERY_1 =
            "INSERT INTO EXAMPLE VALUES('Hello1','World1')";

    private static final String DATA_QUERY_2 =
            "INSERT INTO EXAMPLE VALUES('Hello2','World2')";

    /**
     * Do not construct me.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        try (Connection db = DriverManager.getConnection(("jdbc:h2:mem:"))) {
            try (Statement dataQuery = db.createStatement()) {
//                dataQuery.execute(DELETE_QUERY);
                dataQuery.execute(CREATE_QUERY);
                dataQuery.execute(DATA_QUERY_1);
                dataQuery.execute(DATA_QUERY_2);
            }

            try (PreparedStatement query =
                         db.prepareStatement("SELECT * FROM EXAMPLE")) {
                ResultSet rs = query.executeQuery();
                while (rs.next()) {
                    output = String.format("%s, %s!",
                            rs.getString("GREETING"),
                            rs.getString("TARGET"));
                    System.out.println(output);
//                    System.out.println(String.format("%s, %s!",
//                            rs.getString("GREETING"),
//                            rs.getString("TARGET")));
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Database connection failure: "
                    + ex.getMessage());
        }
    }
}
