package BLL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;
import DLL.ControllerUsuario;
import REPOSITORY.Encriptador;

public class Usuario implements Encriptador {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	private String contrasena;
	private String dni;
	private String tipo; //Empleado o Gerente

	
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

	public Usuario() {
		
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

	public static Usuario login(String mail, String contra) {
		boolean flag = false;
		JOptionPane.showMessageDialog(null, mail);
		JOptionPane.showMessageDialog(null, contra);
		if (mail.isEmpty() || contra.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Hubo un error");
			return null;
		}else {
			for (int i = 0; i < ControllerUsuario.MostrarUsuarios().size(); i++) {
				if (ControllerUsuario.MostrarUsuarios().get(i).getEmail().contains(mail) & ControllerUsuario.MostrarUsuarios().get(i).getContrasena().contains(contra)) {
					flag=true;
					break;
				} else {
					flag=false;
				}
			}
			
			if (flag==true) {
				return ControllerUsuario.login(mail, contra);
			} else {
				return null;
			}
			
		}
		
	}

	public static void RegistrarUsuario(Usuario nuevo) {
		LinkedList<Usuario> usuariosExistentes = ControllerUsuario.MostrarUsuarios();
				
				//ESTO SE CAMBIARA!!!!! EL REGISTRO NO FUNCIONA COMPLETOOO!!!!!
				String nombre = "";
				String apellido = "";
				String email = "";
				String contra = "";
				String dni = "";
				nuevo.setNombre(JOptionPane.showInputDialog("nombre", nombre));
				nuevo.setApellido(JOptionPane.showInputDialog("apellido", apellido));    
				nuevo.setEmail(JOptionPane.showInputDialog("Email", email));    
				nuevo.setContrasena(JOptionPane.showInputDialog("Contra", contra));
				nuevo.setDni(JOptionPane.showInputDialog("DNI", dni));
				nuevo.setTipo("Empleado");
				boolean flag = true;
				for (Usuario existentes : usuariosExistentes) {
					if (existentes.getEmail().equals(nuevo.getEmail())) {
						JOptionPane.showMessageDialog(null, "Ya hay un usuario creado con este email, intenta de nuevo.");
						flag=false;
					}
				}
				if (flag==true) {
					ControllerUsuario.AgregarUsuario(nuevo);
				}
			}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", contrasena=" + contrasena + ", dni=" + dni + ", tipo=" + tipo + "]";
	}
	}

