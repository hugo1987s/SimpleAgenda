package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexion.Conexion;
import presentacion.controlador.Controlador;

import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaContacto extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblContactos;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnBorrar;
	private DefaultTableModel modelContactos;
	private String[] nombreColumnas = {"ID", "Descripcion"};
	private Controlador controlador;
	private JButton btnCerrar;
	private JTextField txtDescripcion;
	private JLabel lblDescripcion;

	public VentanaContacto(Controlador controlador)
	{
		super();
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 327);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 298);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane spContactos = new JScrollPane();
		spContactos.setBounds(10, 11, 388, 182);
		panel.add(spContactos);
		
		modelContactos = new DefaultTableModel(null, nombreColumnas);
		this.tblContactos = new JTable(modelContactos);
		
		
		getTblContactos().getColumnModel().getColumn(0).setPreferredWidth(103);
		getTblContactos().getColumnModel().getColumn(0).setResizable(false);
		getTblContactos().getColumnModel().getColumn(1).setPreferredWidth(100);
		getTblContactos().getColumnModel().getColumn(1).setResizable(false);

		spContactos.setViewportView(getTblContactos());
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 241, 89, 23);
		btnAgregar.addActionListener(this.controlador);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 241, 89, 23);
		btnEditar.addActionListener(this.controlador);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 241, 89, 23);
		btnBorrar.addActionListener(this.controlador);
		panel.add(btnBorrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(309, 241, 89, 23);
		btnCerrar.addActionListener(this.controlador);
		panel.add(btnCerrar);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(140, 206, 258, 22);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(20, 212, 89, 16);
		panel.add(lblDescripcion);
		
		
		this.tblContactos.getSelectionModel().addListSelectionListener(this.controlador);
		
		this.setVisible(true);
	}
	
	public DefaultTableModel getModelContactos() 
	{
		return modelContactos;
	}

	public String[] getNombreColumnas()
	{
		return nombreColumnas;
	}

	public JButton getBtnBorrarContacto()
	{
		return btnBorrar;
	}

	public JTable getTblContactos()
	{
		return tblContactos;
	}

	public JTextField getTxtDescripcion()
	{
		return txtDescripcion;
	}
	
	public JButton getBtnCerrarContacto()
	{
		return btnCerrar;
	}
	
	public JButton getBtnAgregarContacto()
	{
		return btnAgregar;
	}
	
	public JButton getBtnEditarContacto()
	{
		return btnEditar;
	}
}
