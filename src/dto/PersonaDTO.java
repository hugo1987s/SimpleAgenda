package dto;

import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private String calle;
	private int altura;
	private int piso;
	private String departamento;
	private int codigoPostal;
	private String email;
	private Date fechaNacimiento;
	private int idTipoContacto;
	
	public PersonaDTO(int IdPersona, String Nombre, String Telefono)
	{
		this.idPersona = IdPersona;
		this.nombre = Nombre;
		this.telefono = Telefono;
	}
	
	
	public PersonaDTO(int IdPersona, String Nombre, String Telefono, String Calle, int Altura, int Piso, String Departamento, 
			int CodigoPostal, String Email, Date FechaNacimiento, int IdTipoContacto)
	{
		this.idPersona = IdPersona;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.calle = Calle;
		this.altura = Altura;
		this.piso = Piso;
		this.departamento = Departamento;
		this.codigoPostal = CodigoPostal;
		this.email = Email;
		this.fechaNacimiento = FechaNacimiento;
		this.idTipoContacto = IdTipoContacto;
	}
	
	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}

	public int getIdTipoContacto()
	{
		return idTipoContacto;
	}

	public void setIdTipoContacto(int _idTipoContacto)
	{
		idTipoContacto = _idTipoContacto;
	}

	public Date getFechaNacimiento()
	{
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date _fechaNacimiento)
	{
		fechaNacimiento = _fechaNacimiento;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String _email)
	{
		email = _email;
	}

	public int getCodigoPostal()
	{
		return codigoPostal;
	}

	public void setCodigoPostal(int _codigoPostal)
	{
		codigoPostal = _codigoPostal;
	}

	public String getDepartamento()
	{
		return departamento;
	}

	public void setDepartamento(String _departamento)
	{
		departamento = _departamento;
	}

	public int getPiso()
	{
		return piso;
	}

	public void setPiso(int _piso)
	{
		piso = _piso;
	}

	public int getAltura()
	{
		return altura;
	}

	public void setAltura(int _altura)
	{
		altura = _altura;
	}

	public String getCalle()
	{
		return calle;
	}

	public void setCalle(String _calle)
	{
		calle = _calle;
	}
	
	
}
