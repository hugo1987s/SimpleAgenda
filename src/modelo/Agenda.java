package modelo;

import java.util.List;

import dto.ContactoDTO;
import dto.LocalidadDTO;
import dto.PersonaDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;

public class Agenda
{
	private PersonaDAO persona;
	private TipoContactoDAO tipoContacto;
	private LocalidadDAO localidad;

	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.tipoContacto = metodo_persistencia.createTipoContactoDAO();
		this.localidad = metodo_persistencia.createLocalidadDAO();
	}

	// Persona
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar)
	{
		this.persona.delete(persona_a_eliminar);
	}

	public void editarPersona(PersonaDTO persona_a_editar)
	{
		this.persona.edit(persona_a_editar);
	}

	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();
	}

	// TipoContacto
	public void agregarTipoContacto(ContactoDTO nuevoTipoContacto)
	{
		this.tipoContacto.insert(nuevoTipoContacto);
	}

	public void borrarTipoContacto(ContactoDTO tipoContacto_a_eliminar)
	{
		this.tipoContacto.delete(tipoContacto_a_eliminar);
	}

	public List<ContactoDTO> obtenerTipoContacto()
	{
		return this.tipoContacto.readAll();
	}

	public void editarTipoContacto(ContactoDTO tipoContacto_a_editar)
	{
		this.tipoContacto.edit(tipoContacto_a_editar);
	}

	// Localidad
	public void agregarLocalidad(LocalidadDTO nuevaLocalidad)
	{
		this.localidad.insert(nuevaLocalidad);
	}

	public void borrarLocalidad(LocalidadDTO localidad_a_eliminar)
	{
		this.localidad.delete(localidad_a_eliminar);
	}

	public List<LocalidadDTO> obtenerLocalidades()
	{
		return this.localidad.readAll();
	}
	
	public void editarLocalidad(LocalidadDTO localidad_a_editar)
	{
		this.localidad.edit(localidad_a_editar);
	}
}
