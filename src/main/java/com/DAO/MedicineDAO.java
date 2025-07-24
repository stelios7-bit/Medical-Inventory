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

public class MedicineDAO {

    public void addMedicine(Medicine med) {
        
        try (Connection con = DBConnection.getCon(); 
             PreparedStatement ps = con.prepareStatement("INSERT INTO Medicine (item_name, batch_number, exp_date, "
             		+ "quantity, supp_name, last_updated) VALUES (?, ?, ?, ?, ?, ?)")) {

            ps.setString(1,med.getItem_name());
            ps.setString(2, med.getBatch_number());
            ps.setDate(3, med.getExp_date());
            ps.setInt(4, med.getQuantity());
            ps.setString(5, med.getSupp_name());
            ps.setDate(6, med.getLast_updated());

            ps.executeUpdate();
           
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medicine> getAllMedicines() {
        List<Medicine> medicineList = new ArrayList<>();
       
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Medicine");
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String name = rs.getString("item_name");
                String batch = rs.getString("batch_number");
                Date expDate = rs.getDate("exp_date");
                int qty = rs.getInt("quantity");
                String supplier = rs.getString("supp_name");
                Date lastUpdated = rs.getDate("last_updated");

                medicineList.add(new Medicine(id, name, batch, expDate, qty, supplier, lastUpdated));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineList;
    }

    public void deleteMedicine(Medicine del) {
             
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("DELETE FROM Medicine WHERE item_id = ?")) {
            
            ps.setInt(1, del.getItem_id());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Medicine getMedicineById(int id) {
        Medicine med = null;
        
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM Medicine WHERE item_id = ?")) {
            
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("item_name");
                    String batch = rs.getString("batch_number");
                    Date expDate = rs.getDate("exp_date");
                    int qty = rs.getInt("quantity");
                    String supplier = rs.getString("supp_name");
                    Date lastUpdated = rs.getDate("last_updated");

                    med = new Medicine(id, name, batch, expDate, qty, supplier, lastUpdated);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return med;
    }
    
    public void updateMedicine(Medicine med) {
        String sql = "UPDATE Medicine SET item_name = ?, batch_number = ?, exp_date = ?, quantity = ?, supp_name = ?, last_updated = ? WHERE item_id = ?";
        
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, med.getItem_name());
            ps.setString(2, med.getBatch_number());
            ps.setDate(3, med.getExp_date());
            ps.setInt(4, med.getQuantity());
            ps.setString(5, med.getSupp_name());
            ps.setDate(6, med.getLast_updated());
            ps.setInt(7, med.getItem_id()); // Set the ID for the WHERE clause

            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Medicine> getExpiringMedicines() {
        List<Medicine> medicineList = new ArrayList<>();
        // This query finds items expiring in the next 90 days.
        String sql = "SELECT * FROM Medicine WHERE exp_date BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 90 DAY) ORDER BY exp_date ASC";
        
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("item_id");
                String name = rs.getString("item_name");
                String batch = rs.getString("batch_number");
                Date expDate = rs.getDate("exp_date");
                int qty = rs.getInt("quantity");
                String supplier = rs.getString("supp_name");
                Date lastUpdated = rs.getDate("last_updated");

                medicineList.add(new Medicine(id, name, batch, expDate, qty, supplier, lastUpdated));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicineList;
    }
}