package dto;

public class SintomasDTO {

	private int id;
	private String descripcion;
	
	private String pregunta_web;
	
	private int prioridad_sint;
	public SintomasDTO(){
		
	}
	
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return this.id == ((SintomasDTO) obj).id;
	}


	public String getPregunta_web() {
		return pregunta_web;
	}





	public void setPregunta_web(String pregunta_web) {
		this.pregunta_web = pregunta_web;
	}





	public int getPrioridad_sint() {
		return prioridad_sint;
	}





	public void setPrioridad_sint(int prioridad_sint) {
		this.prioridad_sint = prioridad_sint;
	}





	public SintomasDTO(int id, String descripcion, String pregunta_web, int prioridad_sint) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.pregunta_web = pregunta_web;
		this.prioridad_sint = prioridad_sint;
	}





	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.descripcion;
	}
	


}
