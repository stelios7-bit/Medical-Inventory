package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Supplier;
import com.util.DBConnection;

public class SupplierDAO {

   
	public void addSupplier(Supplier supplier) throws SQLException {
	    String sql = "INSERT INTO Suppliers (supplier_name, contact_person, email, phone) VALUES (?, ?, ?, ?)";
	    try (Connection con = DBConnection.getCon();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, supplier.getSupplierName());
	        ps.setString(2, supplier.getContactPerson());
	        ps.setString(3, supplier.getEmail());
	        ps.setString(4, supplier.getPhone());
	        ps.executeUpdate();
	    }
	}

	public void updateSupplier(Supplier supplier) throws SQLException {
	    String sql = "UPDATE Suppliers SET supplier_name = ?, contact_person = ?, email = ?, phone = ? WHERE supplier_id = ?";
	    try (Connection con = DBConnection.getCon();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setString(1, supplier.getSupplierName());
	        ps.setString(2, supplier.getContactPerson());
	        ps.setString(3, supplier.getEmail());
	        ps.setString(4, supplier.getPhone());
	        ps.setInt(5, supplier.getSupplierId());
	        ps.executeUpdate();
	    }
	}

   
    public List<Supplier> getAllSuppliers() {
        List<Supplier> supplierList = new ArrayList<>();
        String sql = "SELECT * FROM Suppliers ORDER BY supplier_name ASC";
        
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("supplier_id");
                String name = rs.getString("supplier_name");
                String contact = rs.getString("contact_person");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                
                supplierList.add(new Supplier(id, name, contact, email, phone));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return supplierList;
    }

    public void deleteSupplier(int id) {
        String sql = "DELETE FROM Suppliers WHERE supplier_id = ?";
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Supplier getSupplierById(int id) {
        Supplier sup = null;
        String sql = "SELECT * FROM Suppliers WHERE supplier_id = ?";
        try (Connection con = DBConnection.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("supplier_name");
                    String contact = rs.getString("contact_person");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");
                    sup = new Supplier(id, name, contact, email, phone);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sup;
    }

    
}
