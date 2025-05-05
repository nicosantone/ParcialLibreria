import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Gerente extends Usuario {
	private String area;
	private double sueldo;
	
	public Gerente(String nombre, String apellido, String email, String contrasena, String dni, String area, double sueldo) {
        super(nombre, apellido, email, contrasena, dni);
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
	    public void agregarLibro(LinkedList<Libro> libros) {
	        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro:");
	        String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
	        String editorial = JOptionPane.showInputDialog("Ingrese la editorial:");
	        double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del libro:"));
	        String categoria = JOptionPane.showInputDialog("Ingrese la categoría del libro:");
	        String disponibleTexto = JOptionPane.showInputDialog("¿Está disponible? (si/no):");
	        boolean disponibilidad = disponibleTexto.equalsIgnoreCase("si");

	        Libro nuevoLibro = new Libro(nombre, autor, editorial, precio, categoria, disponibilidad);
	        libros.add(nuevoLibro);

	        JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
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
