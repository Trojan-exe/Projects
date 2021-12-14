package CMPackage;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameMenu extends JFrame {

	private JPanel contentPane;

	public FrameMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMenu.class.getResource("/images/main-icon.png")));
		setTitle("Menu | CONTACT MANAGEMENT SYSTEM");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel imgLabel = new JLabel("");
		imgLabel.setBackground(SystemColor.menu);
		imgLabel.setIcon(new ImageIcon(FrameMenu.class.getResource("/images/menu.png")));
		imgLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imgLabel.setBounds(276, 82, 407, 82);
		contentPane.add(imgLabel);

		JButton addEmpButton = new JButton(" Add Contact");
		addEmpButton.setIcon(new ImageIcon(FrameMenu.class.getResource("/images/icon-9.png")));
		addEmpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fadd.setVisible(true);
			}
		});
		addEmpButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		addEmpButton.setBounds(276, 190, 407, 48);
		contentPane.add(addEmpButton);

		JButton incSalButton = new JButton(" View Contacts");
		incSalButton.setIcon(new ImageIcon(FrameMenu.class.getResource("/images/icon-2.png")));
		incSalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fdis.setVisible(true);
			}
		});
		incSalButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		incSalButton.setBounds(276, 251, 407, 48);
		contentPane.add(incSalButton);
		
		JButton salInfoButton = new JButton(" Delete Contact");
		salInfoButton.setIcon(new ImageIcon(FrameMenu.class.getResource("/images/delete1.jpg")));
		salInfoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fdel.setVisible(true);
			}
		});
		salInfoButton.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		salInfoButton.setBounds(276, 312, 407, 48);
		contentPane.add(salInfoButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameMenu.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(408, 513, 142, 40);
		contentPane.add(backButton);
		setLocationRelativeTo(null);

	}
}