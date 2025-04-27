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
	
	public void registrarLibros(LinkedList<Libro> libros) {
        String seguir = "si";
        while (seguir.equalsIgnoreCase("si")) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del libro:");
            String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
            String editorial = JOptionPane.showInputDialog("Ingrese la editorial:");
            double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del libro:"));
            String categoria = JOptionPane.showInputDialog("Ingrese la categoría del libro:");
            String disponibleTexto = JOptionPane.showInputDialog("¿Está disponible? (si/no):");
            boolean disponibilidad = disponibleTexto.equalsIgnoreCase("si");

            Libro libro = new Libro(nombre, autor, editorial, precio, categoria, disponibilidad);
            libros.add(libro);

            seguir = JOptionPane.showInputDialog("¿Desea registrar otro libro? (si/no):");
        }
    }

    public void eliminarLibrosSinStock(LinkedList<Libro> libros) {
        for (int i = 0; i < libros.size(); i++) {
            if (!libros.get(i).isDisponibilidad()) {
                libros.remove(i);
                i--;
            }
        }
    }

    public void mostrarLibrosDisponibles(LinkedList<Libro> libros) {
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros disponibles.");
            return;
        }

        String resumen = "Libros en stock:\n\n";
        for (Libro l : libros) {
            resumen += "Título: " + l.getNombre() + "\n";
            resumen += "Autor: " + l.getAutor() + "\n";
            resumen += "Editorial: " + l.getEditorial() + "\n";
            resumen += "Precio: $" + l.getPrecio() + "\n";
            resumen += "Categoría: " + l.getCategoria() + "\n";
            resumen += "Disponible: " + (l.isDisponibilidad() ? "Sí" : "No") + "\n\n";
        }

        JOptionPane.showMessageDialog(null, resumen);
	

}
}
