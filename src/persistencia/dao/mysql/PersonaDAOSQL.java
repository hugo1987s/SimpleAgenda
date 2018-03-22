package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaDAO;
import dto.PersonaDTO;

public class PersonaDAOSQL implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, Nombre, Telefono, Calle, Altura, Piso, Departamento, "
			+ "CodigoPostal, Email, FechaNacimiento, IdTipoContacto, Apellido) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "Select p.IdPersona, p.Nombre, p.Apellido, Telefono, Calle, Altura, Piso, Departamento, p.CodigoPostal, Email, FechaNacimiento, p.IdTipoContacto, tp.Tipo, loc.Nombre as NombreLocalidad from personas p inner join localidades loc on p.CodigoPostal = loc.CodigoPostal inner join tipoContacto tp on p.IdTipoContacto = tp.IdTipoContacto order by FechaNacimiento asc, Apellido asc";
	private static final String update = "UPDATE personas "
			+ " SET Nombre = ?, "
			+ " Telefono = ?, Calle = ?, Altura = ?, Piso = ?, Departamento = ?, "
			+ " CodigoPostal = ?, Email = ?, FechaNacimiento = ?, IdTipoContacto = ?, "
			+ " Apellido = ? "
			+ " where idPersona = ?";


	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setString(4, persona.getCalle());
			statement.setInt(5, persona.getAltura());
			statement.setInt(6, persona.getPiso());
			statement.setString(7, persona.getDepartamento());
			statement.setInt(8, persona.getLocalidad().getCodigoPostal());
			statement.setString(9, persona.getEmail());
			statement.setDate(10, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			statement.setInt(11, persona.getContacto().getIdTipoContacto());
			statement.setString(12, persona.getApellido());
			
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutÃ³ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public List<PersonaDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				//personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono")));
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), 
						resultSet.getString("Nombre"), 
						resultSet.getString("Telefono"),
						resultSet.getString("Calle"),
						resultSet.getInt("Altura"),
						resultSet.getInt("Piso"),
						resultSet.getString("Departamento"),
						resultSet.getInt("CodigoPostal"),
						resultSet.getString("Email"),
						resultSet.getDate("FechaNacimiento"),
						resultSet.getInt("IdTipoContacto"),
						resultSet.getString("Tipo"),
						resultSet.getString("NombreLocalidad"),
						resultSet.getString("Apellido")
						
				));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	
	@Override
	public boolean edit(PersonaDTO persona)
	{
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getTelefono());
			statement.setString(3, persona.getCalle());
			statement.setInt(4, persona.getAltura());
			statement.setInt(5, persona.getPiso());
			statement.setString(6, persona.getDepartamento());
			statement.setInt(7, persona.getLocalidad().getCodigoPostal());
			statement.setString(8, persona.getEmail());
			statement.setDate(9, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			statement.setInt(10, persona.getContacto().getIdTipoContacto());
			statement.setString(11, persona.getApellido());
			statement.setInt(12, persona.getIdPersona());
			
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
}
