package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;

public class VentanaPersona extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	private JTextField txtAltura;
	private JTextField txtCalle;
	private JTextField txtDepartamento;
	private JTextField txtPiso;
	private JTextField txtFechaNacimiento;
	private JTextField txtEmail;
	private JButton btnABMContactos;
	private JButton btnABMLocalidades;
	private JButton btnCerrar;
	private JComboBox<Object> cboLocalidad;
	private JComboBox<Object> cboContacto;

	public VentanaPersona(Controlador controlador)
	{
		super();
		setResizable(false);
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 466, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 442, 381);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(10, 44, 113, 14);
		panel.add(lblTelfono);

		txtNombre = new JTextField();
		txtNombre.setBounds(133, 8, 297, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 41, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(242, 350, 89, 23);
		panel.add(btnAgregarPersona);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(10, 77, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(10, 110, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(10, 142, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 175, 113, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(10, 209, 113, 14);
		panel.add(lblLocalidad);

		JLabel lblFechaDeCumpleaos = new JLabel("Fecha de Cumplea\u00F1os");
		lblFechaDeCumpleaos.setBounds(12, 276, 149, 14);
		panel.add(lblFechaDeCumpleaos);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 243, 113, 14);
		panel.add(lblEmail);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(10, 307, 149, 14);
		panel.add(lblTipoDeContacto);

		txtAltura = new JTextField();
		txtAltura.setColumns(10);
		txtAltura.setBounds(133, 107, 67, 20);
		panel.add(txtAltura);

		txtCalle = new JTextField();
		txtCalle.setColumns(10);
		txtCalle.setBounds(133, 74, 297, 20);
		panel.add(txtCalle);

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(133, 172, 67, 20);
		panel.add(txtDepartamento);

		txtPiso = new JTextField();
		txtPiso.setColumns(10);
		txtPiso.setBounds(133, 139, 67, 20);
		panel.add(txtPiso);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(168, 273, 164, 20);
		panel.add(txtFechaNacimiento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(133, 240, 297, 20);
		panel.add(txtEmail);

		cboLocalidad = new JComboBox<Object>();
		getCboLocalidad().setBounds(133, 205, 246, 22);
		panel.add(getCboLocalidad());

		cboContacto = new JComboBox<Object>();
		getCboContacto().setBounds(133, 303, 246, 22);
		panel.add(getCboContacto());

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(341, 350, 89, 23);
		btnCerrar.addActionListener(this.controlador);
		panel.add(btnCerrar);

		btnABMContactos = new JButton("...");
		btnABMContactos.setBounds(391, 302, 39, 25);
		btnABMContactos.addActionListener(this.controlador);
		panel.add(btnABMContactos);

		btnABMLocalidades = new JButton("...");
		btnABMLocalidades.setBounds(391, 204, 39, 25);
		btnABMLocalidades.addActionListener(this.controlador);
		panel.add(btnABMLocalidades);

		this.setVisible(true);
	}

	public JTextField getTxtNombre()
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono()
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona()
	{
		return btnAgregarPersona;
	}

	public JButton getBtnABMContactos()
	{
		return btnABMContactos;
	}

	public JButton getBtnABMLocalidades()
	{
		return btnABMLocalidades;
	}

	public JButton getBtnCerrarVentanaPersona()
	{
		return btnCerrar;
	}

	public JComboBox getCboLocalidad()
	{
		return cboLocalidad;
	}

	public JComboBox getCboContacto()
	{
		return cboContacto;
	}

}
