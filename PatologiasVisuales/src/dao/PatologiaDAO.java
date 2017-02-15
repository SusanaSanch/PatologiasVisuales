package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import conexiones.Pool;
import dto.PatologiaDTO;
import dto.SintomaDTO;

public class PatologiaDAO {
	
		
	public PatologiaDTO buscarPorId(int id) throws Throwable
	{
		Connection conn = null;
		Statement stmt = null;
		
		PatologiaDTO patologia = null;
		
		Pool pool = null;
		pool = Pool.getInstance();
		conn = pool.getConnection();
		
		try
			{
				
	  	        stmt = conn.createStatement();
	  	        
				ResultSet rset = null;
				
				
				rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
				while (rset.next())
					{
						patologia = new PatologiaDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5), SintomaDAO.buscarSintomasPatologiaID(id, conn));
					}
			
			}
			
			catch(Exception e)
				{
					e.printStackTrace();
				}
			finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
				{
					if (stmt != null)	{ try {	stmt.close(); } catch (Exception e2) { e2.printStackTrace(); }}
					if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
				}   
	
			return patologia;
		
	}
	
	
}
