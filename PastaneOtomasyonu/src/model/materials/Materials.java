package model.materials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.DatabaseConnection;

public class Materials {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static Materials instance;

	String category;
	String name;
	String barcode;
	String unit;
	String amount;
	String price;
	String date;

	public Materials() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static Materials getInstance() {
		if (instance == null) {
			instance = new Materials();
		}
		return instance;
	}

	public List<String> getAllMaterialNames(String category) {
		List<String> list = new ArrayList<>();
		String query = "Select Name from materials WHERE Category=?;";

		try {

			pstat = conn.prepareStatement(query);
			pstat.setString(1, category);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				list.add(rs.getString("Name"));
			}

			pstat.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
/*	public void getMaterial() {
	    String query = "SELECT Barcode, Unit FROM materials WHERE Category = ? AND Name = ?";

	   
	    
	    try {
	        PreparedStatement stat = conn.prepareStatement(query);
	        stat.setString(1, category);
	        stat.setString(2, name);

	        ResultSet rs = stat.executeQuery();

	        while (rs.next()) {
	            Materials.getInstance().setBarcode(rs.getString("Barcode"));
	            Materials.getInstance().setUnit(rs.getString("Unit"));
	        }

	        rs.close();
	        stat.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
*/
	public void getMaterial() {
		String query = "Select Barcode,Unit from materials where Category=? AND Name=? ";

		try {

			pstat = conn.prepareStatement(query);
			pstat.setString(1, instance.getCategory());
			pstat.setString(2, instance.getName());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				instance.setBarcode(rs.getString("Barcode"));
				instance.setUnit(rs.getString("Unit"));
			}

			pstat.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void saveMaterialType() {
		try {

			String query = "insert into materials(Category,Name,Barcode,Unit,Amount) values (?,?,?,?,?)";
			setMaterialTypeWithPrepaeredStatement(query);

			JOptionPane.showMessageDialog(null, "Malzeme başarıyla eklendi.", "  ", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Malzeme eklenemedi.", "  ", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void saveMaterial() {
		try {

			String query1 = "UPDATE materials SET Amount = Amount + ? WHERE Barcode = ?";
			updateMaterialAmountWithPrepaeredStatement(query1);

			
			String query2="insert into accounting(Price,Type,Explanation) values (?,?,?)";
			setPriceOnAccountingWithPrepaeredStatement(query2);
			
			JOptionPane.showMessageDialog(null, "Malzeme başarıyla eklendi.", "  ", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Malzeme bulunamadı.", "  ", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void setMaterialTypeWithPrepaeredStatement(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, instance.getCategory());
			pstat.setString(2, instance.getName());
			pstat.setString(3, instance.getBarcode());
			pstat.setString(4, instance.getUnit());
			pstat.setString(5, instance.getFirstAmount());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateMaterialAmountWithPrepaeredStatement(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, instance.getAmount());
			pstat.setString(2, instance.getBarcode());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPriceOnAccountingWithPrepaeredStatement(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, instance.getPrice());
			pstat.setString(2, "C");
			pstat.setString(3, "Ürün alımı");

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getFirstAmount() {
		return "0";
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
