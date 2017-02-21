package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexiones.Pool;
import dto.PatologiaDTO;
import dto.SintomaDTO;

public class SintomaDAO {
	
	public static List<SintomaDTO> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		SintomaDTO sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (rset2.next())
	    {
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new SintomaDTO(id_sintoma, descripcion_sintoma);
			lista_sintomas.add(sintoma);
		}
		
		if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		return lista_sintomas;
	}

	public static List<SintomaDTO> buscarPorInicial(String inicial)
	{
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		List<SintomaDTO> lista_sintomas = new ArrayList<SintomaDTO>();
		SintomaDTO sintoma = null;
		
		Pool pool = null;
		pool = Pool.getInstance();
		conn = pool.getConnection();
		
		try
			{
	  	        stmt = conn.createStatement();			
				rset = stmt.executeQuery(Consultas.CONSULTA_SINTOMAS_POR_INICIAL + inicial + "%'");
				while (rset.next())
					{
						sintoma = new SintomaDTO(rset.getInt(1), rset.getString(2));
						lista_sintomas.add(sintoma); 
						System.out.println(sintoma.getDescripcion());
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
	
			return lista_sintomas;
	
	}

	
	
}
