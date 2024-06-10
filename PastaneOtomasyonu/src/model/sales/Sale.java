package model.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.DatabaseConnection;
import model.recipecard.RecipeCards;

public class Sale {

	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static Sale instance;

	String cafeName;
	String taxNo;
	String taxAdministration;
	String phoneNumber;
	String address;

	public List<RecipeCards> list;

	public Sale() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		this.list = new ArrayList<RecipeCards>();
	}

	public static Sale getInstance() {
		if (instance == null) {
			instance = new Sale();
		}
		return instance;
	}

	public void sale(String customerTaxNo) {

		try {

			for (RecipeCards rc : list) {

				String query = "insert into sales (RecipeCardId,CustomerId,SaleAmount,UnitPrice,TotalPrice) values ((Select id from recipecards where Barcode=?),(Select id from customers where TaxNo=?),?,?,?) ";
				setSaleWithPreparedStatement(query, customerTaxNo, rc);

				String query1 = "UPDATE recipecards SET Amount = Amount - ? WHERE Barcode = ?";
				updateProductAmountWithPrepaeredStatement(query1, rc);

				String query2 = "insert into accounting(Price,Type,Explanation) values (?,?,?)";
				setPriceOnAccountingWithPrepaeredStatement(query2, rc);

				String query3 = "update  remainingcustomerpayments  SET Amount = Amount + ?  WHERE CustomerId=(Select id from  customers where TaxNo=?)";
				setRemainingPaymentAmount(query3, customerTaxNo, rc);

			}
			list.clear();

			JOptionPane.showMessageDialog(null, "Başarıyla kaydedildi.", "  ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "!!!", "  ", JOptionPane.INFORMATION_MESSAGE);

		}

	}

	public void setRemainingPaymentAmount(String query, String customerTaxNo, RecipeCards rc) {
		try {
			pstat = conn.prepareStatement(query);

			pstat.setString(1, rc.getTotalPrice());
			pstat.setString(2, customerTaxNo);

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProductAmountWithPrepaeredStatement(String query, RecipeCards rc) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rc.getAmount());
			pstat.setString(2, rc.getBarcode());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setPriceOnAccountingWithPrepaeredStatement(String query, RecipeCards rc) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rc.getTotalPrice());
			pstat.setString(2, "G");
			pstat.setString(3, "Ürün satış");

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSaleWithPreparedStatement(String query, String customerTaxNo, RecipeCards rc) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, rc.getBarcode());
			pstat.setString(2, customerTaxNo);
			pstat.setString(3, rc.getAmount());
			pstat.setString(4, rc.getPrice());
			pstat.setString(5, rc.getTotalPrice());

			pstat.executeUpdate();
			pstat.close();

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

}
