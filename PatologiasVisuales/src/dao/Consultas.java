package dao;

public class Consultas {
	
	public static final String CONSULTA_PATOLOGIA_ID = "SELECT * FROM Patologias WHERE id_patol = ";
	public static final String CONSULTA_LISTA_SINTOMA_POR_PATOLOGIA_ID = "SELECT * FROM Sintomas WHERE id_sint IN (SELECT id_sint FROM PatolSint WHERE id_patol = ";
	public static final String CONSULTA_PATOLOGIAS = "SELECT * FROM Patologias";
	public static final String CONSULTA_SINTOMAS_POR_INICIAL = "SELECT * FROM Sintomas WHERE des_sint LIKE '";

}
