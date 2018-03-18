package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import dto.ContactoDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDAOSQL implements TipoContactoDAO {

	private static final String insert = "INSERT INTO tipoContacto(idTipoContacto, Tipo) VALUES(?, ?)";
	private static final String delete = "DELETE FROM tipoContacto WHERE idTipoContacto = ?";
	private static final String readall = "SELECT idTipoContacto, Tipo FROM tipoContacto";
	private static final String update = "UPDATE tipoContacto SET Tipo = ? WHERE idTipoContacto = ?";
	
	@Override
	public boolean insert(ContactoDTO tipoContacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipoContacto.getIdTipoContacto());
			statement.setString(2, tipoContacto.getTipo());
			
			if(statement.executeUpdate() > 0) //Si se ejecutÛ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean edit(ContactoDTO tipoContacto) {
		PreparedStatement statement;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, tipoContacto.getTipo());
			statement.setInt(2, tipoContacto.getIdTipoContacto());
			
			
			if(statement.executeUpdate() > 0) //Si se ejecutÛ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(ContactoDTO tipoContacto_a_eliminar) {
		PreparedStatement statement;
		int chequeoUpdate = 0;
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(tipoContacto_a_eliminar.getIdTipoContacto()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecut√≥ devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<ContactoDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ContactoDTO> personas = new ArrayList<ContactoDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				personas.add(new ContactoDTO(resultSet.getInt("idTipoContacto"), resultSet.getString("Tipo")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return personas;
	}
	

}
