import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Emergencias {
	Comparator<Paciente> comparador;
	PriorityQueue<Paciente> listaPaciente;
	
	/**
	 * @param archivo
	 * pre: Recibe archivo con los pacientes
	 * post: Orden de los pacientes por emergencia
	 */
	public Emergencias(String archivo){
		comparador = new Paciente();
		 try {
			listaPaciente = new PriorityQueue<Paciente>(size(archivo), comparador);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			generarPacientes(archivo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Orden de emergencia de pacientes: ");
		while(true){
			Paciente actualPaciente = listaPaciente.poll();
			if(actualPaciente == null) break;
			System.out.println(actualPaciente.toString());
		}
	}
	
	/**
	 * @param archivo
	 * @return tamano de la cola
	 * @throws Exception
	 */
	public int size(String archivo) throws Exception{
		int l = 0;
		String linea;
		try (BufferedReader dr = new BufferedReader(new FileReader(archivo))) {
			while ((linea = dr.readLine()) != null) {
		       l++;
		    }
		    dr.close();
		}
		return l;
	}
	
	/**
	 * @param archivo
	 * @throws Exception
	 * post: agrega pacientes a la cola
	 */
	public void generarPacientes(String archivo) throws Exception{
		String[] info = new String[3];
		String linea;
		try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
		    while ((linea = br.readLine()) != null) {
		       info = linea.split(",");
		       //System.out.println(info[0]+" "+info[1]+" "+info[2]);
		       listaPaciente.add(new Paciente(info[0], info[1], info[2]));
		       
		    }
		    br.close();
		}
	}
}
