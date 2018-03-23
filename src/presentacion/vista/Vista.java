package presentacion.vista;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import persistencia.conexion.Conexion;

public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = { "ID", "Nombre", "Apellido", "Teléfono",
			"Calle", "Altura", "Piso", "Departamento", "CP", "Localidad",
			"Email", "Fecha Nacimiento", "Tipo Contacto" };
	private JButton btnCerrar;
	private JButton btnEditar;
	private JButton btnContacto;
	private JButton btnLocalidades;
	private JButton btnReporteXFecha;

	public Vista()
	{
		super();
		initialize();
	}

	private void initialize()
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 947, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 956, 269);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 906, 204);
		panel.add(spPersonas);

		modelPersonas = new DefaultTableModel(null, nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);

		tablaPersonas.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		spPersonas
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		spPersonas.setViewportView(tablaPersonas);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 228, 89, 23);
		panel.add(btnAgregar);

		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 228, 89, 23);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 228, 89, 23);
		panel.add(btnBorrar);

		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(550, 228, 89, 23);
		panel.add(btnReporte);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(819, 227, 97, 24);
		panel.add(btnCerrar);

		btnContacto = new JButton("Contacto");
		btnContacto.setBounds(449, 228, 89, 23);
		panel.add(btnContacto);

		btnLocalidades = new JButton("Localidades");
		btnLocalidades.setBounds(309, 228, 128, 23);
		panel.add(btnLocalidades);

		btnReporteXFecha = new JButton("Reporte x Fecha");
		btnReporteXFecha.setBounds(651, 228, 156, 23);
		panel.add(btnReporteXFecha);
	}

	public void show()
	{
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				int confirm = JOptionPane.showOptionDialog(null,
						"Estas seguro que quieres salir de la Agenda!?",
						"Confirmación", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0)
				{
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}

	public JButton getBtnAgregar()
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar()
	{
		return btnBorrar;
	}

	public JButton getBtnReporte()
	{
		return btnReporte;
	}

	public DefaultTableModel getModelPersonas()
	{
		return modelPersonas;
	}

	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas()
	{
		return nombreColumnas;
	}

	public JButton getBtnCerrar()
	{
		return btnCerrar;
	}

	public JButton getBtnEditar()
	{
		return btnEditar;
	}

	public JButton getBtnContactoVista()
	{
		return btnContacto;
	}

	public JButton getBtnLocalidadVista()
	{
		return btnLocalidades;
	}

	public JButton getBtnReporteXFechaVista()
	{
		return btnReporteXFecha;
	}
}
