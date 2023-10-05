package elev.tec.dk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTools {
	
	private String conStr = "jdbc:sqlserver://localhost;databaseName=PeopleDB;encrypt=true;trustServerCertificate=true;useUnicode=true;characterEncoding=UTF-8";
	
	Connection con;
	Statement stmt;
	
	public DBTools() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void connect() {
		try {
			con = DriverManager.getConnection(conStr, "sa", "1234");
			stmt = con.createStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// -------------------------------------//
	//				People CRUD				//		
	// -------------------------------------//

	public People getPeopleById(int id) {
		connect();
		String selectStr = "SELECT * FROM People "
				+ "WHERE People.Id = " + id;
		
		//System.out.println(selectStr);
		
		People p = new People();
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			if (result.next()) {
				p.setId(result.getInt("Id"));                
                p.setName(result.getString("Name"));
                p.setTel(result.getString("Tel"));
                p.setAddress(result.getString("Address"));
                p.setNote(result.getString("Note"));
                p.setFav(result.getBoolean("Fav"));
                p.setHairColor(result.getInt("HairColor"));
                p.setProgLang(result.getInt("ProgLang"));
			}
			
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

	public ArrayList<People> getAllPeople() {
		connect();
		String selectStr = "SELECT * FROM People";
		
		ArrayList<People> pList = new ArrayList<People>();
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			while(result.next()){
				People p = new People();
	            p.setId(result.getInt("Id"));                
	            p.setName(result.getString("Name"));
	            p.setTel(result.getString("Tel"));
	            p.setAddress(result.getString("Address"));
	            p.setNote(result.getString("Note"));
	            p.setFav(result.getBoolean("Fav"));
                p.setHairColor(result.getInt("HairColor"));
                p.setProgLang(result.getInt("ProgLang"));
                pList.add(p);
			}
			
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}
	
	public People addPeople(People p) {
		connect();
		
		int Fav = 0;
		if (p.getFav() == true) {
			Fav = 1;
		}
		
		String addStr = "INSERT INTO People "
				+ "VALUES ('" + p.getName() + "', "
				+ "'" + p.getTel() + "', "
				+ "'" + p.getAddress() + "', "
				+ "'" + p.getNote() + "', "
				+ Fav + ", "
				+ p.getHairColor() + ", "
				+ p.getProgLang() + ")";
		
		try {
			stmt.executeUpdate(addStr);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String getLatestStr = "SELECT TOP 1 * FROM People ORDER BY Id DESC";
		
		try {
			ResultSet result = stmt.executeQuery(getLatestStr);
			
			if (result.next()) {
				p.setId(result.getInt("Id"));                
                p.setName(result.getString("Name"));
                p.setTel(result.getString("Tel"));
                p.setAddress(result.getString("Address"));
                p.setNote(result.getString("Note"));
                p.setFav(result.getBoolean("Fav"));
                p.setHairColor(result.getInt("HairColor"));
                p.setProgLang(result.getInt("ProgLang"));
			}
			
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public People updatePeopleById(People p) {
		connect();
		
		int Fav = 0;
		if (p.getFav() == true) {
			Fav = 1;
		}
		
		String updateStr = "UPDATE People "
				+ "SET [Name] = '" + p.getName() + "', "
				+ "[Tel] = '" + p.getTel() + "', "
				+ "[Address] = '" + p.getAddress() + "', "
				+ "[Note] = '" + p.getNote() + "', "
				+ "[Fav] = " + Fav + ", "
				+ "[HairColor] = " + p.getHairColor() + ", "
				+ "[ProgLang] = " + p.getProgLang()
				+ " WHERE [People].[Id] = " + p.getId();
		
		try {
			
			stmt.executeUpdate(updateStr);
			
			p = this.getPeopleById(p.getId());
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public People deletePeopleById(int id) {
		People p = new People();
		
		String deleteStr = "DELETE FROM People WHERE Id = " + id;
		
		try {
			
			p = getPeopleById(id);
			
			connect();
			stmt.executeUpdate(deleteStr);
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	

	// -----------------------------------------//
	//				HairColor CRUD				//		
	// -----------------------------------------//
	
	public HairColor getHairColorById(int id) {
		connect();
		String selectStr = "SELECT * FROM HairColor WHERE Id = " + id;
		
		HairColor hc = new HairColor();
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			if (result.next()) {
				hc.setId(result.getInt("Id"));                
				hc.setColor(result.getString("Color"));
				
				con.close();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hc;
	}

	public ArrayList<HairColor> getAllHairColor() {
		connect();
		String selectStr = "SELECT * FROM HairColor";
		
		ArrayList<HairColor> hcList = new ArrayList<HairColor>();
		
		try {
			ResultSet result = stmt.executeQuery(selectStr);
			
			while(result.next()){
				HairColor hc = new HairColor();
	            hc.setId(result.getInt("Id"));
	            hc.setColor(result.getString("Color"));
	            hcList.add(hc);
			}
			
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return hcList;
	}
	
	// -----------------------------------------//
	//				 ProgLang CRUD				//		
	// -----------------------------------------//
		
	public ProgLang getProgLangById(int id) {
		connect();
		String selectStr = "SELECT * FROM ProgLang WHERE Id = " + id;
		
		ProgLang pl = new ProgLang();
			
		try {
			ResultSet result = stmt.executeQuery(selectStr);
				
			if (result.next()) {
				pl.setId(result.getInt("Id"));                
				pl.setLang(result.getString("Lang"));
					
				con.close();
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
			
		return pl;
	}

	public ArrayList<ProgLang> getProgLangColor() {
		connect();
		String selectStr = "SELECT * FROM ProgLang";
			
		ArrayList<ProgLang> plList = new ArrayList<ProgLang>();
			
		try {
			ResultSet result = stmt.executeQuery(selectStr);
				
			while(result.next()){
				ProgLang pl = new ProgLang();
				pl.setId(result.getInt("Id"));
				pl.setLang(result.getString("Lang"));
				plList.add(pl);
			}
				
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return plList;
	}
}
