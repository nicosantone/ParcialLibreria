package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import BLL.Usuario;

public class ControllerUsuario {
	
	private static Connection con = Conexion.getInstance().getConnection();

	
	
	public static Usuario login(String mail, String contra) {
		Usuario usuario = new Usuario(); 
		
		String contraEncriptada = usuario.encriptar(contra);
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? AND contrasena = ?");
			stmt.setString(1, mail);
			stmt.setString(2, contraEncriptada);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String contrasena = rs.getString("contrasena");
				String dni = rs.getString("dni");
				String tipo = rs.getString("tipo");
				

				usuario = new Usuario(id, nombre, apellido, email, usuario.desencriptar(contrasena), dni, tipo);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public static LinkedList<Usuario> MostrarUsuarios() {
		LinkedList<Usuario> usuarios = new LinkedList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String contrasena = rs.getString("contrasena");
				String dni = rs.getString("dni");
				String tipo = rs.getString("tipo");
				
				usuarios.add(new Usuario(id, nombre, apellido, email, contrasena, dni, tipo));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public static void AgregarUsuario(Usuario usuario) {
		try {
			PreparedStatement statement = con
				
					.prepareStatement("INSERT INTO usuario (nombre, apellido, email, contrasena, dni, tipo) VALUES (?, ?, ?, ?, ?, ?)");
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getApellido());
			statement.setString(3, usuario.getEmail());
			statement.setString(4, usuario.encriptar(usuario.getContrasena()));
			statement.setString(5, usuario.getDni());
			statement.setString(6, usuario.getTipo());
			
			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Usuario agregado correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
}
