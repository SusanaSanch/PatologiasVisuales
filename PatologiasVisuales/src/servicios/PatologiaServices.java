package servicios;

import org.apache.log4j.Logger;

import dao.PatologiaDAO;
import dto.MapaPatologias;
import dto.PatologiasDTO;

public class PatologiaServices {

	private final static Logger log = Logger.getLogger("mylog");
	
	public PatologiasDTO buscarPatologiaPorId(int id) throws Throwable
	{
//		PatologiaDAO pato_dao = null;
//		pato_dao = new PatologiaDAO();
		PatologiasDTO pato_dto = null;
//		pato_dto = pato_dao.buscarPorId(id);
		
		pato_dto = MapaPatologias.getMapapatologia().get(id);
		System.out.println(pato_dto.getNombre() + " - PatologiaServices");
		
		log.info(pato_dto.getNombre() + " - PatologiaServices");
		
		return pato_dto;
	}
	
	
}
