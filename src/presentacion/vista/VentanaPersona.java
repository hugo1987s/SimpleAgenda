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
	private JLabel lblId;
	private JTextField txtID;
	private JLabel lblApellido;
	private JTextField txtApellido;

	public VentanaPersona(Controlador controlador)
	{
		super();
		setResizable(false);
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 474, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 442, 436);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 46, 113, 14);
		panel.add(lblNombre);

		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setBounds(12, 106, 113, 14);
		panel.add(lblTelfono);

		txtNombre = new JTextField();
		txtNombre.setBounds(135, 43, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		txtTelefono = new JTextField();
		txtTelefono.setBounds(135, 103, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);

		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.addActionListener(this.controlador);
		btnAgregarPersona.setBounds(245, 400, 89, 23);
		panel.add(btnAgregarPersona);

		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(12, 139, 113, 14);
		panel.add(lblCalle);

		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setBounds(12, 172, 113, 14);
		panel.add(lblAltura);

		JLabel lblPiso = new JLabel("Piso");
		lblPiso.setBounds(12, 204, 113, 14);
		panel.add(lblPiso);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(12, 237, 113, 14);
		panel.add(lblDepartamento);

		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setBounds(12, 271, 113, 14);
		panel.add(lblLocalidad);

		JLabel lblFechaDeCumpleaos = new JLabel("Fecha de Cumplea\u00F1os");
		lblFechaDeCumpleaos.setBounds(14, 338, 149, 14);
		panel.add(lblFechaDeCumpleaos);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(12, 305, 113, 14);
		panel.add(lblEmail);

		JLabel lblTipoDeContacto = new JLabel("Tipo de Contacto");
		lblTipoDeContacto.setBounds(12, 369, 149, 14);
		panel.add(lblTipoDeContacto);

		txtAltura = new JTextField();
		txtAltura.setText("0");
		txtAltura.setColumns(10);
		txtAltura.setBounds(135, 169, 67, 20);
		panel.add(txtAltura);

		txtCalle = new JTextField();
		getTxtCalle().setColumns(10);
		getTxtCalle().setBounds(135, 136, 297, 20);
		panel.add(getTxtCalle());

		txtDepartamento = new JTextField();
		txtDepartamento.setColumns(10);
		txtDepartamento.setBounds(135, 234, 67, 20);
		panel.add(txtDepartamento);

		txtPiso = new JTextField();
		txtPiso.setText("0");
		txtPiso.setColumns(10);
		txtPiso.setBounds(135, 201, 67, 20);
		panel.add(txtPiso);

		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(170, 335, 164, 20);
		panel.add(txtFechaNacimiento);

		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(135, 302, 297, 20);
		panel.add(txtEmail);

		cboLocalidad = new JComboBox<Object>();
		getCboLocalidad().setBounds(135, 267, 246, 22);
		panel.add(getCboLocalidad());

		cboContacto = new JComboBox<Object>();
		getCboContacto().setBounds(135, 365, 246, 22);
		panel.add(getCboContacto());

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(343, 400, 89, 23);
		btnCerrar.addActionListener(this.controlador);
		panel.add(btnCerrar);

		btnABMContactos = new JButton("...");
		btnABMContactos.setBounds(393, 364, 39, 25);
		btnABMContactos.addActionListener(this.controlador);
		panel.add(btnABMContactos);

		btnABMLocalidades = new JButton("...");
		btnABMLocalidades.setBounds(393, 266, 39, 25);
		btnABMLocalidades.addActionListener(this.controlador);
		panel.add(btnABMLocalidades);

		lblId = new JLabel("ID");
		lblId.setBounds(12, 16, 113, 14);
		panel.add(lblId);

		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		txtID.setBounds(135, 13, 83, 20);
		panel.add(txtID);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 76, 113, 14);
		panel.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(135, 73, 297, 20);
		panel.add(txtApellido);

		this.setVisible(true);
	}

	public JTextField getTxtNombre()
	{
		return txtNombre;
	}

	public JTextField getTxtApellido()
	{
		return txtApellido;
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

	public JTextField getTxtCalle()
	{
		return txtCalle;
	}

	public JTextField getTxtAltura()
	{
		return txtAltura;
	}

	public JTextField getTxtPiso()
	{
		return txtPiso;
	}

	public JTextField getTxtDepartamento()
	{
		return txtDepartamento;
	}

	public JTextField getTxtEmail()
	{
		return txtEmail;
	}

	public JTextField getTxtFechaNacimiento()
	{
		return txtFechaNacimiento;
	}

	public JTextField getTxtID()
	{
		return txtID;
	}
}
