package persistencia.dao.interfaz;

import java.util.List;
import dto.ContactoDTO;

public interface TipoContactoDAO {

	public boolean insert(ContactoDTO tipoContacto);

	public boolean delete(ContactoDTO tipoContacto_a_eliminar);
	
	public boolean edit(ContactoDTO tipoContacto_a_editar);
	
	public List<ContactoDTO> readAll();
}
