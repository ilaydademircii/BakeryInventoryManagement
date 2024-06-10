package view.recipecards;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class SetRecipeCardFrame extends JInternalFrame {
	public JTextField barcode;
	public JTextField name;
	public JTextField material_amount;
	public JTextField material_unit;
	public JTable table;
	public JComboBox material_category;
	public JComboBox material_name;
	public JButton addingMaterialButton;
	public JButton saveButton;
	public DefaultTableModel modelim;
	public JButton listingButton;
	Object[] colums = { "Kategorisi", "Malzeme", "Miktarı", "Birimi" };
	private JLabel lblNewLabel_1_3;
	public JComboBox unit;

	public SetRecipeCardFrame() {
		setClosable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Tarif Kartı");
		setBounds(100, 100, 1138, 728);
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Ürün");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(26, 73, 90, 30);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("Barkodu");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(26, 124, 112, 30);
		getContentPane().add(lblNewLabel_1_2);

		barcode = new JTextField();
		barcode.setColumns(10);
		barcode.setBounds(180, 124, 240, 30);
		getContentPane().add(barcode);

		addingMaterialButton = new JButton("Malzeme Ekle");

		addingMaterialButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addingMaterialButton.setBounds(283, 446, 126, 30);
		getContentPane().add(addingMaterialButton);

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(180, 73, 240, 30);
		getContentPane().add(name);

		JLabel lblrnAd = new JLabel("Kategori");
		lblrnAd.setHorizontalAlignment(SwingConstants.LEFT);
		lblrnAd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblrnAd.setBounds(26, 283, 90, 30);
		getContentPane().add(lblrnAd);

		JLabel lblNewLabel_1_1 = new JLabel("Ürün");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(26, 333, 90, 30);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("Miktarı");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(26, 384, 112, 30);
		getContentPane().add(lblNewLabel_1_2_1);

		material_amount = new JTextField();
		material_amount.setColumns(10);
		material_amount.setBounds(180, 384, 240, 30);
		getContentPane().add(material_amount);

		material_category = new JComboBox();
		material_category.setModel(new DefaultComboBoxModel(new String[] { "", "Süt Ürünleri", "Katkı Maddeleri" }));
		material_category.setFont(new Font("Tahoma", Font.BOLD, 11));
		material_category.setBounds(180, 283, 240, 30);
		getContentPane().add(material_category);

		material_name = new JComboBox();
		material_name.setFont(new Font("Tahoma", Font.BOLD, 11));
		material_name.setBounds(180, 333, 240, 30);
		getContentPane().add(material_name);

		JLabel lblNewLabel = new JLabel("Eklenecek Malzemeler");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(26, 238, 233, 34);
		getContentPane().add(lblNewLabel);

		material_unit = new JTextField();
		material_unit.setEditable(false);
		material_unit.setColumns(10);
		material_unit.setBounds(454, 384, 90, 30);
		getContentPane().add(material_unit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(624, 44, 437, 332);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);

		saveButton = new JButton("Kaydet");

		saveButton.setBounds(872, 472, 89, 23);
		getContentPane().add(saveButton);

		lblNewLabel_1_3 = new JLabel("Adet Miktarı");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(26, 174, 112, 30);
		getContentPane().add(lblNewLabel_1_3);

		unit = new JComboBox();
		unit.setModel(new DefaultComboBoxModel(new String[] { "", "10'lu Kutu", "12'li Kutu", "15'li Kutu" }));
		unit.setFont(new Font("Tahoma", Font.BOLD, 11));
		unit.setBounds(180, 174, 240, 30);
		getContentPane().add(unit);

	}
}
