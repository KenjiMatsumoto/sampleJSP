package sample.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	// コネクションの入れ物
	private static Connection connection = null;

	// DB接続設定
	public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                // ドライバ読み込み（ライブラリが無いとエラーとなる）
                Class.forName("com.mysql.jdbc.Driver");
                // コネクション生成
                connection = 
                DriverManager.getConnection(
 "jdbc:mysql://localhost/java_lesson?user=root&password=@@19830624Kk&characterEncoding=utf8");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }

    }
}
