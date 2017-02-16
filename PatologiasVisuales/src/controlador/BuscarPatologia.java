package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PatologiaDTO;
import servicios.PatologiaServices;

/**
 * Servlet implementation class BuscarPatologia
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PatologiaServices ps = new PatologiaServices();
		String id = request.getParameter("id");
		int idn = Integer.parseInt(id);
		
		PatologiaDTO pato_dto = null;
				 
		try {
			pato_dto = ps.buscarPatologiaPorId(idn);

		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("patologia", pato_dto);
		
		switch (idn) {
		case 1:	
			request.getRequestDispatcher(".//html//queratocono.jsp").forward(request, response);
			break;
		
		case 2:
					
			break;
		
		case 3:
			
			break;
		
		case 4:
			
			request.getRequestDispatcher(".//html//catarata.jsp").forward(request, response);
			break;
		
		case 5:
			request.getRequestDispatcher(".//html//conjuntivitis.jsp").forward(request, response);
			break;
			
		case 6:
			request.getRequestDispatcher(".//html//deprendimiento.jsp").forward(request, response);
			break;
			
		case 7:
			request.getRequestDispatcher(".//html//acromatopsia.jsp").forward(request, response);
			break;
			
		case 8:
			request.getRequestDispatcher(".//html//estrabismo.jsp").forward(request, response);
			break;
			
		case 9:
			request.getRequestDispatcher(".//html//presbicia.jsp").forward(request, response);
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
