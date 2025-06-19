package BLL;
import java.sql.Date;
import java.time.LocalDate;

public class Venta {
	private Date Fecha;
	private double Total;
	private String ClienteDNI;
	private String LibroVendido;
	private String Empleado;
	public Venta(Date fecha, double total, String clienteDNI, String libroVendido, String empleado) {
		super();
		Fecha = fecha;
		Total = total;
		ClienteDNI = clienteDNI;
		LibroVendido = libroVendido;
		Empleado = empleado;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double total) {
		this.Total = total;
	}
	public String getClienteDNI() {
		return ClienteDNI;
	}
	public void setClienteDNI(String clienteDNI) {
		ClienteDNI = clienteDNI;
	}
	
	public String getLibroVendido() {
		return LibroVendido;
	}
	public void setLibroVendido(String libroVendido) {
		LibroVendido = libroVendido;
	}
	public String getEmpleado() {
		return Empleado;
	}
	public void setEmpleado(String empleado) {
		Empleado = empleado;
	}
	@Override
	public String toString() {
		return "Venta [Fecha=" + Fecha + ", total=" + Total + ", DNI del Cliente=" + ClienteDNI + "]";
	}
}
