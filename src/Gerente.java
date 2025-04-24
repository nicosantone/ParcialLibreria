
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
}
