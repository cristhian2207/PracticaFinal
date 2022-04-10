package conexiones;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexiones.Conexiones;
import conexiones.Register;
import conexiones.Login;
import tabla.Tabla;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class RegisterActualizar {

	//Inicialización de las variables
		private JFrame frame;
		Conexiones cc = new Conexiones();
	    Connection con = cc.getConnection();
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
						RegisterActualizar window = new RegisterActualizar();
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
		public RegisterActualizar() {
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
			
			JButton btnRegister = new JButton("Actualizar");
			btnRegister.setForeground(Color.WHITE);
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Botón para la creación del usuario
					try {
						String SQL = "update clientes set Nombre=?,Apellido=?,Email=?,Usuario=? where IdCliente=?";
						PreparedStatement ps = con.prepareStatement(SQL);
						ps.setString(1, txtNombre.getText());
						ps.setString(2, txtApellido.getText());
						ps.setString(4, txtEmail.getText());
						ps.setString(3, txtUsuario.getText());
						ps.setString(5, txtID.getText());
						int resultado = ps.executeUpdate();
						if (resultado > 0) {
							JOptionPane.showMessageDialog(null, "Registro actualizado");
							frame.dispose();
							con.close();
						}
						else {
							JOptionPane.showMessageDialog(null, "Error al actualizar datos");
						}
					} catch (SQLException e1) {
						JOptionPane.showMessageDialog(null, "Error, "+ e1);
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
			
			JLabel lblNewLabel = new JLabel("Register para actualizar ");
			lblNewLabel.setBounds(52, 0, 317, 29);
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
