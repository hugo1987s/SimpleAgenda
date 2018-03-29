package dto;

import java.util.Calendar;
import java.util.Date;

public class ReporteDTO
{
	private String _nombre;
	private String _apellido;
	private Date _fechaNacimiento;
	private String _nombreLocalidad;
	private String _tipoContacto;
	private String _telefono;
	private long anio;
	
	public ReporteDTO(String nombre, String apellido, Date fechaNacimiento, String localidad, String tipoContacto, String telefono)
	{
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setFechaNacimiento(fechaNacimiento);
		this.setNombreLocalidad(localidad);
		this.setTipoContacto(tipoContacto);
		this.setTelefono(telefono);
		this.setAnio(fechaNacimiento);
	}

	public void setAnio(Date fechaNacimiento)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaNacimiento);
		this.anio = cal.get(Calendar.YEAR);
		
		
	}

	public String getNombre()
	{
		return _nombre;
	}

	public void setNombre(String _nombre)
	{
		this._nombre = _nombre;
	}

	public String getApellido()
	{
		return _apellido;
	}

	public void setApellido(String _apellido)
	{
		this._apellido = _apellido;
	}

	public Date getFechaNacimiento()
	{
		return _fechaNacimiento;
	}

	public void setFechaNacimiento(Date _fechaNacimiento)
	{
		this._fechaNacimiento = _fechaNacimiento;
	}

	public String getNombreLocalidad()
	{
		return _nombreLocalidad;
	}

	public void setNombreLocalidad(String _localidad)
	{
		this._nombreLocalidad = _localidad;
	}

	public String getTipoContacto()
	{
		return _tipoContacto;
	}

	public void setTipoContacto(String _tipoContacto)
	{
		this._tipoContacto = _tipoContacto;
	}

	public String getTelefono()
	{
		return _telefono;
	}

	public void setTelefono(String telefono)
	{
		this._telefono = telefono;
	}
	
	public long getAnio()
	{
		return anio;
	}
	
	
}
