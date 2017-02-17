package servicios;

import dao.PatologiaDAO;
import dto.MapaPatologias;
import dto.PatologiaDTO;

public class PatologiaServices {

	
	public PatologiaDTO buscarPatologiaPorId(int id) throws Throwable
	{
//		PatologiaDAO pato_dao = null;
//		pato_dao = new PatologiaDAO();
		PatologiaDTO pato_dto = null;
//		pato_dto = pato_dao.buscarPorId(id);
		
		pato_dto = MapaPatologias.getMapa_patologias().get(id);
		System.out.println(pato_dto.getNombre() + " - PatologiaServices");
		
		return pato_dto;
	}
	
	
}
