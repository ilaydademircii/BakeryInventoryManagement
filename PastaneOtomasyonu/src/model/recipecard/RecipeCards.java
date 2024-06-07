package model.recipecard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Customer;
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

	String date;

	public List<Materials> materials; 
	
	public RecipeCards() {
		super();
		this.db = DatabaseConnection.getInstance();
		this.conn = db.getConnection();
		this.materials=new ArrayList<Materials>();
	}

	public static RecipeCards getInstance() {
		if (instance == null) {
			instance = new RecipeCards();
		}
		return instance;
	}
	

	
	public void save() {
		
		try{
			String query="insert into recipecards (Name,Barcode) values (?,?) ";
			setRecipeCardWithPreparedStatement(query);
		
			for(Materials m :materials ) {
				String query2="insert into rumaterials (RecipeCardId,MaterialsId,Amount) values ((Select id from recipecards where Barcode=?),(Select id from materials where Category=?  AND Name=?),?)";
				setMaterialAndRecipeCardWithPreparedStatement(query2,m.getCategory(),m.getName(),m.getAmount());
			}
			materials.clear();
			
			JOptionPane.showMessageDialog(null, "Başarıyla kaydedildi.", "  ", JOptionPane.INFORMATION_MESSAGE);
	} catch (Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(null, "!!!", "  ", JOptionPane.INFORMATION_MESSAGE);


	}
	}
	
	public void setMaterialAndRecipeCardWithPreparedStatement(String query,String category,String name,String amount) {
		try {
			pstat=conn.prepareStatement(query);
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
			pstat=conn.prepareStatement(query);
			pstat.setString(1, getName());
			pstat.setString(2, getBarcode());
			
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
	
	
	
	
	
	
	
}
