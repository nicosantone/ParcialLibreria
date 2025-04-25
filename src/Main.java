import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		LinkedList<Libro> libros = new LinkedList<>();
		
		libros.add(new Libro("Cien Años de Soledad", "Gabriel García Marquez", "Planeta", 30000.0, "Clasicos", true));
        libros.add(new Libro("Saga Harry Potter", "JK Rowling", "Bloomsbury Publishing", 100000.0, "ficcion", true));
        libros.add(new Libro("We Were Liars", "Emily Lookhart", "Blue Salamandra", 20000.0, "Romance juvenil", true));
        libros.add(new Libro("El Hombre Equivocado", "John Katzenbach", "Ediciones B", 30000.0, "Thriller psicologico", true));
        
        
		Gerente gerente = new Gerente("Lucas", "Martínez", "lucas@gmail.com", "1234", "12345678", "Ventas", 250000);
		Empleado empleado = new Empleado("Lucas", "Martínez", "lucas@gmail.com", "1234", "12345678", "legajo", "turno", 20000);
		empleado.VenderLibro(libros);
		gerente.registrarLibros(libros);
		
        gerente.eliminarLibrosSinStock(libros);
        gerente.mostrarLibrosDisponibles(libros);
		

	}

}
