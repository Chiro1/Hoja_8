import java.util.Comparator;


/**
 * @author Christopher Chiroy, 14411; Diego Sosa, sos14735 
 *
 */

public class Paciente implements Comparator<Paciente>{
	private String nombre;
	private String descripcion;
	private String codigo;
	
	/**
	 * post: constructor de un nuevo paciente 
	 */
	public Paciente(String nombre, String descripcion, String codigo){
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}

	/**
	 * post: constructor sin parametros para usar comparacion 
	 */
	public Paciente() {}
	
	/**
	 * @return descripcion del paciente
	 */
	public String toString(){
		return nombre+", "+descripcion+", "+codigo;
	}

	@Override
	// Compara prioridad de los pacientes segun el codigo
	public int compare(Paciente paciente1, Paciente paciente2) {
		// TODO Auto-generated method stub
		int p1 = (int)paciente1.codigo.charAt(0);
		int p2 = (int)paciente2.codigo.charAt(0);
		
		if(p1<p2) return -1;
		if(p1>p2) return 1;
		return 0;
	}
}
