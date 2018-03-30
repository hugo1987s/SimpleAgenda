package presentacion.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class ConexionDBDialog extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIP;
	private JTextField txtPuerto;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JButton btnCancelar;
	private JButton btnOK;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			ConexionDBDialog dialog = new ConexionDBDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConexionDBDialog()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\agenda.png"));
		setTitle("Conexi\u00F3n");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 299, 214);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel label = new JLabel("IP/Host");
			label.setBounds(12, 12, 45, 17);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(label);
		}
		{
			txtIP = new JTextField();
			txtIP.setBounds(104, 10, 177, 22);
			txtIP.setColumns(10);
			contentPanel.add(txtIP);
		}
		{
			JLabel label = new JLabel("Puerto");
			label.setBounds(12, 42, 41, 17);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(label);
		}
		{
			txtPuerto = new JTextField();
			txtPuerto.setBounds(104, 40, 177, 22);
			txtPuerto.setColumns(10);
			contentPanel.add(txtPuerto);
		}
		{
			JLabel label = new JLabel("Usuario");
			label.setBounds(12, 76, 45, 17);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(label);
		}
		{
			txtUsuario = new JTextField();
			txtUsuario.setBounds(104, 74, 177, 22);
			txtUsuario.setColumns(10);
			contentPanel.add(txtUsuario);
		}
		{
			JLabel label = new JLabel("Contrase\u00F1a");
			label.setBounds(12, 109, 70, 17);
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			contentPanel.add(label);
		}
		{
			txtPassword = new JPasswordField();
			txtPassword.setBounds(104, 107, 177, 22);
			contentPanel.add(txtPassword);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOK = new JButton("OK");
				btnOK.setActionCommand("OK");
				buttonPane.add(btnOK);
				getRootPane().setDefaultButton(btnOK);
			}
			{
				btnCancelar = new JButton("Salir");
				btnCancelar.setActionCommand("Cancelar");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	public JButton getBtnOk()
	{
		return btnOK;
	}
	
	public JButton getBtnCancelar()
	{
		return btnCancelar;
	}
	
	public JTextField getTxtIP()
	{
		return txtIP;
	}

	public JTextField getTxtPuerto()
	{
		return txtPuerto;
	}

	public JTextField getTxtUsuario()
	{
		return txtUsuario;
	}

	public JPasswordField getTxtPassword()
	{
		return txtPassword;
	}

}
