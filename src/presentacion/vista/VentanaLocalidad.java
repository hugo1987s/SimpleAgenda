package presentacion.vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentacion.controlador.Controlador;

public class VentanaLocalidad extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLocalidades;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private DefaultTableModel modelLocalidades;
	//private String[] nombreColumnas = { "Nombre", "Codigo Postal" };
	private String[] nombreColumnas = { "Codigo Postal", "Nombre" };
	private Controlador controlador;
	private JTextField txtNombreLocalidad;
	private JLabel lblNombreLocalidad;
	private JLabel lblCodigoPostal;
	private JTextField txtCodigoPostal;
	private JButton btnCerrar;

	public VentanaLocalidad(Controlador controlador) {
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 365);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 418, 318);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 400, 182);
		panel.add(spLocalidades);

		modelLocalidades = new DefaultTableModel(null, nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidades);

		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
		tablaLocalidades.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaLocalidades.getColumnModel().getColumn(1).setResizable(false);

		spLocalidades.setViewportView(tablaLocalidades);

		lblNombreLocalidad = new JLabel("Nombre");
		lblNombreLocalidad.setBounds(10, 241, 77, 14);
		panel.add(lblNombreLocalidad);

		txtNombreLocalidad = new JTextField();
		txtNombreLocalidad.setBounds(133, 238, 277, 20);
		txtNombreLocalidad.setColumns(10);
		panel.add(txtNombreLocalidad);

		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(10, 214, 97, 14);
		panel.add(lblCodigoPostal);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(133, 211, 77, 20);
		txtCodigoPostal.setColumns(10);
		panel.add(txtCodigoPostal);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 281, 89, 23);
		btnAgregar.addActionListener(this.controlador);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(111, 281, 89, 23);
		btnEditar.addActionListener(this.controlador);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(212, 281, 89, 23);
		btnBorrar.addActionListener(this.controlador);
		panel.add(btnBorrar);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(313, 280, 97, 25);
		btnCerrar.addActionListener(this.controlador);
		panel.add(btnCerrar);

		this.tablaLocalidades.getSelectionModel().addListSelectionListener(this.controlador);
		
		this.setVisible(true);
	}

	public JTextField getTxtNombre() {
		return txtNombreLocalidad;
	}

	public JTextField getTxtCodigoPostal() {
		return txtCodigoPostal;
	}

	public JButton getBtnAgregarLocalidad() {
		return btnAgregar;
	}

	public JButton getBtnBorrarLocalidad() {
		return btnBorrar;
	}

	public DefaultTableModel getModelLocalidades() {
		return modelLocalidades;
	}

	public JTable getTablaLocalidades() {
		return tablaLocalidades;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}

	public JButton getBtnCerrarLocalidad() {
		return btnCerrar;
	}

	public JButton getBtnEditarLocalidad() {
		return btnEditar;
	}
}