import javax.swing.JOptionPane;
import java.util.LinkedList;
public class Main {

	public static void main(String[] args) {
		LinkedList<Libro> libros = new LinkedList<>();
		libros.add(new Libro("Cien Años de Soledad", "Gabriel García Marquez", "Planeta", 30000.0, "Clasicos", true));
		libros.add(new Libro("Saga Harry Potter", "JK Rowling", "Bloomsbury Publishing", 100000.0, "Ficción", true));
		libros.add(new Libro("We Were Liars", "Emily Lockhart", "Blue Salamandra", 20000.0, "Romance juvenil", true));
		libros.add(new Libro("El Hombre Equivocado", "John Katzenbach", "Ediciones B", 30000.0, "Thriller psicológico", true));
		
		Gerente gerente = new Gerente("Nicolás", "Santone", "nicolas.santone@libreria.com", "admin123", "12345678", "Administración", 150000);
		Empleado empleado = new Empleado("Juan", "Pérez", "juan.perez@libreria.com", "empleado123", "87654321", "E001", "Mañana", 80000);

		String[] opcionesUsuario = {"Gerente", "Empleado"};
		String seleccionUsuario = (String) JOptionPane.showInputDialog(null, "¿Cómo desea ingresar?", "Selección de usuario", JOptionPane.QUESTION_MESSAGE, null, opcionesUsuario, opcionesUsuario[0]);
		
		if (seleccionUsuario == null) {
			JOptionPane.showMessageDialog(null, "Programa finalizado.");
			System.exit(0);
		}
		
		if (seleccionUsuario.equals("Gerente")) {
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
				String[] opcionesGerente = {"Ver libros disponibles", "Agregar libro", "Eliminar libro", "Modificar precio", "Salir"};
				int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú Gerente", 0, 0, null, opcionesGerente, opcionesGerente[0]);
				
				switch (opcion) {
				case 0:
					gerente.verLibrosDisponibles(libros);
					break;
				case 1:
					gerente.agregarLibro(libros);
					break;
				case 2:
					gerente.eliminarLibroNoDisponible(libros);
					break;
				case 3:
					gerente.modificarPrecio(libros);
					break;
				case 4:
					seguir = false;
					JOptionPane.showMessageDialog(null, "Cerrando sesión...");
					break;
				default:
					break;
				}
			}
			
		} else if (seleccionUsuario.equals("Empleado")) {
			if (empleado.Login()) {
				empleado.MenuPrincipal(libros);
			} else {
				JOptionPane.showMessageDialog(null, "No se pudo iniciar sesión. Cerrando sistema...");
				System.exit(0);
			}
		}
	}
}
