import javax.swing.JOptionPane;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Libro> libros = new LinkedList<>();
		Gerente gerente = new Gerente("Lucas", "Martínez", "lucas@gmail.com", "1234", "12345678", "Ventas", 250000);
		
        gerente.registrarLibros(libros);
        gerente.eliminarLibrosSinStock(libros);
        gerente.mostrarLibrosDisponibles(libros);
		
	}

}
