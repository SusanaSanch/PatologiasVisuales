package controlador;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import conexiones.ConexionSsh;

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
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
