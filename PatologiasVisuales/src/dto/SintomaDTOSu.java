package dto;

public class SintomaDTOSu {
	
	private int id;
	private String descripcion;
	
	
	public SintomaDTOSu(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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
		return ("id : " + this.id + ". Descripción : " + this.descripcion);
	}

}
