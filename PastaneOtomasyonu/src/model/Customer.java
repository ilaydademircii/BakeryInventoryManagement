package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Customer {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static Customer instance;
	
	String cafeName;
	String taxNo;
	String taxAdministration;
	String phoneNumber;
	String address;
	String explanation;

	public Customer() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static Customer getInstance() {
		if (instance == null) {
			instance = new Customer();
		}
		return instance;
	}

	public void save() {
		try {
			if (!Customer.getInstance().getTaxNo().isEmpty()) {
				if (!isExists(Customer.getInstance().getTaxNo())) {
					String query = "insert into customers(CafeName,TaxNo,TaxAdministration,PhoneNumber,Address,Explanation)values(?,?,?,?,?,?)";		
					setCustomerWithPrepaeredStatement(query);
					
					JOptionPane.showMessageDialog(null, "Müşteri başarıyla eklendi.", "  ",
							JOptionPane.INFORMATION_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "Vergi numarası boş bırakılamaz.", " Hata ",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExists(String taxNo) {
		try {
			String query = "SELECT EXISTS (SELECT 1 FROM customers WHERE TaxNo=?) AS var_mi";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, taxNo);

			ResultSet rs = pstat.executeQuery();
			rs.next();
			int sonuc = rs.getInt("var_mi");
			pstat.close();
			return sonuc == 1;

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
	}
	
	public void setCustomerWithPrepaeredStatement(String query) {
		try {
			Customer customer = Customer.getInstance();
			pstat = conn.prepareStatement(query);
			pstat.setString(1, customer.getCafeName());
			pstat.setString(2, customer.getTaxNo());
			pstat.setString(3, customer.getTaxAdministration());
			pstat.setString(4, customer.getPhoneNumber());
			pstat.setString(5, customer.getAddress());
			pstat.setString(6, customer.getExplanation());


			pstat.executeUpdate();
			pstat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public void getCustomerWithStatement(String query) {
		Customer customer = Customer.getInstance();
		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			if (rs.next()) {
				customer.setCafeName(rs.getString("CafeName"));
				customer.setTaxNo(rs.getString("TaxNo"));
				customer.setTaxAdministration(rs.getString("TaxAdministration"));
				customer.setPhoneNumber(rs.getString("PhoneNumber"));
				customer.setAddress(rs.getString("Address"));
				customer.setExplanation(rs.getString("Explanation"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getTaxNo() {
		return taxNo;
	}

	public void setTaxNo(String taxNo) {
		this.taxNo = taxNo;
	}

	public String getTaxAdministration() {
		return taxAdministration;
	}

	public void setTaxAdministration(String taxAdministration) {
		this.taxAdministration = taxAdministration;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	
	
}
