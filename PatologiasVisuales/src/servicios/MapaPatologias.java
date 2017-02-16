package servicios;

import java.util.HashMap;
import java.util.Map;

import dto.PatologiaDTO;

public class MapaPatologias {
	
	
	public static Map<Integer, PatologiaDTO> mapa_patologias;

	public static Map<Integer, PatologiaDTO> getMapa_patologias() {
		return mapa_patologias;
	}

	public static void setMapa_patologias(Map<Integer, PatologiaDTO> mapa_patologias) {
		MapaPatologias.mapa_patologias = mapa_patologias;
	}
	

	public MapaPatologias()
	{
		super();
		mapa_patologias = new HashMap<Integer, PatologiaDTO>();
	}
	

}
