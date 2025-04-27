import javax.swing.JOptionPane;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<Libro> libros = new LinkedList<>();
		libros.add(new Libro("Cien Años de Soledad", "Gabriel García Marquez", "Planeta", 30000.0, "Clasicos", true));
        libros.add(new Libro("Saga Harry Potter", "JK Rowling", "Bloomsbury Publishing", 100000.0, "ficcion", true));
        libros.add(new Libro("We Were Liars", "Emily Lookhart", "Blue Salamandra", 20000.0, "Romance juvenil", true));
        libros.add(new Libro("El Hombre Equivocado", "John Katzenbach", "Ediciones B", 30000.0, "Thriller psicologico", true));

        Gerente gerente = new Gerente("Nicolás", "Santone", "nicolas.santone@libreria.com", "admin123", "12345678", "Administración", 150000);

        boolean logueado = false;
        int intentos = 0;

        while (!logueado && intentos < 3) {
            String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
            if (nombre == null) System.exit(0);

            String apellido = JOptionPane.showInputDialog("Ingrese su apellido:");
            if (apellido == null) System.exit(0);

            String email = JOptionPane.showInputDialog("Ingrese su email:");
            if (email == null) System.exit(0);

            String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
            if (contrasena == null) System.exit(0);

            if (nombre.equalsIgnoreCase(gerente.getNombre()) &&
                apellido.equalsIgnoreCase(gerente.getApellido()) &&
                email.equalsIgnoreCase(gerente.getEmail()) &&
                contrasena.equals(gerente.getContrasena())) {

                logueado = true;
                JOptionPane.showMessageDialog(null, "¡Inicio de sesión exitoso! Bienvenido " + gerente.getNombre() + ".");
            } else {
                intentos++;
                JOptionPane.showMessageDialog(null, "Datos incorrectos. Intento " + intentos + " de 3.");
            }
        }

        if (!logueado) {
            JOptionPane.showMessageDialog(null, "Llegaste al límite de intentos posibles. Cerrando sistema...");
            System.exit(0);
        }

        boolean seguir = true;

        while (seguir) {
            String opcion = JOptionPane.showInputDialog(
                "Bienvenido, Gerente. Elija una opción:\n" +
                "1. Ver lista de libros disponibles.\n" +
                "2. Eliminar libros sin stock.\n" +
                "3. Agregar libros.\n" +
                "4. Modificar precios.\n" +
                "5. Salir."
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    gerente.verLibrosDisponibles(libros);
                    break;
                case "2":
                    gerente.eliminarLibroNoDisponible(libros);
                    break;
                case "3":
                    gerente.agregarLibro(libros);
                    break;
                case "4":
                    gerente.modificarPrecio(libros);
                    break;
                case "5":
                    seguir = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}
