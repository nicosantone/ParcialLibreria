package BLL;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.ControllerLibro;

public class Gerente extends Usuario {
	private String area;
	private double sueldo;
	
	public Gerente(int id, String nombre, String apellido, String email, String contrasena, String dni, String tipo,
			String area, double sueldo) {
		super(id, nombre, apellido, email, contrasena, dni, tipo);
		this.area = area;
		this.sueldo = sueldo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	   public void verLibrosDisponibles(LinkedList<Libro> libros) {
	        String lista = "";
	        for (Libro libro : libros) {
	            if (libro.isDisponibilidad()) {
	                lista += "Título: " + libro.getNombre() + "\n";
	                lista += "Autor: " + libro.getAutor() + "\n";
	                lista += "Editorial: " + libro.getEditorial() + "\n";
	                lista += "Precio: $" + libro.getPrecio() + "\n";
	                lista += "Categoría: " + libro.getCategoria() + "\n\n";
	            }
	        }

	        if (lista.equals("")) {
	            lista = "No hay libros disponibles actualmente.";
	        }

	        JOptionPane.showMessageDialog(null, lista);
	    }

	    // Eliminar libros sin stock
	   public void eliminarLibroNoDisponible(LinkedList<Libro> libros) {
		    if (libros.isEmpty()) {
		        JOptionPane.showMessageDialog(null, "No hay libros para eliminar.");
		        return;
		    }

		    String[] nombresLibros = new String[libros.size()];
		    for (int i = 0; i < libros.size(); i++) {
		        nombresLibros[i] = libros.get(i).getNombre();
		    }

		    String seleccion = (String) JOptionPane.showInputDialog(
		        null,
		        "Seleccione el libro que desea eliminar:",
		        "Eliminar libro",
		        JOptionPane.QUESTION_MESSAGE,
		        null,
		        nombresLibros,
		        nombresLibros[0]
		    );

		    if (seleccion == null) {
		        return; 
		    }

		    boolean eliminado = false;
		    for (int i = 0; i < libros.size(); i++) {
		        if (libros.get(i).getNombre().equalsIgnoreCase(seleccion)) {
		            libros.remove(i);
		            eliminado = true;
		            JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
		            break;
		        }
		    }

		    if (!eliminado) {
		        JOptionPane.showMessageDialog(null, "No se pudo eliminar el libro.");
		    }
		}

	    // Agregar libro
	    public void agregarLibro(Libro nuevo) {
	    	boolean flag = true;
	    	//Nombre
	    	if(nuevo.getNombre().isEmpty()) {
	    		JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio");
	    		flag=false;
	    	}
	    	
	    	
	    	
	    	//Autor
	    	if(nuevo.getAutor().isEmpty()) {
	    		JOptionPane.showMessageDialog(null, "El campo autor no puede estar vacio");
	    		flag=false;
	    		
	    	}
	    	
	    	for (int i = 0; i < nuevo.getAutor().length(); i++) {
	    		if( Character.isDigit(nuevo.getAutor().charAt(i))) {
	    			JOptionPane.showMessageDialog(null, "El autor no puede contener numeros.");
	    			flag=false;
	    			break;
	    		}
				
			}
	    	
	    	//editorial
	    	if(nuevo.getEditorial().isEmpty()) {
	    		JOptionPane.showMessageDialog(null, "El campo editorial no puede estar vacio");
	    		flag=false;
	    	}
	    	
	    	//precio
	    	if(nuevo.getPrecio().equals(null)) {
	    		JOptionPane.showMessageDialog(null, "El campo precio no puede estar vacio");
	    		flag=false;
	    	}
	    	
	    	//categoria
	    	
	    	if(nuevo.getCategoria().isEmpty()) {
	    		JOptionPane.showMessageDialog(null, "El campo categoria no puede estar vacio");
	    		flag=false;
	    	}
	    	
	    	if (flag==true) {
				ControllerLibro.AgregarLibro(nuevo);
				JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
			} else {
				JOptionPane.showMessageDialog(null, "Intente de nuevo");
			}
	

	      

	        
	    }

	    // Modificar precio
	    public void modificarPrecio(LinkedList<Libro> libros) {
	        if (libros.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No hay libros para modificar.");
	            return;
	        }

	        String[] nombresLibros = new String[libros.size()];
	        for (int i = 0; i < libros.size(); i++) {
	            nombresLibros[i] = libros.get(i).getNombre();
	        }

	        String seleccion = (String) JOptionPane.showInputDialog(
	            null,
	            "Seleccione el libro al que desea modificar el precio:",
	            "Modificar precio",
	            JOptionPane.QUESTION_MESSAGE,
	            null,
	            nombresLibros,
	            nombresLibros[0]
	        );

	        if (seleccion == null) {
	            return; 
	        }

	        for (Libro libro : libros) {
	            if (libro.getNombre().equalsIgnoreCase(seleccion)) {
	                double nuevoPrecio;
	                try {
	                    String input = JOptionPane.showInputDialog("Precio actual: $" + libro.getPrecio() + "\nIngrese el nuevo precio:");
	                    if (input == null) return; 

	                    nuevoPrecio = Double.parseDouble(input);

	                    if (nuevoPrecio < 0) {
	                        JOptionPane.showMessageDialog(null, "El precio no puede ser negativo.");
	                        return;
	                    }

	                    libro.setPrecio(nuevoPrecio);
	                    JOptionPane.showMessageDialog(null, "Precio actualizado con éxito.");
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
	                }
	                return;
	            }
	        }

	        JOptionPane.showMessageDialog(null, "No se encontró un libro con ese nombre.");
	    }
    
    
    
    

}
