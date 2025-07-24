package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Medicine;
import com.util.DBConnection;

public class exampleDAO {
	
	public void addMedicine(Medicine med) {
		
		try(Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("\"INSERT INTO Medicine (item_name, batch_number, exp_date, \"\r\n"
					+ "             		+ \"quantity, supp_name, last_updated) VALUES (?, ?, ?, ?, ?, ?)\")"))	{
			
			ps.setString(1,med.getItem_name());
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public List<Medicine> getAllMedicine(){
		List<Medicine> medicineList = new ArrayList<>();
		try (Connection con = DBConnection.getCon();
				PreparedStatement ps = con.prepareStatement("Select * from Medicines");
				ResultSet rs = ps.executeQuery()){
			
			
			while(rs.next()) {
				
				int id = rs.getInt("item_id");
				String name = rs.getString("item_name");
				
				medicineList.add(new Medicine(id, name, name, null, id, name, null));
			}
			
		} catch (SQLException e) {
			                                          //GOOOOOOOD!!!
			e.printStackTrace();
		}
		return medicineList;
	}
	
	
}
