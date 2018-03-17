package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VistaContacto extends JFrame {
	
	
	private DefaultTableModel modelContacto;
	private String[] nombreColumnas = {"ID","Tipo de Contacto"};
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnCerrar;
	private JTable tblTipoContacto;
	private static final long serialVersionUID = 1L;
	
	
	public VistaContacto() {
		setResizable(false);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		panel.add(spPersonas);
		
		btnAgregar = new JButton("Agregar");
		getBtnAgregar().setBounds(12, 215, 91, 25);
		panel.add(getBtnAgregar());
		
		
		modelContacto = new DefaultTableModel(null,nombreColumnas);
		
		tblTipoContacto = new JTable(modelContacto);
		tblTipoContacto.getColumnModel().getColumn(0).setPreferredWidth(40);
		tblTipoContacto.getColumnModel().getColumn(0).setResizable(false);
		tblTipoContacto.getColumnModel().getColumn(1).setPreferredWidth(150);
		tblTipoContacto.getColumnModel().getColumn(1).setResizable(false);
		
		tblTipoContacto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblTipoContacto.setBounds(12, 13, 400, 189);
		
		panel.add(tblTipoContacto);
		
		btnModificar = new JButton("Modificar");
		getBtnModificar().setBounds(115, 215, 91, 25);
		panel.add(getBtnModificar());
		
		btnBorrar = new JButton("Borrar");
		getBtnBorrar().setBounds(218, 215, 91, 25);
		panel.add(getBtnBorrar());
		
		btnCerrar = new JButton("Cerrar");
		getBtnCerrar().setBounds(321, 215, 91, 25);
		panel.add(getBtnCerrar());
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public JButton getBtnCerrar() {
		return btnCerrar;
	}


	
}
