package BLL;

public class Libro {
	private int id;
	private String nombre;
    private String autor;
    private String editorial;
    private Double precio;
    private String categoria;
    private boolean disponibilidad;
	
    public Libro(int id, String nombre, String autor, String editorial, Double precio, String categoria,
			boolean disponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.autor = autor;
		this.editorial = editorial;
		this.precio = precio;
		this.categoria = categoria;
		this.disponibilidad = disponibilidad;
	}

//	public Libro(String nombre2, String autor2, String editorial2, int i, String categoria2, boolean disponibilidad2) {
//		// TODO Auto-generated constructor stub
//	}
    

	public String getNombre() {
		return nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", autor=" + autor + ", editorial=" + editorial + ", precio="
				+ precio + ", categoria=" + categoria + ", disponibilidad=" + disponibilidad + "]";
	}
}
