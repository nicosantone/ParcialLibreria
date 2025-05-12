import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private String dni;
	private String tipo; //Empleado o Gerente
    private static Connection con = Conexion.getInstance().getConnection();

	
	public Usuario(int id, String nombre, String apellido, String email, String contrasena, String dni, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.contrasena = contrasena;
		this.dni = dni;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public static void RegistrarUsuario(Usuario nuevo) {
		LinkedList<Usuario> usuariosExistentes = MostrarUsuarios();
		
		for (Usuario existentes : usuariosExistentes) {
			if (existentes.getEmail().equals(nuevo.email)) {
				JOptionPane.showMessageDialog(null, "Ya hay un usuario creado con este email, intenta de nuevo.");
				return;
			}
			
			AgregarUsuario(nuevo);
		}
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
			statement.setString(4, usuario.getContrasena());
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

