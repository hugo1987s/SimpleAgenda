package dto;

import java.util.Date;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String apellido;
	private String telefono;
	private String calle;
	private int altura;
	private int piso;
	private String departamento;
	//private int codigoPostal;
	private String email;
	private Date fechaNacimiento;
	//private int idTipoContacto;
	private LocalidadDTO localidad;
	private ContactoDTO contacto;
	
	public PersonaDTO(int IdPersona, String Nombre, String Telefono, String Apellido)
	{
		this.idPersona = IdPersona;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.localidad = new LocalidadDTO(0, "");
		this.contacto = new ContactoDTO(0, "");
		this.apellido = Apellido;
	}
	
	
	public PersonaDTO(int IdPersona, String Nombre, String Telefono, String Calle, int Altura, int Piso, String Departamento, 
			int CodigoPostal, String Email, Date FechaNacimiento, int IdTipoContacto, String Contacto, String Localidad, String Apellido)
	{
		this.idPersona = IdPersona;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.calle = Calle;
		this.altura = Altura;
		this.piso = Piso;
		this.departamento = Departamento;
		//this.codigoPostal = CodigoPostal;
		this.email = Email;
		this.fechaNacimiento = FechaNacimiento;
		//this.idTipoContacto = IdTipoContacto;
		this.localidad = new LocalidadDTO(CodigoPostal, Localidad);
		this.contacto = new ContactoDTO(IdTipoContacto, Contacto);
		this.apellido = Apellido;
	}
	
	public PersonaDTO(int IdPersona, String Nombre, String Telefono, String Calle, int Altura, int Piso, String Departamento, 
			String Email, Date FechaNacimiento, ContactoDTO Contacto, LocalidadDTO Localidad, String Apellido)
	{
		this.idPersona = IdPersona;
		this.nombre = Nombre;
		this.telefono = Telefono;
		this.calle = Calle;
		this.altura = Altura;
		this.piso = Piso;
		this.departamento = Departamento;
		this.email = Email;
		this.fechaNacimiento = FechaNacimiento;
		this.localidad = new LocalidadDTO(Localidad.getCodigoPostal(), Localidad.getNombre());
		this.contacto = new ContactoDTO(Contacto.getIdTipoContacto(), Contacto.getTipo());
		this.apellido = Apellido;
	}
	
	public PersonaDTO(PersonaDTO persona)
	{
		this.idPersona = persona.getIdPersona();
		this.nombre = persona.getNombre();
		this.telefono = persona.getTelefono();
		this.calle = persona.getCalle();
		this.altura = persona.getAltura();
		this.piso = persona.getPiso();
		this.departamento = persona.getDepartamento();
		this.email = persona.getEmail();
		this.fechaNacimiento = persona.getFechaNacimiento();
		this.localidad = new LocalidadDTO(persona.getLocalidad().getCodigoPostal(), persona.getLocalidad().getNombre());
		this.contacto = new ContactoDTO(persona.getContacto().getIdTipoContacto(), persona.getContacto().getTipo());
		this.apellido = persona.apellido;
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


	public LocalidadDTO getLocalidad()
	{
		return localidad;
	}


	public void setLocalidad(LocalidadDTO localidad)
	{
		this.localidad = localidad;
	}


	public ContactoDTO getContacto()
	{
		return contacto;
	}


	public void setContacto(ContactoDTO contacto)
	{
		this.contacto = contacto;
	}


	public String getApellido()
	{
		return apellido;
	}


	public void setApellido(String apellido)
	{
		this.apellido = apellido;
	}
	
	
}
