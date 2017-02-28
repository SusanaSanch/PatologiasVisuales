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
import dto.PatologiasDTO;
import dto.SintomaDTOSu;

public class PatologiaDAO {
	
		
/*
	public PatologiasDTO buscarPorId(int id) throws Throwable
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		PatologiasDTO patologia = null;
		
		Pool pool = null;
		pool = Pool.getInstance();
		conn = pool.getConnection();
		
		try
			{
	  	        stmt = conn.createStatement();				
				rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIA_ID + id);
				while (rset.next())
					{
						patologia = new PatologiasDTO(rset.getInt(1), rset.getString(2), rset.getString(5), rset.getString(4), rset.getString(3), SintomaDAO.buscarSintomasPatologiaID(id, conn), rset.getString(6));
					}
			
			}
			
			catch(Exception e)
				{
					e.printStackTrace();
				}
			finally //libero recursos, de "adentro a fuera" , ResultSet, Statment, Conexion
				{
					pool.liberarRecursos(conn, stmt, rset);
				}   
	
			return patologia;
		
	}
	*/
	
	
	public List<PatologiasDTO> getListaIdPatologias()
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		PatologiasDTO patologia = null;
		
		Pool pool = null;
		pool = Pool.getInstance();
		conn = pool.getConnection();
		int id_patol = 0;
		List<PatologiasDTO> lista_patologias = new ArrayList<PatologiasDTO>();
		
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(Consultas.CONSULTA_PATOLOGIAS);
			
				while (rset.next())
				{
					patologia = new PatologiasDTO(rset.getInt(1), rset.getString(2), rset.getString(5), rset.getString(4), rset.getString(3), SintomaDAO.buscarSintomasPatologiaID(rset.getInt(1), conn),rset.getString(6) );
					lista_patologias.add(patologia);
				}
				
			} 
		
			catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally
					{
						pool.liberarRecursos(conn, stmt, rset);
					}
			
		return lista_patologias;
		
	}
	
	
	
}
