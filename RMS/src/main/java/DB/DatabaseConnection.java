package DB;

import Models.Enums.EventType;
import Models.Order;

import java.sql.*;
import java.util.ArrayList;
/**
 * @author Srikanthan P.K
 * @SA_No SA22401694
 */
public class DatabaseConnection {
    private final String URL = "jdbc:mysql://localhost:3306/oop_rms_db";
    private final String UName = "root";
    private final String Password = "";
    private static DatabaseConnection instance;
    private Connection con;

    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, UName, Password);
            System.out.println("Database Connection Success");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Class Error " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Database Connection Error " + ex.getMessage());
        }
    }

    public static DatabaseConnection getSingleInstance()//Singleton Design Pattern
    {
        try {
            if (instance == null) {
                instance = new DatabaseConnection();
            } else if (instance.con.isClosed()) {
                instance = new DatabaseConnection();
            } else {
                return instance;
            }
            return instance;
        } catch (SQLException ex) {
            System.out.println("Database Connection Error " + ex.getMessage());
            return null;
        }
    }

    public ResultSet ExecuteGetQuery(String query) {
        try {
            Statement st = con.createStatement();
            return st.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return null;
        }
    }

    public boolean ExecuteQuery(String query) {
        try {
            Statement st = con.createStatement();
            int result = st.executeUpdate(query);
            return result > 0;
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return false;
        }
    }

    public int InsertQueryReturnInt(String query) {
        ResultSet generatedKeys = null;
        int generatedKey = -1;

        try {
            Statement statement = con.createStatement();
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                generatedKey = rs.getInt(1);
            }

            return generatedKey;
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return -1;
        }

    }

    public int GetNextId(String tableName) {
        try {
            String query = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = '" + tableName + "'";
            Statement st = con.createStatement();
            int result = st.executeUpdate(query);
            return result + 1;
        } catch (SQLException ex) {
            System.out.println("SQL Error " + ex.getMessage());
            return -1;
        }
    }

}
