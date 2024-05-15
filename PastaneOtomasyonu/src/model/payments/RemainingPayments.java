package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import model.DatabaseConnection;

public class RemainingPayments {

	
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static RemainingPayments instance;

	int customerId;
	String customerCafeName;
	String customerTaxNumber;
	String customerTaxAdministration;
	String customerPhoneNumber;
	String customerAddress;
	String amount;
	String date;
	List<RemainingPayments> list;

	
	public RemainingPayments() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static RemainingPayments getInstance() {
		if (instance == null) {
			instance = new RemainingPayments();
		}
		return instance;
	}

	public List<RemainingPayments> getAllRemainingPayments(){
		String query = "SELECT customers.CafeName, customers.TaxNumber, customers.TaxAdministration, customers.PhoneNumber, customers.Address, remainingcustomerpayments.Amount\r\n"
				+ "FROM remainingcustomerpayments\r\n"
				+ "INNER JOIN customers ON remainingcustomerpayments.CustomerId = customers.Id\r\n"    ///ID ?? id????
				+ "WHERE remainingcustomerpayments.Amount REGEXP '^[0-9]+$' \r\n"
				+ "AND CAST(remainingcustomerpayments.Amount AS DECIMAL) > 0; ";
		
		try {
			
			stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(query);
			
			while(rs.next()) {
				RemainingPayments rp=new RemainingPayments();
				rp.setCustomerCafeName(rs.getString("CafeName"));
				rp.setCustomerTaxNumber(rs.getString("TaxNumber"));
				rp.setCustomerTaxAdministration(rs.getString("TaxAdministration"));
				rp.setCustomerPhoneNumber(rs.getString("PhoneNumber"));
				rp.setCustomerAddress(rs.getString("Address"));
				rp.setAmount(rs.getString("Amount"));
				list.add(rp);
			}
			

			stat.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return this.list;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerCafeName() {
		return customerCafeName;
	}

	public void setCustomerCafeName(String customerCafeName) {
		this.customerCafeName = customerCafeName;
	}

	public String getCustomerTaxNumber() {
		return customerTaxNumber;
	}

	public void setCustomerTaxNumber(String customerTaxNumber) {
		this.customerTaxNumber = customerTaxNumber;
	}

	public String getCustomerTaxAdministration() {
		return customerTaxAdministration;
	}

	public void setCustomerTaxAdministration(String customerTaxAdministration) {
		this.customerTaxAdministration = customerTaxAdministration;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
