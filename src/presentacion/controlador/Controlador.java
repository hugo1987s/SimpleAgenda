package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;
import presentacion.vista.VentanaContacto;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import dto.ContactoDTO;

public class Controlador implements ActionListener, ListSelectionListener
{
	private Vista vista;
	private List<PersonaDTO> personas_en_tabla;
	private VentanaPersona ventanaPersona;
	private Agenda agenda;

	private VentanaContacto ventanaContacto;
	private List<ContactoDTO> tipoContactos_en_tabla;

	private List<LocalidadDTO> localidades_en_tabla;
	private VentanaLocalidad ventanaLocalidad;

	public Controlador(Vista vista, Agenda agenda)
	{
		this.vista = vista;
		this.vista.getBtnAgregar().addActionListener(this);
		this.vista.getBtnBorrar().addActionListener(this);
		this.vista.getBtnReporte().addActionListener(this);
		this.agenda = agenda;
		this.personas_en_tabla = null;
		this.vista.getBtnCerrar().addActionListener(this);

	}

	public void inicializar()
	{
		this.llenarTabla();
		this.vista.show();
	}

	private void llenarTabla()
	{
		this.vista.getModelPersonas().setRowCount(0); // Para vaciar la tabla
		this.vista.getModelPersonas().setColumnCount(0);
		this.vista.getModelPersonas().setColumnIdentifiers(
				this.vista.getNombreColumnas());

		this.personas_en_tabla = agenda.obtenerPersonas();
		for (int i = 0; i < this.personas_en_tabla.size(); i++)
		{
			Object[] fila = { this.personas_en_tabla.get(i).getNombre(),
					this.personas_en_tabla.get(i).getTelefono() };
			this.vista.getModelPersonas().addRow(fila);
		}
	}

	public void llenarTablaLocalidades()
	{
		this.ventanaLocalidad.getModelLocalidades().setRowCount(0);
		this.ventanaLocalidad.getModelLocalidades().setColumnCount(0);
		this.ventanaLocalidad.getModelLocalidades().setColumnIdentifiers(
				this.ventanaLocalidad.getNombreColumnas());

		this.localidades_en_tabla = agenda.obtenerLocalidades();
		for (int i = 0; i < this.localidades_en_tabla.size(); i++)
		{
			Object[] fila = { this.localidades_en_tabla.get(i).getNombre(),
					this.localidades_en_tabla.get(i).getCodigoPostal() };
			this.ventanaLocalidad.getModelLocalidades().addRow(fila);
		}
	}

