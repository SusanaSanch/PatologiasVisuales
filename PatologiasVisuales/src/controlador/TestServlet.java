package controlador;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MapaPatologias;
import dto.MapaPatologiasCandidatas;
import dto.PatologiasDTO;
import dto.SintomasDTO;
import dto.SintomaDTOSu;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private void mostrar (Map<Integer, PatologiasDTO> mapa)
    {
    	Iterator<Integer> it = mapa.keySet().iterator();
    	PatologiasDTO paux = null;
    	while (it.hasNext())
    	{
    		paux = mapa.get(it.next());
    		System.out.println(paux.toString());
    	}
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String respuesta = request.getParameter("resp");
		HttpSession session = request.getSession(false);
		List<SintomasDTO> lista_sdto = (List<SintomasDTO>) session.getAttribute("lista_sint");
		MapaPatologiasCandidatas mapa_patolog_candidatas = (MapaPatologiasCandidatas) session.getAttribute("mapa_patologias");
		int num_sintoma_actual = (int) session.getAttribute("num_sintoma_actual");
		
		Map<Integer, PatologiasDTO> mapa_patolog_resultado = null;
		
		
		if(respuesta.equals("SI"))
		{
			mapa_patolog_resultado = mapa_patolog_candidatas.filtrarPatologiasCandidatas(mapa_patolog_candidatas.getMapa_patologias_candidatas(), lista_sdto.get(num_sintoma_actual));
			mostrar(mapa_patolog_resultado);
		}
		else //dijo que no
		{
			Map<Integer, PatologiasDTO> mapa_patolog_filtradas = mapa_patolog_candidatas.filtrarPatologiasCandidatas(mapa_patolog_candidatas.getMapa_patologias_candidatas(), lista_sdto.get(num_sintoma_actual));
			mostrar(mapa_patolog_filtradas);
			mapa_patolog_resultado = MapaPatologias.diferencia(MapaPatologias.getMapapatologia(), mapa_patolog_filtradas);
			mostrar(mapa_patolog_resultado);
		}
		
		int npatols = mapa_patolog_resultado.size();
		
		System.out.println(mapa_patolog_resultado.size());
		
		switch (npatols) {
		case 0: 
			//cerrar sesión --> session.invalidate();
			session.invalidate();
			//MENSAJE ERROR--> NO SABEMOS QUÉ TE PASA
			request.setAttribute("pregunta", "PREGUNTE A SU MÉDICO");
			request.getRequestDispatcher(".//html//test.jsp").forward(request, response);	
			break;

			
		case 1:
			
			Iterator<Integer> it = mapa_patolog_resultado.keySet().iterator();
			PatologiasDTO patologia_ganadora = mapa_patolog_resultado.get (it.next()); 
			
			request.setAttribute("pregunta", patologia_ganadora); //lista_sdto.get(num_sintoma_actual).getPregunta_web());
			session.invalidate();
			request.getRequestDispatcher(".//html//resultadotest.jsp").forward(request, response);	
			//cerrar sesión --> session.invalidate();
			//MENSAJE ÉXITO --> PATOLOGÍA ENCONTRADA
			
			break;
			
		default: //CASO POR DEFECTO --> + DE 1 PATOLOGÍA CANDIDATA
			
			// OBTENTE SIGUENTE SÍNTOMA /PREGUNTA
			// Y VER SI ESE SÍNTOMA ESTÁ PRESENTE EN ALGUNA DE LAS PATOLOGÍAS RESULTADO
			// SÍ SÍ, PREGUNTO CON ESA
			// SÍ NO, PASO AL SIGUIENTE SÍNTOMA
			
			boolean sintoma_seleccionado = false;
			int nsintomas = lista_sdto.size();
			
			do{
				
				num_sintoma_actual = num_sintoma_actual + 1;
				SintomasDTO sintomaactual = lista_sdto.get(num_sintoma_actual);
				boolean sintoma_presente = false;
				PatologiasDTO paux = null;
				Iterator<Integer> itm = mapa_patolog_resultado.keySet().iterator();
				
				while (!sintoma_presente && itm.hasNext())
				{
					paux = mapa_patolog_resultado.get(itm.next());
					sintoma_presente = mapa_patolog_candidatas.sintomaEnPatologia(sintomaactual, paux);
				}
				
				if (sintoma_presente)
				{
					sintoma_seleccionado = true;
				} else
				{
					num_sintoma_actual = num_sintoma_actual + 1;
				}
				
			} while (!sintoma_seleccionado && num_sintoma_actual < nsintomas);
			
			if (!sintoma_seleccionado) //ninguno de los síntomas, está presente en la lista de patologías candidatas
			{
				//case 0: //MENSAJE ERROR--> NO SABEMOS QUÉ TE PASA
				
				session.invalidate();
				//MENSAJE ERROR--> NO SABEMOS QUÉ TE PASA
				request.setAttribute("pregunta", "PREGUNTE A SU MÉDICO");
				request.getRequestDispatcher(".//html//test.jsp").forward(request, response);	
			} else
			{
				
				MapaPatologiasCandidatas mapa_nuevo = new MapaPatologiasCandidatas (mapa_patolog_resultado);
				session.setAttribute("mapa_patologias", mapa_nuevo);//actualiza mapa en sesión
				session.setAttribute("num_sintoma_actual", num_sintoma_actual);//actualiza número de síntoma en sesión
				//la lista de síntomas no se actualiza porque siempre es la misma.
				
				request.setAttribute("pregunta", lista_sdto.get(num_sintoma_actual).getPregunta_web());
				request.getRequestDispatcher(".//html//test.jsp").forward(request, response);	
				//Y REDIRIGIR AL JSP CON LA PREGUNTA/SINTOMA SELECCIONADA
			}
			
			break;
		}
		

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
