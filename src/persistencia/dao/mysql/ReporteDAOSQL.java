package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import dto.PersonaDTO;
import dto.ReporteDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.ReporteDAO;

public class ReporteDAOSQL implements ReporteDAO
{
	private static final String readall = "Select p.Nombre, p.Apellido, p.Telefono, FechaNacimiento, tp.Tipo as TipoContacto, loc.Nombre as NombreLocalidad from personas p inner join localidades loc on p.CodigoPostal = loc.CodigoPostal inner join tipoContacto tp on p.IdTipoContacto = tp.IdTipoContacto"; // order by FechaNacimiento asc, Apellido asc";


	@Override
	public List<ReporteDTO> readAll()
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<ReporteDTO> reporte = new ArrayList<ReporteDTO>();
		Conexion conexion = Conexion.getConexion();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				reporte.add(new ReporteDTO(
						resultSet.getString("Nombre"), 
						resultSet.getString("Apellido"),
						resultSet.getDate("FechaNacimiento"),
						resultSet.getString("NombreLocalidad"),
						resultSet.getString("TipoContacto"),
						resultSet.getString("Telefono")
						
				));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return reporte;
	}

}
