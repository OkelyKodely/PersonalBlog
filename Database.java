package data;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Database {
 
    private Connection con;
    private String data;
    private boolean isClosed;
    
    public Database() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch(Exception e) {}
        this.con = initConnect(null);
        if(this.con == null) {
            throw new SQLException();
        }
    }
    
    private Connection initConnect(String data) {
        try {
            String hostName = "ec2-54-163-240-54.compute-1.amazonaws.com";
            String dbName;
            String userName = "isscllglmxgeln";
            if(data == null) {
                dbName = "d89l9begjikklj";
            } else {
                dbName = data;
            }
            this.data = dbName;
            String password = "334f696049572d4bc9c3b6b78c3410301e24dd3b5fd2b96dc15bf4c1c6fed113";
            String url = "jdbc:postgresql://" + hostName + "/" + this.data + "?user=" + userName + "&password=" + password + "&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
            Connection connection = DriverManager.getConnection(url, userName, password);
            return connection;
        } catch(Exception e) {
            JOptionPane.
                    showMessageDialog(null, "No Internet");
        }
        return null;
    }

    public void setDatabase(String data) {
        if(!this.isConnectClosed()) {
            this.con = initConnect(data);
        }
    }
    
    public ResultSet query(String sql) {
        try {
            Statement stat = this.con.createStatement();
            ResultSet res = stat.executeQuery(sql);
            return res;
        } catch(SQLException exce) {}
        return null;
    }
    
    public void command(String sql) {
        try {
            Statement stat = this.con.createStatement();
            String sQl = sql;
            stat.execute(sQl);
        } catch(SQLException exce) {}
    }
    
    public boolean isConnectClosed() {
        try {
            if(this.con == null) {
                this.isClosed = true;
                return this.isClosed;
            }
            if(this.con.isClosed()) {
                this.isClosed = true;
            }
            return this.con.isClosed();
        } catch(SQLException e) {}
        return true;
    }

    public void closeConnect() {
        try {
            this.con.close();
        } catch(Exception e) {}
    }
}