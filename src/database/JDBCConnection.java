package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    private static JDBCConnection instance;
    private Connection conn;
    private String url = "jdbc:oracle:thin:@localhost:1522:pedro";
    private String username = "pedro";
    private String password = "250410";

    private JDBCConnection() throws SQLException{
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            this.conn = DriverManager.getConnection(url, username, password);
        }catch (ClassNotFoundException e){
            System.out.println("Lib not found, or anything else!");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public static JDBCConnection getInstance() throws SQLException{
        if( instance == null){
            instance = new JDBCConnection();
        }else if(instance.getConnection().isClosed()){
            instance = new JDBCConnection();
        }
        return instance;
    }
}
