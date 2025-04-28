import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Empleado extends Usuario implements Validacion {
	private String legajo;
    private String turno;
    private double sueldo;
	
	public Empleado(String nombre, String apellido, String email, String contrasena, String dni, String legajo, String turno, double sueldo) {
        super(nombre, apellido, email, contrasena, dni);
        this.legajo = legajo;
        this.turno = turno;
        this.sueldo = sueldo;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public boolean Login() {
		String mail;
		String contra;
		mail = JOptionPane.showInputDialog("Inserte email");
		contra = JOptionPane.showInputDialog("Inserte contraseña");
		if (this.getEmail().equalsIgnoreCase(mail) && this.getContrasena().equals(contra)) {
	        JOptionPane.showMessageDialog(null, "Logueado");
	        return true;
	    } else {
	        JOptionPane.showMessageDialog(null, "No logueado");
	        return false;
	    }
	}
	
	public void VenderLibro(LinkedList<Libro> libros) {
		String[] nombres = new String[libros.size()];
		
		for (int i = 0; i < libros.size(); i++) {
			nombres[i] = libros.get(i).getNombre();
		}
		
		String opcion = (String) JOptionPane.showInputDialog(null,"Seleccione Un Libro para vender",
				   "Libros", JOptionPane.QUESTION_MESSAGE, null,
				   nombres, nombres[0]);
		
		JOptionPane.showMessageDialog(null, opcion);
		
		
	
	
	}
	
	public void MenuPrincipal(LinkedList<Libro> libros){
		int opcion;
		do {
		opcion = JOptionPane.showOptionDialog(null, "Bienvenido empleado!", "Opciones", 0, 0, null, MenuEmpleado.values(), MenuEmpleado.values());
		
		switch (opcion) {
		case 0:
			//Lista
			JOptionPane.showMessageDialog(null, "Mostrar Lista de libros");
			break;
			
		case 1:
			//Vender
			VenderLibro(libros);

		default:
			break;
		} 
		
		}while(opcion != 2);
		}
}
