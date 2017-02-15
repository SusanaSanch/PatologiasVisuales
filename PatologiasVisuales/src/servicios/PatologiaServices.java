package servicios;

import dao.PatologiaDAO;
import dto.PatologiaDTO;

public class PatologiaServices {

	
	public PatologiaDTO buscarPatologiaPorId(int id) throws Throwable
	{
		PatologiaDAO pato_dao = null;
		pato_dao = new PatologiaDAO();
		PatologiaDTO pato_dto = null;
		pato_dto = pato_dao.buscarPorId(id);
		
		return pato_dto;
	}
	
}
