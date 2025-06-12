package BLL;
import java.time.LocalDate;

public class Venta {
	private LocalDate Fecha;
	private double Total;
	private String ClienteDNI;
	public Venta(LocalDate fecha, double total, String clienteDNI) {
		super();
		Fecha = fecha;
		this.Total = total;
		ClienteDNI = clienteDNI;
	}
	public LocalDate getFecha() {
		return Fecha;
	}
	public void setFecha(LocalDate fecha) {
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
	@Override
	public String toString() {
		return "Venta [Fecha=" + Fecha + ", total=" + Total + ", DNI del Cliente=" + ClienteDNI + "]";
	}
}
