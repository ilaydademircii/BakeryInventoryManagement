package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DatabaseConnection;

public class Payment {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;
	private static Payment instance;
	
	
	List<Payment> list;
	
	int customerId;
	String amount;
	String date;
	
	public Payment() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static Payment getInstance() {
		if (instance == null) {
			instance = new Payment();
		}
		return instance;
	}
	

	public List<Payment> getAllReceivedPaymentsWithCustomerId(String CafeName) {
		list = new ArrayList<>();

		try {
			String query = "SELECT Amount, Date FROM receivedcustomerpayments where CustomerId=(Select id from customers where CafeName=?)";
			pstat = conn.prepareStatement(query);
			pstat.setString(1, CafeName);
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				Payment payments = new Payment();
				payments.setAmount(rs.getString("Amount"));
				payments.setDate(rs.getString("Date"));
				list.add(payments);
			}

			pstat.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
/*
--ReceivedCustomerPayments 
id 
CustomerId
Amount
Date*/