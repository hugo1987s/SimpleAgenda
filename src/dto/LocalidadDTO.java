package dto;

public class LocalidadDTO
{
	private int codigoPostal;
	private String nombre;

	public LocalidadDTO(int codigoPostal, String nombre)
	{
		this.codigoPostal = codigoPostal;
		this.nombre = nombre;
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
		return this.nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	@Override
	public String toString()
	{
		return this.nombre;
	}
}