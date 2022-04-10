package conexiones;

import java.awt.BorderLayout;
import tabla.Tabla;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import conexiones.Conexiones;
import conexiones.Login;

@SuppressWarnings("serial")
public class Register extends JFrame{

	//Inicialización de las variables
	private JFrame frame;
	
	public JTextField txtNombre;
	public JTextField txtApellido;
	public JTextField txtEmail;
	public JTextField txtUsuario;
	public JPasswordField txtContraseña;
	public JTextField txtID;

	 
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 51));
		frame.setBounds(100, 100, 406, 565);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(34, 140, 64, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Apellido");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_1.setBounds(34, 195, 64, 20);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_2.setBounds(34, 314, 64, 14);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2_3.setForeground(Color.WHITE);
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_3.setBounds(36, 375, 88, 14);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Usuario");
		lblNewLabel_2_4.setForeground(Color.WHITE);
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_4.setBounds(34, 255, 64, 14);
		frame.getContentPane().add(lblNewLabel_2_4);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnVolver.setBackground(new Color(220, 20, 60));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Botón para volver a la ventana de incio de sesión
				@SuppressWarnings("unused")
				Login login = new Login();
				Login.main(null);
				frame.dispose();
			}
		});
		btnVolver.setBounds(51, 463, 111, 33);
		frame.getContentPane().add(btnVolver);
		
		JButton btnRegister = new JButton("Crear");
		btnRegister.setForeground(Color.WHITE);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Botón para la creación del usuario
				String ID, fname, lname, email, uname, pass;  
				ID = txtID.getText();				
				fname = txtNombre.getText();
				lname = txtApellido.getText();
				uname = txtUsuario.getText();
				pass = String.valueOf(txtContraseña.getPassword());
				email = txtEmail.getText();
				
				if(uname.equals("")) {
					JOptionPane.showMessageDialog(null , "Añada un nombre de Usuario y/o correo electronico.");
				} 
				else if(pass.equals("")) {
					JOptionPane.showMessageDialog(null , "Escriba una contraseña!");
				} 
				else if(checkUsername(uname)) {
					JOptionPane.showMessageDialog(null , "This username already exists!");
				}
				else {
				
				PreparedStatement ps;
				String query = "INSERT INTO `clientes`(`IdCliente`,`Nombre`, `Apellido`, `Email`, `Usuario`, `Pass`) VALUES (?,?,?,?,?,?)";

				try {
					ps = Conexiones.getConnection().prepareStatement(query);
					ps.setString(1, ID);
					ps.setString(2, fname);
					ps.setString(3, lname);
					ps.setString(4, uname);
					ps.setString(5, email);
					ps.setString(6, pass);
					
					if(ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null , "Usuario creado exitosamente!");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			  }
			}
		});
		
		btnRegister.setBackground(new Color(30, 144, 255));
		btnRegister.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRegister.setBounds(223, 463, 111, 33);
		frame.getContentPane().add(btnRegister);
		//Finalización de la creación del usuario
		
		txtNombre = new JTextField();
		txtNombre.setBounds(134, 139, 190, 20);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(134, 197, 190, 20);
		frame.getContentPane().add(txtApellido);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(134, 254, 190, 20);
		frame.getContentPane().add(txtEmail);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(134, 313, 190, 20);
		frame.getContentPane().add(txtUsuario);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(134, 374, 190, 20);
		frame.getContentPane().add(txtContraseña);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 390, 33);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setBounds(148, 0, 99, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_2_5 = new JLabel("ID");
		lblNewLabel_2_5.setForeground(Color.WHITE);
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2_5.setBounds(34, 87, 64, 14);
		frame.getContentPane().add(lblNewLabel_2_5);
		
		txtID = new JTextField();
		txtID.setColumns(10);
		txtID.setBounds(134, 86, 190, 20);
		frame.getContentPane().add(txtID);
	}
	
	boolean checkUsername (String username) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUser = false;
		
		String query = "SELECT * FROM `usuarios` WHERE `username` =?";
		
		try {
		ps = Conexiones.getConnection().prepareStatement(query);
		ps.setString(1, username);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			checkUser = true;
		}
		
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
		return checkUser;
	}
}
