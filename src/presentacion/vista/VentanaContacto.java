package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistencia.conexion.Conexion;
import presentacion.controlador.Controlador;

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

	public VentanaContacto(Controlador controlador)
	{
		super();
		this.controlador = controlador;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 286);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 262);
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
		btnAgregar.setBounds(10, 206, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 206, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 206, 89, 23);
		btnBorrar.addActionListener(this.controlador);
		panel.add(btnBorrar);
		
		btnCerrar = new JButton("Borrar");
		btnCerrar.setBounds(309, 206, 89, 23);
		panel.add(btnCerrar);
		
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

	
	
}
