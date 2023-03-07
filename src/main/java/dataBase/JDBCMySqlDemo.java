package dataBase;

import java.sql.*;

public class JDBCMySqlDemo {
    public static void main(String[] args) throws SQLException {
        connectToDataBase();
    }
    public static void connectToDataBase() throws SQLException {

        String sql = "select * from user_rank";

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ordermenu?serverTimezone=UTC",
                "root", "root");
        if(conn == null){
            System.out.println("connection fail");
        }else{
            System.out.println("connection success");
        }

        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet result = pre.executeQuery();

        while(result.next()){
            System.out.println(result.getString("user_rank_id"));
        }
    }
}


