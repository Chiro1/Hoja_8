import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class DB {
	Comparator<Paciente> comparador;
	PriorityQueue<Paciente> listaPaciente;
	
	public DB(String archivo){
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
	
	public int size(String archivo) throws Exception{
		int l = 0;
		String linea;
		try (BufferedReader dr = new BufferedReader(new FileReader(archivo))) {
			while ((linea = dr.readLine()) != null) {
		       l++;
		       //System.out.println(l);
		    }
		    dr.close();
		}
		return l;
	}
	
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
