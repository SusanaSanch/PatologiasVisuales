package dto;

import java.util.List;

public class PatologiaDTO {

	private int id;
	private String nombre;
	private String causa;
	private String tratamiento;
	private String descripcion;
	private List<SintomaDTO> lista_sintomas;
	private String ruta_foto;
	
	
	public PatologiaDTO(int id, String nombre, String causa,
			String tratamiento, String descripcion,
			List<SintomaDTO> lista_sintomas, String ruta_foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.causa = causa;
		this.tratamiento = tratamiento;
		this.descripcion = descripcion;
		this.lista_sintomas = lista_sintomas;
		this.ruta_foto = ruta_foto;
	}


	public String getRuta_foto() {
		return ruta_foto;
	}


	public void setRuta_foto(String ruta_foto) {
		this.ruta_foto = ruta_foto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCausa() {
		return causa;
	}


	public void setCausa(String causa) {
		this.causa = causa;
	}


	public String getTratamiento() {
		return tratamiento;
	}


	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<SintomaDTO> getLista_sintomas() {
		return lista_sintomas;
	}


	public void setLista_sintomas(List<SintomaDTO> lista_sintomas) {
		this.lista_sintomas = lista_sintomas;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + ". " + this.nombre + ".<br>" + "Descripción: " + this.descripcion + "<br>" + "Causa: " + this.causa + "<br>" + "Tratamiento: " + this.tratamiento ;
	}
	
	
}
