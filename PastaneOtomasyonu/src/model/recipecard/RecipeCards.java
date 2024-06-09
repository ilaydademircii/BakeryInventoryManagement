package model.recipecard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.DatabaseConnection;
import model.materials.Materials;

public class RecipeCards {
	DatabaseConnection db;
	private PreparedStatement pstat = null;
	private Connection conn = null;
	private Statement stat = null;

	private static RecipeCards instance;

	String name;
	String barcode;
	String amount;
	String unit;
	String price;
	String totalPrice;
	String date;
	


	public List<Materials> materials;

	public RecipeCards() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		this.materials = new ArrayList<Materials>();
	}

	public static RecipeCards getInstance() {
		if (instance == null) {
			instance = new RecipeCards();
		}
		return instance;
	}

	public void getRecipeCard() {
		String query = "Select Barcode,Unit from recipecards where Name=? ";

		try {

			pstat = conn.prepareStatement(query);
			pstat.setString(1, RecipeCards.getInstance().getName());
			ResultSet rs = pstat.executeQuery();

			while (rs.next()) {
				RecipeCards.getInstance().setBarcode(rs.getString("Barcode"));
				RecipeCards.getInstance().setUnit(rs.getString("Unit"));
			}

			pstat.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> getAllRecipeCardNames() {
		List<String> list = new ArrayList<>();
		String query = "Select Name from recipecards;";

		try {

			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(query);

			while (rs.next()) {
				list.add(rs.getString("Name"));
			}

			stat.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void saveProducingRecipeCard() {

		try {

			String query1 = "UPDATE recipecards SET Amount = Amount + ? WHERE Barcode = ?";
			updateRecipecardAmountWithPrepaeredStatement(query1);

			JOptionPane.showMessageDialog(null, "Malzeme başarıyla eklendi.", "  ", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Malzeme bulunamadı.", "  ", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void save() {

		try {
			String query = "insert into recipecards (Name,Barcode,Unit,Amount) values (?,?,?,?) ";
			setRecipeCardWithPreparedStatement(query);

			for (Materials m : materials) {
				String query2 = "insert into rumaterials (RecipeCardId,MaterialsId,Amount) values ((Select id from recipecards where Barcode=?),(Select id from materials where Category=?  AND Name=?),?)";
				setMaterialAndRecipeCardWithPreparedStatement(query2, m.getCategory(), m.getName(), m.getAmount());
			}
			materials.clear();

			JOptionPane.showMessageDialog(null, "Başarıyla kaydedildi.", "  ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "!!!", "  ", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void updateRecipecardAmountWithPrepaeredStatement(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, RecipeCards.getInstance().getAmount());
			pstat.setString(2, RecipeCards.getInstance().getBarcode());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setMaterialAndRecipeCardWithPreparedStatement(String query, String category, String name,
			String amount) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, getBarcode());
			pstat.setString(2, category);
			pstat.setString(3, name);
			pstat.setString(4, amount);
			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setRecipeCardWithPreparedStatement(String query) {
		try {
			pstat = conn.prepareStatement(query);
			pstat.setString(1, getName());
			pstat.setString(2, getBarcode());
			pstat.setString(3, getUnit());
			pstat.setString(4, getFirstAmount());

			pstat.executeUpdate();
			pstat.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getFirstAmount() {
		return "0";
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}



}
