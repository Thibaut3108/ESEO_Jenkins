package com.controlleur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dao.DaoException;
import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

@RestController
public class VilleControleur {
	
	@Autowired
	VilleBLO VilleBLOService;

	//Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<String> appelVille(@RequestParam(required = false, value = "codePostal") String codePostal)
	{
		VilleDAOImpl VilleDB = null;
		try {
			VilleDB = VilleDAO.getImpl();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return VilleDB.getInfoVille();
	}
	/*public List<String> appelGet() {
		List<String> list = new ArrayList<String>();
		
		System.out.println("Appel GET");
		
		String url = "jdbc:mysql://localhost:3306/maven";
		String login = "root";
		String mdp = "";
		Connection cn=null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			cn = DriverManager.getConnection(url,login,mdp);
			
			st = cn.createStatement();
			String sql = "SELECT * FROM ville_france";
			
			rs = st.executeQuery(sql);
			
			while (rs.next()) {
				list.add(rs.getString("Nom_commune"));
				
				System.out.println("Commune : " + rs.getString("Nom_commune"));
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		return list;
	}*/
}
