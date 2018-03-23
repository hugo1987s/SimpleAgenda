package dto;

public class LocalidadDTO
{
	private int codigoPostal;
	private String nombreLocalidad;

	public LocalidadDTO(int codigoPostal, String nombre)
	{
		this.codigoPostal = codigoPostal;
		this.nombreLocalidad = nombre;
	}

	public int getCodigoPostal()
	{
		return this.codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal)
	{
		this.codigoPostal = codigoPostal;
	}

	public String getNombre()
	{
		return this.nombreLocalidad;
	}

	public void setNombre(String nombre)
	{
		this.nombreLocalidad = nombre;
	}

	@Override
	public String toString()
	{
		return this.nombreLocalidad;
	}
}