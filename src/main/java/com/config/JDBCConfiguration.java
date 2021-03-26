package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

public class JDBCConfiguration {
	
	private String url = "";
	private String username = "";
	private String password = "";
	
	JDBCConfiguration(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
	
	public static JDBCConfiguration getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        JDBCConfiguration instance = new JDBCConfiguration(
                "jdbc:mysql://localhost:3306/maven", "root", "");
        return instance;
        
    }

	@Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public VilleDAO getVilleDao() {
        return new VilleDAOImpl(this);
    }
}
