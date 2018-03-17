package persistencia.dao.interfaz;

import java.util.List;

import dto.LocalidadDTO;

public interface LocalidadDAO 
{
	
	public boolean insert(LocalidadDTO persona);

	public boolean delete(LocalidadDTO persona_a_eliminar);
	
	public List<LocalidadDTO> readAll();
}
