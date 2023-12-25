package connectionPool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPooling {
	private ConnectionPooling() {
		// making constructor as private
	}

	static DataSource cpObj; 
	public static Connection getPool() throws ClassNotFoundException, IOException, SQLException {
		
		if (cpObj == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			HikariConfig hkObj = new HikariConfig();
			Properties properties = new Properties();
			FileInputStream fileObj = new FileInputStream("C:\\Users\\Rajesh killadi\\OneDrive\\Desktop\\Rajesh\\Library\\src\\main\\java\\app\\db.properties");
			properties.load(fileObj);
			
			hkObj.setUsername(properties.getProperty("db.user"));
			hkObj.setPassword(properties.getProperty("db.password"));
			hkObj.setJdbcUrl(properties.getProperty("db.url"));
			hkObj.setMaximumPoolSize(10);
			hkObj.setMinimumIdle(5);
			
			cpObj = new HikariDataSource(hkObj);
			
		}
		
		return cpObj.getConnection();
		
	}
	
}
