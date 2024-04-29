package view.customers;

import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ListingCustomersFrame extends JInternalFrame {

	public JTable table;
	public DefaultTableModel modelim;
	public JButton listingButton;
	Object[] colums = { "Kafe Adı", "Vergi Numarası", "Vergi Dairesi", "Telefon Numarası", "Adresi" };

	public ListingCustomersFrame() {
		setTitle("Müşteri Listesi");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 648, 509);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 69, 468, 267);
		getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);

		listingButton = new JButton("Listele");
		listingButton.setBounds(246, 380, 147, 23);
		getContentPane().add(listingButton);

	}

}
