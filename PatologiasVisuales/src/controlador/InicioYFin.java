package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import conexiones.ConexionSsh;
import dao.PatologiaDAO;
import dto.MapaPatologias;
import dto.PatologiasDTO;

/**
 * Application Lifecycle Listener implementation class InicioYFin
 *
 */
@WebListener
public class InicioYFin implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InicioYFin() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	ConexionSsh.desconectate_D_SSH();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	try {
			ConexionSsh.conectate_A_SSH();
			HashMap<Integer, PatologiasDTO> mapa_pato = new HashMap<Integer, PatologiasDTO>();
			PatologiaDAO pdao = new PatologiaDAO();
			List<PatologiasDTO> lista_patos = new ArrayList<PatologiasDTO>();
			
			lista_patos = pdao.getListaIdPatologias();
			System.out.println(lista_patos.get(1).getNombre() + " Listener");
			for (PatologiasDTO patologiaDTO : lista_patos) 
				{
					mapa_pato.put(patologiaDTO.getId(), patologiaDTO);
				}
			
			MapaPatologias.setMapapatologia(mapa_pato);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
