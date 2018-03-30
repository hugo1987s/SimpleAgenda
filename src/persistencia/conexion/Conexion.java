package persistencia.conexion;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion
{
	public static Conexion instancia;
	private Connection connection;

	private Conexion()
	{
		try
		{
			Properties propiedadesConexion = new Properties();
			FileInputStream archivoConfiguracion = new FileInputStream(
					"src/configuracion/db.conf");
			propiedadesConexion.load(archivoConfiguracion);
			archivoConfiguracion.close();

			String driver = propiedadesConexion.getProperty("jdbc.driver");
			if (driver != null)
			{
				Class.forName(driver);
			}

			String url = propiedadesConexion.getProperty("jdbc.url");
			String username = propiedadesConexion.getProperty("jdbc.username");
			String password = propiedadesConexion.getProperty("jdbc.password");

			this.connection = DriverManager.getConnection(url, username,
					password);
			System.out.println("Conexion exitosa");
		} catch (Exception e)
		{
			System.out.println("Conexion fallida");
		}
	}

	public static Conexion getConexion()
	{
		if (instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion()
	{
		return this.connection;
	}

	public void cerrarConexion()
	{
		try
		{
			this.connection.close();
			System.out.println("Conexion cerrada");
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		instancia = null;
	}
}
