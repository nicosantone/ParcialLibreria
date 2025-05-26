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
}
