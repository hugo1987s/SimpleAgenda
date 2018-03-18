package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import modelo.Agenda;
import persistencia.conexion.Conexion;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaContacto;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.Vista;

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
		this.vista.getBtnEditar().addActionListener(this);

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
			Object[] fila = {
					this.personas_en_tabla.get(i).getIdPersona(),
					this.personas_en_tabla.get(i).getNombre(),
					this.personas_en_tabla.get(i).getTelefono(),
					this.personas_en_tabla.get(i).getCalle(),
					this.personas_en_tabla.get(i).getAltura(),
					this.personas_en_tabla.get(i).getPiso(),
					this.personas_en_tabla.get(i).getDepartamento(),
					this.personas_en_tabla.get(i).getLocalidad()
							.getCodigoPostal(),
					this.personas_en_tabla.get(i).getLocalidad().getNombre(),
					this.personas_en_tabla.get(i).getEmail(),
					formatearFecha(this.personas_en_tabla.get(i)
							.getFechaNacimiento()),
					this.personas_en_tabla.get(i).getContacto().getTipo()

			};

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
			Object[] fila = {
					this.localidades_en_tabla.get(i).getCodigoPostal(),
					this.localidades_en_tabla.get(i).getNombre() };
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

		} else if (e.getSource() == this.vista.getBtnEditar())
		{
			if (this.vista.getTablaPersonas().getSelectedRows().length > 0)
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas()
						.getSelectedRows();

				PersonaDTO oPersona = null;

				for (int fila : filas_seleccionadas)
				{
					oPersona = new PersonaDTO(this.personas_en_tabla.get(fila));
				}

				this.ventanaPersona = new VentanaPersona(this);
				this.ventanaPersona.getTxtID().setText(
						String.valueOf(oPersona.getIdPersona()));
				this.ventanaPersona.getTxtNombre()
						.setText(oPersona.getNombre());
				this.ventanaPersona.getTxtTelefono().setText(
						oPersona.getTelefono());
				this.ventanaPersona.getTxtCalle().setText(oPersona.getCalle());
				this.ventanaPersona.getTxtAltura().setText(
						String.valueOf(oPersona.getAltura()));
				this.ventanaPersona.getTxtPiso().setText(
						String.valueOf(oPersona.getPiso()));
				this.ventanaPersona.getTxtDepartamento().setText(
						oPersona.getDepartamento());
				this.ventanaPersona.getTxtEmail().setText(oPersona.getEmail());
				this.ventanaPersona.getTxtFechaNacimiento().setText(
						formatearFecha(oPersona.getFechaNacimiento()));
				this.ventanaPersona.getBtnAgregarPersona().setText("Editar");
				CargarCombos(this.ventanaPersona);

				ventanaPersona.getCboContacto().getModel()
						.setSelectedItem(oPersona.getContacto());
				ventanaPersona.getCboLocalidad().getModel()
						.setSelectedItem(oPersona.getLocalidad());
			}

		}

		else if (e.getSource() == this.vista.getBtnReporte())
		{
			ReporteAgenda reporte = new ReporteAgenda(agenda.obtenerPersonas());
			reporte.mostrar();
		} else if (e.getSource() == this.vista.getBtnCerrar())
		{

			Conexion.getConexion().cerrarConexion();
			System.exit(0);

		} else if (this.ventanaPersona != null
				&& e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
		{
			ContactoDTO contacto = (ContactoDTO) ventanaPersona
					.getCboContacto().getSelectedItem();
			LocalidadDTO localidad = (LocalidadDTO) ventanaPersona
					.getCboLocalidad().getSelectedItem();

			PersonaDTO objPersona = new PersonaDTO(0, this.ventanaPersona
					.getTxtNombre().getText(), ventanaPersona.getTxtTelefono()
					.getText(), ventanaPersona.getTxtCalle().getText(),
					Integer.parseInt(ventanaPersona.getTxtAltura().getText()),
					Integer.parseInt(ventanaPersona.getTxtPiso().getText()),
					ventanaPersona.getTxtDepartamento().getText(),
					ventanaPersona.getTxtEmail().getText(),
					obtenerFechaNacimiento(), contacto, localidad);

			if (this.ventanaPersona.getBtnAgregarPersona().getText() == "Agregar")
			{
				this.agenda.agregarPersona(objPersona);
			} else
			{
				objPersona.setIdPersona(Integer.parseInt(ventanaPersona
						.getTxtID().getText()));
				this.agenda.editarPersona(objPersona);
			}

			this.llenarTabla();

			this.ventanaPersona.dispose();
		}

		else if (this.ventanaPersona != null
				&& e.getSource() == this.ventanaPersona.getBtnABMLocalidades())
		{
			this.ventanaLocalidad = new VentanaLocalidad(this);
			this.llenarTablaLocalidades();
			
			this.CargarComboLocalidades(ventanaPersona);
			this.ventanaLocalidad.getTxtNombre().setText("");
			this.ventanaLocalidad.getTxtCodigoPostal().setText("");
		} 
		else if (e.getSource() == this.ventanaPersona
				.getBtnCerrarVentanaPersona())
		{
			this.ventanaPersona.dispose();
		}

		else if (this.ventanaPersona != null
				&& e.getSource() == this.ventanaPersona.getBtnABMContactos())
		{
			this.ventanaContacto = new VentanaContacto(this);
			this.llenarTablaContactos();

		}

		else if (this.ventanaContacto != null
				&& e.getSource() == this.ventanaContacto.getBtnBorrarContacto())
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

		else if (this.ventanaContacto != null
				&& e.getSource() == this.ventanaContacto.getBtnCerrarContacto())
		{
			this.ventanaContacto.dispose();

		}

		else if (this.ventanaContacto != null
				&& e.getSource() == this.ventanaContacto
						.getBtnAgregarContacto())
		{
			if (this.ventanaContacto.getTxtDescripcion().getText().trim() != "")
			{
				ContactoDTO objContacto = new ContactoDTO(0,
						this.ventanaContacto.getTxtDescripcion().getText());
				this.agenda.agregarTipoContacto(objContacto);
				this.llenarTablaContactos();
				this.CargarComboContacto(ventanaPersona);
			}
		} else if (this.ventanaContacto != null
				&& e.getSource() == this.ventanaContacto.getBtnEditarContacto())
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

			this.llenarTablaLocalidades();
		} else if (this.ventanaLocalidad != null
				&& e.getSource() == this.ventanaLocalidad
						.getBtnAgregarLocalidad())
		{

			LocalidadDTO nuevaLocalidad = new LocalidadDTO(
					Integer.parseInt(this.ventanaLocalidad.getTxtCodigoPostal()
							.getText()), this.ventanaLocalidad.getTxtNombre()
							.getText());
			this.agenda.agregarLocalidad(nuevaLocalidad);

			this.llenarTablaLocalidades();
			this.CargarComboLocalidades(ventanaPersona);
			this.ventanaLocalidad.getTxtNombre().setText("");
			this.ventanaLocalidad.getTxtCodigoPostal().setText("");
		}

		else if (this.ventanaLocalidad != null
				&& e.getSource() == this.ventanaLocalidad
						.getBtnBorrarLocalidad())
		{
			int[] filas_seleccionadas = this.ventanaLocalidad
					.getTablaLocalidades().getSelectedRows();
			for (int fila : filas_seleccionadas)
			{
				this.agenda
						.borrarLocalidad(this.localidades_en_tabla.get(fila));
			}

			this.llenarTablaLocalidades();
			this.CargarComboLocalidades(ventanaPersona);
		}

		else if (this.ventanaLocalidad != null
				&& e.getSource() == this.ventanaLocalidad
						.getBtnCerrarLocalidad())
		{
			this.ventanaLocalidad.dispose();

		} else if (this.ventanaLocalidad != null
				&& e.getSource() == this.ventanaLocalidad
						.getBtnEditarLocalidad())
		{
			int codigoPostal = Integer.parseInt(this.ventanaLocalidad
					.getTablaLocalidades()
					.getValueAt(
							this.ventanaLocalidad.getTablaLocalidades()
									.getSelectedRow(), 0).toString());

			String valor = this.ventanaLocalidad.getTxtNombre().getText();

			if (valor.trim() != "")
			{
				LocalidadDTO objLocalidad = new LocalidadDTO(codigoPostal,
						valor.trim());

				this.agenda.editarLocalidad(objLocalidad);
				this.llenarTablaLocalidades();
				this.CargarComboLocalidades(ventanaPersona);
				this.ventanaLocalidad.getTxtNombre().setText("");
				this.ventanaLocalidad.getTxtCodigoPostal().setText("");
			}

		}
	}

	private String formatearFecha(Date fecha)
	{
		DateFormat format = new SimpleDateFormat("d/M/yyyy",
				Locale.getDefault());
		String retorno;

		retorno = format.format(fecha);

		return retorno;
	}

	private Date obtenerFechaNacimiento()
	{
		DateFormat format = new SimpleDateFormat("d/M/yyyy",
				Locale.getDefault());
		Date fechaNacimiento = new Date();
		try
		{
			fechaNacimiento = format.parse(ventanaPersona
					.getTxtFechaNacimiento().getText());
		} catch (ParseException e1)
		{
			e1.printStackTrace();
		}

		return fechaNacimiento;
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

		if (this.ventanaContacto != null)
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
		if (this.ventanaLocalidad != null)
		{
			if (this.ventanaLocalidad.getTablaLocalidades().getRowCount() > 0)
			{
				String codigoPostal = this.ventanaLocalidad
						.getTablaLocalidades()
						.getValueAt(
								this.ventanaLocalidad.getTablaLocalidades()
										.getSelectedRow(), 0).toString();
				String nombreLocalidad = this.ventanaLocalidad
						.getTablaLocalidades()
						.getValueAt(
								this.ventanaLocalidad.getTablaLocalidades()
										.getSelectedRow(), 1).toString();

				ventanaLocalidad.getTxtCodigoPostal().setText(codigoPostal);
				ventanaLocalidad.getTxtNombre().setText(nombreLocalidad);

			}
		}
	}
}