package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DaoFactory {
    

    public static VilleDAOImpl getVilleDaoImpl() throws DaoException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	throw new DaoException("Impossible de se connecter à la base de données");
        }

        Connection connexion = null;
        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven?user=root&password=");
            return new VilleDAOImpl(connexion);
        } catch (SQLException e) {
            throw new DaoException("Impossible de se connecter à la base de données");
        }
        
    }
    
}