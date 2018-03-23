package persistencia.dao.interfaz;

import java.util.List;

import dto.ContactoDTO;
import dto.LocalidadDTO;

public interface LocalidadDAO
{

	public boolean insert(LocalidadDTO localidad);

	public boolean delete(LocalidadDTO localidad_a_eliminar);

	public boolean edit(LocalidadDTO localidad_a_editar);
	
	public List<LocalidadDTO> readAll();
}