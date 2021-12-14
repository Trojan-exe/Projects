package CMPackage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Toolkit;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameDisplay extends JFrame {
	
	private JPanel contentPane;
	
	
	public FrameDisplay() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameDisplay.class.getResource("/images/main-icon.png")));
		setTitle("CONTACTS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JLabel headerLabel = new JLabel("Note: Click on \"Show\" button to view all employees information.");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 20));
		headerLabel.setBounds(12, 69, 928, 39);
		contentPane.add(headerLabel);

		JLabel RBLabel = new JLabel("Result Box.");
		RBLabel.setForeground(Color.BLUE);
		RBLabel.setFont(new Font("Courier New", Font.PLAIN, 19));
		RBLabel.setBounds(95, 172, 142, 26);
		contentPane.add(RBLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 205, 770, 300);
		contentPane.add(scrollPane);
		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setValueIsAdjusting(true);
		scrollPane.setViewportView(list);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton showButton = new JButton(" SHOW");
		showButton.setHorizontalAlignment(SwingConstants.LEFT);
		showButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		showButton.setIcon(new ImageIcon(FrameDisplay.class.getResource("/images/icon-2.png")));
		showButton.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				
				DefaultListModel<String> contacts = new DefaultListModel<String>();
				for (Contact cn : Main.contactManager.contactList.values()) {
					if (cn == null)
						break;
					contacts.addElement(cn.ToString());
				}
				list.setModel(contacts);
			}
		});
		showButton.setBounds(420, 121, 106, 34);
		contentPane.add(showButton);

		JButton backButton = new JButton(" BACK");
		backButton.setHorizontalAlignment(SwingConstants.LEFT);
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setIcon(new ImageIcon(FrameDisplay.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setBounds(420, 533, 106, 34);
		contentPane.add(backButton);
	}
}