	private void llenarTablaContactos()
	{
		this.ventanaContacto.getModelContactos().setRowCount(0); // Para vaciar
																	// la tabla
		this.ventanaContacto.getModelContactos().setColumnCount(0);
		this.ventanaContacto.getModelContactos().setColumnIdentifiers(
				this.ventanaContacto.getNombreColumnas());

		this.tipoContactos_en_tabla = agenda.obtenerTipoContacto();
		for (int i = 0; i < this.tipoContactos_en_tabla.size(); i++)
		{
			Object[] fila = {
					this.tipoContactos_en_tabla.get(i).getIdTipoContacto(),
					this.tipoContactos_en_tabla.get(i).getTipo() };
			this.ventanaContacto.getModelContactos().addRow(fila);
		}
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.vista.getBtnAgregar())
		{
			this.ventanaPersona = new VentanaPersona(this);
			CargarCombos(this.ventanaPersona);

		} else if (e.getSource() == this.vista.getBtnBorrar())
		{
			int[] filas_seleccionadas = this.vista.getTablaPersonas()
					.getSelectedRows();
			for (int fila : filas_seleccionadas)
			{
				this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
			}

			this.llenarTabla();

		} else if (e.getSource() == this.vista.getBtnReporte())
		{
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == this.vista.getBtnCerrar())
		{

			Conexion.getConexion().cerrarConexion();
			System.exit(0);

		} else if (e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
		{
			PersonaDTO nuevaPersona = new PersonaDTO(0, this.ventanaPersona
					.getTxtNombre().getText(), ventanaPersona.getTxtTelefono()
					.getText());
			this.agenda.agregarPersona(nuevaPersona);
			this.llenarTabla();

			ContactoDTO contactoSeleccionado = (ContactoDTO) ventanaPersona
					.getCboContacto().getSelectedItem();
			LocalidadDTO localidadSeleccionada = (LocalidadDTO) ventanaPersona
					.getCboLocalidad().getSelectedItem();

			this.ventanaPersona.dispose();
		}

		else if (e.getSource() == this.ventanaPersona.getBtnABMLocalidades())
		{
			this.ventanaLocalidad = new VentanaLocalidad(this);
			this.llenarTablaLocalidades();
		} else if (e.getSource() == this.ventanaPersona
				.getBtnCerrarVentanaPersona())
		{
			this.ventanaPersona.dispose();
		}

		else if (e.getSource() == this.ventanaPersona.getBtnABMContactos())
		{
			this.ventanaContacto = new VentanaContacto(this);
			this.llenarTablaContactos();

		} else if (e.getSource() == this.ventanaContacto.getBtnBorrarContacto())
		{
			int[] filas_seleccionadas = this.ventanaContacto.getTblContactos()
					.getSelectedRows();
			for (int fila : filas_seleccionadas)
			{
				this.agenda.borrarTipoContacto(this.tipoContactos_en_tabla
						.get(fila));
			}

			this.llenarTablaContactos();
			this.CargarComboContacto(ventanaPersona);
		}

		else if (e.getSource() == this.ventanaContacto.getBtnCerrarContacto())
		{
			this.ventanaContacto.dispose();

		}

		else if (e.getSource() == this.ventanaContacto.getBtnAgregarContacto())
		{
			if (this.ventanaContacto.getTxtDescripcion().getText().trim() != "")
			{
				ContactoDTO objContacto = new ContactoDTO(0,
						this.ventanaContacto.getTxtDescripcion().getText());
				this.agenda.agregarTipoContacto(objContacto);
				this.llenarTablaContactos();
				this.CargarComboContacto(ventanaPersona);
			}
		} else if (e.getSource() == this.ventanaContacto.getBtnEditarContacto())
		{

			int idContacto = Integer.parseInt(this.ventanaContacto
					.getTblContactos()
					.getValueAt(
							this.ventanaContacto.getTblContactos()
									.getSelectedRow(), 0).toString());

			String valor = this.ventanaContacto.getTxtDescripcion().getText();

			if (valor.trim() != "")
			{
				ContactoDTO objContacto = new ContactoDTO(idContacto,
						valor.trim());

				this.agenda.editarTipoContacto(objContacto);
				this.llenarTablaContactos();
				this.CargarComboContacto(ventanaPersona);
			}
		}

	}

	private void CargarCombos(VentanaPersona ventanaPersona)
	{
		CargarComboContacto(ventanaPersona);
		CargarComboLocalidades(ventanaPersona);
	}

	@SuppressWarnings("unchecked")
	private void CargarComboContacto(VentanaPersona ventanaPersona)
	{
		List<ContactoDTO> oList = agenda.obtenerTipoContacto();
		ventanaPersona.getCboContacto().removeAllItems();

		for (int i = 0; i < oList.size(); i++)
		{
			ventanaPersona.getCboContacto().addItem(oList.get(i));
		}
	}

	@SuppressWarnings({ "unchecked" })
	private void CargarComboLocalidades(VentanaPersona ventanaPersona)
	{
		List<LocalidadDTO> oList = agenda.obtenerLocalidades();
		ventanaPersona.getCboLocalidad().removeAllItems();

		for (int i = 0; i < oList.size(); i++)
		{
			ventanaPersona.getCboLocalidad().addItem(oList.get(i));
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		if (this.ventanaContacto.getTblContactos().getRowCount() > 0)
		{
			String valor = this.ventanaContacto
					.getTblContactos()
					.getValueAt(
							this.ventanaContacto.getTblContactos()
									.getSelectedRow(), 1).toString();

			ventanaContacto.getTxtDescripcion().setText(valor);
		}

	}

}
