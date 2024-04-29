package view.payments;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class PaymentFrame extends JInternalFrame {
	public JTable table;
	public DefaultTableModel modelim;
	Object[] colums = {"Ödenen Tutar","Ödeme Tarihi"};
	public JButton searchButton;
	public JComboBox cafeName;
	
	public PaymentFrame() {
		setTitle("Geçmiş Ödemeler");
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 737, 617);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Kafe Adı :");
		lblNewLabel_1_1.setBounds(48, 77, 144, 30);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		getContentPane().add(lblNewLabel_1_1);
		
		 searchButton = new JButton("");
		 searchButton.setBounds(581, 79, 65, 26);
		searchButton.setIcon(new ImageIcon("C:\\Users\\zehra\\OneDrive\\Masaüstü\\icons\\icons8-search-20.png"));
		getContentPane().add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 149, 607, 312);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		cafeName = new JComboBox();
		cafeName.setBounds(147, 77, 424, 30);
		cafeName.setFont(new Font("Tahoma", Font.BOLD, 11));
		getContentPane().add(cafeName);

	}
}
