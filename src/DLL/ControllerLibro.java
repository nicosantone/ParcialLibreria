package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.Libro;
import BLL.Usuario;

public class ControllerLibro {
	private static Connection con = Conexion.getInstance().getConnection();
	
	public static LinkedList<Libro> MostrarLibros() {
		LinkedList<Libro> libros = new LinkedList<>();
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM libro");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String autor = rs.getString("autor");
				String editorial = rs.getString("editorial");
				double precio = rs.getDouble("precio");
				String categoria = rs.getString("categoria");
				Boolean disponibilidad = rs.getBoolean("disponibilidad");
				
				libros.add(new Libro(id, nombre, autor, editorial, precio, categoria, disponibilidad));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
		
	}
	
	public static void AgregarLibro(Libro libro) {
		try {
			PreparedStatement statement = con
				
					.prepareStatement("INSERT INTO libro (nombre, autor, editorial, precio, categoria, disponibilidad) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setString(1, libro.getNombre());
			statement.setString(2, libro.getAutor());
			statement.setString(3, libro.getEditorial());
			statement.setDouble(4, libro.getPrecio());
			statement.setString(5, libro.getCategoria());
			statement.setBoolean(6, libro.isDisponibilidad());
			
			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Libro agregado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}	
}
