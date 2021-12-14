package CMPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

@SuppressWarnings("serial")
public class FrameDelete extends JFrame{
	
	private JPanel contentPane;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField PhoneNumber;
	private Contact contact;

	public FrameDelete() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameDelete.class.getResource("/images/main-icon.png")));
		setTitle("DELETE CONTACT");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 970, 670);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headerLabel = new JLabel("Note: Enter correct details and press \"DELETE\"");
		headerLabel.setForeground(Color.RED);
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		headerLabel.setBounds(12, 105, 928, 39);
		contentPane.add(headerLabel);
		
		JLabel firstname = new JLabel("First Name");
		firstname.setHorizontalAlignment(SwingConstants.RIGHT);
		firstname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		firstname.setBounds(207, 170, 144, 34);
		contentPane.add(firstname);

		FirstName = new JTextField();
		FirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		FirstName.setBounds(381, 171, 265, 37);
		contentPane.add(FirstName);
		FirstName.setColumns(10);

		JLabel lastname = new JLabel("Last Name");
		lastname.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lastname.setHorizontalAlignment(SwingConstants.RIGHT);
		lastname.setBounds(207, 225, 144, 34);
		contentPane.add(lastname);
		setLocationRelativeTo(null);

		LastName = new JTextField();
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		LastName.setBounds(381, 226, 265, 37);
		contentPane.add(LastName);
		LastName.setColumns(10);
		
		JLabel phonenumber = new JLabel("Phone Number");
		phonenumber.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		phonenumber.setHorizontalAlignment(SwingConstants.RIGHT);
		phonenumber.setBounds(207, 279, 144, 34);
		contentPane.add(phonenumber);
		setLocationRelativeTo(null);

		PhoneNumber = new JTextField();
		PhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		PhoneNumber.setBounds(381, 280, 265, 37);
		contentPane.add(PhoneNumber);
		PhoneNumber.setColumns(10);

		JButton OKButton = new JButton("DELETE");
		OKButton.setIcon(new ImageIcon(FrameDelete.class.getResource("/images/delete1.jpg")));
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = FirstName.getText();
				String lastName = LastName.getText();
				String phoneNumber = PhoneNumber.getText();
				contact = new Contact(firstName, lastName, phoneNumber);
				
				if (Main.contactManager.isPresent(contact)) {
					Main.contactManager.deleteContact(contact);
					JOptionPane.showMessageDialog(null, "Contact Deleted Successfully");
				} else {
					FirstName.setText(null);
					LastName.setText(null);
					JOptionPane.showMessageDialog(null, "Contact doesn't exist.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		OKButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		OKButton.setBounds(391, 350, 108, 39);
		contentPane.add(OKButton);

		JButton backButton = new JButton(" BACK");
		backButton.setIcon(new ImageIcon(FrameDelete.class.getResource("/images/icon-3.png")));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Main.fmenu.setVisible(true);
			}
		});
		backButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		backButton.setBounds(526, 350, 108, 39);
		contentPane.add(backButton);
	}
	public static void main(String args[])
	{
		FrameDelete fd = new FrameDelete();
		fd.setVisible(true);
	}
}
