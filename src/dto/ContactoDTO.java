package dto;

public class ContactoDTO {
	private int idTipoContacto;
	private String Tipo;
	
	public ContactoDTO(int idTipoContacto, String TipoContacto)
	{
		this.idTipoContacto = idTipoContacto;
		this.Tipo = TipoContacto;
	}
	
	
	public int getIdTipoContacto() 
	{
		return idTipoContacto;
	}
	
	public void setIdTipoContacto(int idTipoContacto) 
	{
		this.idTipoContacto = idTipoContacto;
	}
	
	public String getTipo() 
	{
		return Tipo;
	}
	
	public void setTipo(String tipo) 
	{
		Tipo = tipo;
	}
}
