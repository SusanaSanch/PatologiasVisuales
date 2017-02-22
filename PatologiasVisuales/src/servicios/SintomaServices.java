package servicios;

import java.util.ArrayList;
import java.util.List;

import dao.SintomaDAO;
import dto.SintomaDTO;

public class SintomaServices {
	
	public List<SintomaDTO> buscarSintomaPorInicial(String inicial)
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		SintomaDAO sdao = new SintomaDAO();
		lista_sintomas = sdao.buscarPorInicial(inicial);
		
//		for (SintomaDTO sin : lista_sintomas) {
//			System.out.println(sin.getDescripcion()); //Para comprobar
//		}
		
		return lista_sintomas;
	}

}
