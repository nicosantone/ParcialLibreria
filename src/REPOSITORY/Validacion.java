package REPOSITORY;
import javax.swing.JOptionPane;
public interface Validacion {
default boolean ValidarEmail(String email) {
		
		if(email.contains("@libreria.com")) {
			return true;
		}else {
			return false;
		}
	}
}
