
public class Empleado extends Usuario {
	private String legajo;
    private String turno;
    private double sueldo;
	
	public Empleado(String nombre, String apellido, String email, String contrasena, String dni, String legajo, String turno, double sueldo) {
        super(nombre, apellido, email, contrasena, dni);
        this.legajo = legajo;
        this.turno = turno;
        this.sueldo = sueldo;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
		
	}
}
