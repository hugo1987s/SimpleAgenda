package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class VentanaConexionDB extends JFrame
{
	public VentanaConexionDB() {
		setTitle("Conectar");
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblIp = new JLabel("IP/Host");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIp.setBounds(12, 13, 56, 16);
		panel.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto");
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPuerto.setBounds(12, 42, 56, 16);
		panel.add(lblPuerto);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuario.setBounds(12, 71, 56, 16);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(12, 100, 96, 16);
		panel.add(lblContrasea);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(122, 156, 97, 25);
		panel.add(btnIngresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(231, 156, 97, 25);
		panel.add(btnSalir);
		
		txtIP = new JTextField();
		txtIP.setBounds(108, 11, 220, 22);
		panel.add(txtIP);
		txtIP.setColumns(10);
		
		txtPuerto = new JTextField();
		txtPuerto.setColumns(10);
		txtPuerto.setBounds(108, 40, 220, 22);
		panel.add(txtPuerto);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(108, 69, 220, 22);
		panel.add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(108, 98, 220, 22);
		panel.add(txtPassword);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtIP;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
}
