package conexiones;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import tabla.Tabla;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import conexiones.Conexiones;
import conexiones.Register;
import java.awt.Label;


public class Login {

	//Inicialización de las variables 
	private JFrame frame;
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnLogin;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblRegister;
	private JButton btnNewButton;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Iniciar sesión");
		frame.setResizable(false);
		frame.setBounds(100, 100, 828, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 153, 204));
		panel_1.setBounds(0, 0, 999, 652);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(226, 87, 358, 473);
		panel_1.add(panel);
		panel.setBackground(new Color(255, 153, 0));
		panel.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(78, 189, 197, 26);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBorder(null);
		txtContraseña.setBounds(78, 284, 197, 26);
		panel.add(txtContraseña);
		
		lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(78, 151, 63, 26);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(78, 259, 104, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("INICIO DE SESI\u00D3N");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_6.setBounds(26, 46, 306, 64);
		panel.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("\u00BFNo est\u00E1 registrado?");
		lblNewLabel_7.setBounds(44, 434, 138, 14);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Click aqu\u00ED para registrarse");
		lblNewLabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				@SuppressWarnings("unused")
				Register registro = new Register();
				Register.main(null);
				frame.dispose();
			}
		});
		lblNewLabel_8.setForeground(new Color(0, 102, 255));
		lblNewLabel_8.setBounds(166, 434, 166, 14);
		panel.add(lblNewLabel_8);
	
		
		btnNewButton_1 = new JButton("Inicie Sesi\u00F3n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Preparación del inicio de sesión
				PreparedStatement ps;
				ResultSet rs;
				String uname = txtUsuario.getText();
				String pass = String.valueOf(txtContraseña.getPassword());
				
				String query = "SELECT * FROM `clientes` WHERE `Usuario` =? AND `Pass` =?";
				try {
					ps = Conexiones.getConnection().prepareStatement(query);
					ps.setString(1, uname);
					ps.setString(2, pass);
					rs = ps.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Conexion establecida");
						Tabla tb = new Tabla();
						
						tb.setVisible(true);
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Nombre de Usuario o Contraseña incorrecta");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(204, 0, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(117, 356, 118, 34);
		panel.add(btnNewButton_1);
		
		}
}

	


