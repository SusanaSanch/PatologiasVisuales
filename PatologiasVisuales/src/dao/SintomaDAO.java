package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexiones.Pool;
import dto.SintomaDTOSu;
import dto.SintomasDTO;

public class SintomaDAO {
	
	
	public static List<SintomasDTO> buscarSintomasPatologiaID (int id, Connection conn) throws SQLException
	{
		List<SintomasDTO> lista_sintomas = new ArrayList<SintomasDTO>();
		
		String descripcion_sintoma = null;
		int id_sintoma = 0;
		SintomasDTO sintoma = null;
		ResultSet rset2 = null;
		Statement stmt2 = null;
		stmt2 = conn.createStatement();
		rset2 = stmt2.executeQuery(Consultas.CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID +id+")");
		while (rset2.next())
	    {
			id_sintoma = rset2.getInt(1);
			descripcion_sintoma = rset2.getString(2);
			sintoma = new SintomasDTO(id_sintoma, descripcion_sintoma, rset2.getString(3), rset2.getInt(4) );
			lista_sintomas.add(sintoma);
		}
		
		if (rset2 != null) 	{ try { rset2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		if (stmt2 != null)	{ try {	stmt2.close(); } catch (Exception e2) { e2.printStackTrace(); }}
		return lista_sintomas;
	}
	public static ArrayList<SintomasDTO> allSint() throws SQLException{
		ArrayList<SintomasDTO> lista = new ArrayList<SintomasDTO>();
		SintomasDTO sint = new SintomasDTO();
		
		ResultSet rset = null;
		
		Pool.getInstance();
		Connection conn=null;
		conn=Pool.getConnection();
		
		
		Statement stmt=null;
		stmt=conn.createStatement();
		
		rset = stmt.executeQuery("select * from Sintomas");
		while (rset.next())
		{
			sint.setDescripcion(rset.getString(1));
			lista.add(sint);
		}
		Pool.liberarRecursos(conn, stmt, rset);
		
		
		return lista;
		
	}
	public static ArrayList<SintomasDTO> sint4char(String caracter) throws SQLException{
		ArrayList<SintomasDTO> lista = new ArrayList<SintomasDTO>();
		SintomasDTO sint = null;
		
		ResultSet rset = null;
		
		Pool.getInstance();
		Connection conn=null;
		conn=Pool.getConnection();
		
		
		Statement stmt=null;
		stmt=conn.createStatement();
		rset = stmt.executeQuery("select * from Sintomas where des_sint like '"+caracter+"%'");
		while (rset.next())
		{	
			//sint = new Sintoma(rset.getInt(1), rset.getString(2));
			
			lista.add(sint);
			
		}
		Pool.liberarRecursos(conn, stmt, rset);
		
		
		return lista;
	
	
}
	public static ArrayList<SintomasDTO> getSintomasOrdenados() {
	
	ArrayList<SintomasDTO> lista = new ArrayList<SintomasDTO>();
	SintomasDTO sint = null;
	
	ResultSet rset = null;
	Pool.getInstance();
	Connection conn=null;
	conn=Pool.getConnection();
	Statement stmt=null;
	
	try
	{
		
	stmt=conn.createStatement();
	rset = stmt.executeQuery("select * from Sintomas ORDER BY prioridad_sint");
	
	while (rset.next())
	{
		
		sint = new SintomasDTO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getInt(4));
		lista.add(sint);
	}
	
	}catch(SQLException e)
	{
			e.printStackTrace();
	}
	finally
	{
		Pool.liberarRecursos(conn, stmt, rset);
	}
	
	return lista;
	
	
	}
}
