package servicios;

import org.apache.log4j.Logger;

import dao.PatologiaDAO;
import dto.MapaPatologias;
import dto.PatologiaDTO;

public class PatologiaServices {

	private final static Logger log = Logger.getLogger("mylog");
	
	public PatologiaDTO buscarPatologiaPorId(int id) throws Throwable
	{
//		PatologiaDAO pato_dao = null;
//		pato_dao = new PatologiaDAO();
		PatologiaDTO pato_dto = null;
//		pato_dto = pato_dao.buscarPorId(id);
		
		pato_dto = MapaPatologias.getMapa_patologias().get(id);
		System.out.println(pato_dto.getNombre() + " - PatologiaServices");
		
		log.info(pato_dto.getNombre() + " - PatologiaServices");
		
		return pato_dto;
	}
	
	
}
