package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Customer;
import model.DatabaseConnection;

public class ReceivingPayment {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static ReceivingPayment instance;

	int customerId;
	String amount;
	String date;

	public ReceivingPayment() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
	}

	public static ReceivingPayment getInstance() {
		if (instance == null) {
			instance = new ReceivingPayment();
		}
		return instance;
	}

	public String getRemainingAmount(String CafeName) {
		String query = "Select Amount from remainingcustomerpayments where CustomerId=((Select id from customers where CafeName=?))";
		this.amount="";
		
		try {
			pstat= conn.prepareStatement(query);
			pstat.setString(1,CafeName);
			ResultSet rs=pstat.executeQuery();
		
			if (rs.next()) {
				 this.amount = rs.getString("Amount");
				}
			
			pstat.close();
			rs.close();			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return this.amount;

	}
	
	
	public void savePayment() {
		try {

			String query = "insert into receivedcustomerpayments(CustomerId,Amount) values ((Select id from  customers where CafeName=?) ,?)";
			setReceievedPaymentsWithPrepaeredStatement(query);

			String query2="UPDATE remainingcustomerpayments SET Amount = Amount - ? WHERE CustomerId = (SELECT id FROM customers WHERE CafeName = ?);";
			setRemainingPaymentAmount(query2);
			
			JOptionPane.showMessageDialog(null, "Ödeme başarıyla alındı.", "  ", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Müşteri bulunamadı.", "  ", JOptionPane.INFORMATION_MESSAGE);


		}
	}
	
	
	public void setRemainingPaymentAmount(String query) {
		try {
			pstat=conn.prepareStatement(query);
			pstat.setString(1, getAmount());
			pstat.setString(2, Customer.getInstance().getCafeName());
			
			pstat.executeUpdate();
			pstat.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void setReceievedPaymentsWithPrepaeredStatement(String query) {
		try {
			pstat =conn.prepareStatement(query);
			pstat.setString(1, Customer.getInstance().getCafeName());
			pstat.setString(2, getAmount());

			pstat.executeUpdate();
			pstat.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
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
