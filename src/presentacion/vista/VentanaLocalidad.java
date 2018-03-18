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

public class VentanaLocalidad extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLocalidades;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private DefaultTableModel modelLocalidades;
	private String[] nombreColumnas = { "Nombre", "Codigo Postal" };
	private Controlador controlador;
	private JTextField txtNombreLocalidad;
	private JLabel lblNombreLocalidad;
	private JLabel lblCodigoPostal;
	private JTextField txtCodigoPostal;

	public VentanaLocalidad(Controlador controlador)
	{
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 365);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 327);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(10, 11, 414, 182);
		panel.add(spLocalidades);

		modelLocalidades = new DefaultTableModel(null, nombreColumnas);
		tablaLocalidades = new JTable(modelLocalidades);

		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);
		tablaLocalidades.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaLocalidades.getColumnModel().getColumn(1).setResizable(false);

		spLocalidades.setViewportView(tablaLocalidades);

		lblNombreLocalidad = new JLabel("Nombre");
		lblNombreLocalidad.setBounds(10, 220, 113, 14);
		panel.add(lblNombreLocalidad);

		txtNombreLocalidad = new JTextField();
		txtNombreLocalidad.setBounds(133, 217, 164, 20);
		txtNombreLocalidad.setColumns(10);
		panel.add(txtNombreLocalidad);

		lblCodigoPostal = new JLabel("Codigo Postal");
		lblCodigoPostal.setBounds(10, 261, 113, 14);
		panel.add(lblCodigoPostal);

		txtCodigoPostal = new JTextField();
		txtCodigoPostal.setBounds(133, 258, 164, 20);
		txtCodigoPostal.setColumns(10);
		panel.add(txtCodigoPostal);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 293, 89, 23);
		btnAgregar.addActionListener(this.controlador);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 293, 89, 23);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 293, 89, 23);
		btnBorrar.addActionListener(this.controlador);
		panel.add(btnBorrar);

		this.setVisible(true);
	}

	public JTextField getTxtNombre()
	{
		return txtNombreLocalidad;
	}

	public JTextField getTxtCodigoPostal()
	{
		return txtCodigoPostal;
	}

	public JButton getBtnAgregarLocalidad()
	{
		return btnAgregar;
	}

	public JButton getBtnBorrarLocalidad()
	{
		return btnBorrar;
	}

	public DefaultTableModel getModelLocalidades()
	{
		return modelLocalidades;
	}

	public JTable getTablaLocalidades()
	{
		return tablaLocalidades;
	}

	public String[] getNombreColumnas()
	{
		return nombreColumnas;
	}
}