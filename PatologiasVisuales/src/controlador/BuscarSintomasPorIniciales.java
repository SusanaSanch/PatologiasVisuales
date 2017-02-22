package controlador;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mysql.fabric.xmlrpc.base.Array;

import dto.SintomaDTO;
import servicios.SintomaServices;

/**
 * Servlet implementation class BuscarSintomasPorIniciales
 */
@WebServlet("/BuscarSintomasPorIniciales")
public class BuscarSintomasPorIniciales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomasPorIniciales() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SintomaServices ss = new SintomaServices();
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		String inicial = null;
		inicial = request.getParameter("intro");
		lista_sintomas = ss.buscarSintomaPorInicial(inicial);
		
		Gson gson = new Gson();
		Type tipoListaSintoma = new TypeToken<List<SintomaDTO>>(){}.getType();
		String sintomas = gson.toJson(lista_sintomas,tipoListaSintoma);
		
		response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sintomas);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
