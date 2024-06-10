package model.payments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.DatabaseConnection;

public class ReceivingPayment {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static ReceivingPayment instance;

	String customerName;
	String receievedAmount;
	String remainingAmount;
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

	public void savePayment() {
		try {
			String remainingAmountStr = getRemainingAmount();
			int remainingAmount = Integer.parseInt(remainingAmountStr);

			// Kalan miktar 0'dan büyükse, ödeme işlemini gerçekleştiriyoruz
			if (remainingAmount > 0) {

				String query = "insert into receivedcustomerpayments(CustomerId,Amount) values ((Select id from  customers where CafeName=?) ,?)";
				setReceievedPaymentsWithPrepaeredStatement(query);

				String query2 = "UPDATE remainingcustomerpayments SET Amount = Amount - ? WHERE CustomerId = (SELECT id FROM customers WHERE CafeName = ?);";
				setRemainingPaymentAmount(query2);

				JOptionPane.showMessageDialog(null, "Ödeme başarıyla alındı.", "  ", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Borç yok, ödeme alınmadı.", "  ", JOptionPane.INFORMATION_MESSAGE);

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Müşteri bulunamadı.", "  ", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void setRemainingPaymentAmount(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, getReceievedAmount());

			pstat.setString(2, getCustomerName());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setReceievedPaymentsWithPrepaeredStatement(String query) {
		try {

			pstat = conn.prepareStatement(query);
			pstat.setString(1, getCustomerName());
			pstat.setString(2, getReceievedAmount());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getRemainingAmount() {
		String query = "Select Amount from remainingcustomerpayments where CustomerId=(Select id from customers where CafeName=?)";
		String remainingAmount = "";

		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, instance.getCustomerName());
			ResultSet rs = pstat.executeQuery();

			if (rs.next()) {
				remainingAmount = (rs.getString("Amount"));
			}
			rs.close();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return remainingAmount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getReceievedAmount() {
		return receievedAmount;
	}

	public void setReceivedAmount(String receievedamount) {
		this.receievedAmount = receievedamount;
	}

	public String getRemainingPrice() {
		return remainingAmount;
	}

	public void setRemainingPrice(String remainingamount) {
		this.remainingAmount = remainingamount;
	}

}
