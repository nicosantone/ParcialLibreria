package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import BLL.Usuario;
import BLL.Venta;

public class ControllerVenta {

	private static Connection con = Conexion.getInstance().getConnection();
	
	public static void AgregarVenta(Venta venta) {
		try {
			PreparedStatement statement = con
				
					.prepareStatement("INSERT INTO venta (cliente_dni, libro_vendido, precio, empleado, fecha) VALUES (?, ?, ?, ?, ?)");
			statement.setString(1, venta.getClienteDNI());
			statement.setString(2, venta.getLibroVendido());
			statement.setDouble(3, venta.getTotal());
			statement.setString(4, venta.getEmpleado());
			statement.setDate(5, venta.getFecha());
			
			int filas = statement.executeUpdate();
			if (filas > 0) {
				System.out.println("Venta agregada correctamente.");
				JOptionPane.showMessageDialog(null, "Venta agregada correctamente.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	
	
	
	
	
	
	
}
