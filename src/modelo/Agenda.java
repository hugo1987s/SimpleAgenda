package modelo;

import java.util.List;

import dto.PersonaDTO;
import dto.TipoContactoDTO;
import persistencia.dao.interfaz.DAOAbstractFactory;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;


public class Agenda 
{
	private PersonaDAO persona;	
	private TipoContactoDAO tipoContacto;
	
	public Agenda(DAOAbstractFactory metodo_persistencia)
	{
		this.persona = metodo_persistencia.createPersonaDAO();
		this.tipoContacto = metodo_persistencia.createTipoContactoDAO();
	}
	
	//Persona
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		this.persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		this.persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return this.persona.readAll();		
	}
	
	//TipoContacto
		public void agregarTipoContacto(TipoContactoDTO nuevoTipoContacto)
	{
		this.tipoContacto.insert(nuevoTipoContacto);
	}

	public void borrarTipoContacto(TipoContactoDTO tipoContacto_a_eliminar) 
	{
		this.tipoContacto.delete(tipoContacto_a_eliminar);
	}
	
	public List<TipoContactoDTO> obtenerTipoContacto()
	{
		return this.tipoContacto.readAll();		
	}
	
	
	//Localidad
}
