package servicios;

import java.util.ArrayList;
import java.util.List;

import dao.SintomaDAO;
import dao.SintomaDAOSu;
import dto.SintomasDTO;
import dto.SintomaDTOSu;

public class SintomaServices {
	
	public List<SintomaDTOSu> buscarSintomaPorInicial(String inicial)
	{
		List<SintomaDTOSu> lista_sintomas = new ArrayList<SintomaDTOSu>();
		SintomaDAOSu sdao = new SintomaDAOSu();
		lista_sintomas = sdao.buscarPorInicial(inicial);
		
//		for (SintomaDTO sin : lista_sintomas) {
//			System.out.println(sin.getDescripcion()); //Para comprobar
//		}
		
		return lista_sintomas;
	}

	public List<SintomasDTO> listarSintomasOrdenados()
	{	
		List<SintomasDTO> lista_sintomas = null;
		
			lista_sintomas = SintomaDAO.getSintomasOrdenados(); 
		
		return lista_sintomas;
	}
	
}
