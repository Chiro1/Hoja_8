import java.util.Comparator;


public class paciente implements Comparator<paciente>{
	private String nombre;
	private String descripcion;
	private String codigo;
	
	public paciente(String nombre, String descripcion, String codigo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	//Constructor sin parametros para usar la comparacion
	public paciente() {}
	
	public String toString(){
		return nombre+", "+descripcion+", "+codigo;
	}
	
	public void llenarPacientes(){
		
	}

	@Override
	// Compara prioridad de los pacientes segun el codigo
	public int compare(paciente paciente1, paciente paciente2) {
		// TODO Auto-generated method stub
		int p1 = (int)paciente1.codigo.charAt(0);
		int p2 = (int)paciente2.codigo.charAt(0);
		
		if(p1<p2) return -1;
		if(p1>p2) return 1;
		return 0;
	}
}
