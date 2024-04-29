package view.payments;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RemainingPaymentFrame extends JInternalFrame {

	// private static final long serialVersionUID = 1L;

	public JTable table;
	public DefaultTableModel modelim;
	public JButton searchButton;
	Object[] colums = { "Kafe Adı", "Vergi Numarası", "Vergi Dairesi", "Telefon Numarası", "Adresi", "Kalan Ödeme" };

	public RemainingPaymentFrame() {
		setTitle("Kalan Ödemeler");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 723, 523);
		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 48, 592, 355);
		getContentPane().add(scrollPane);

		table = new JTable();

		scrollPane.setViewportView(table);
		modelim = new DefaultTableModel();
		modelim.setColumnIdentifiers(colums);

		table.setDefaultEditor(Object.class, null);
		searchButton = new JButton("Kalan Ödemeler");
		searchButton.setBounds(299, 428, 147, 23);
		getContentPane().add(searchButton);

	}

}
