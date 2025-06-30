package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import BLL.Usuario;
import BLL.Venta;
import DLL.ControllerVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VenderLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField DNI;

	/**
	 * Create the frame.
	 */
	public VenderLibro(Libro libro, Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 295, 264);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vendiendo libro: " + libro.getNombre());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(0, 0, 351, 40);
		contentPane.add(lblNewLabel);
		
		DNI = new JTextField();
		DNI.setBounds(0, 91, 105, 20);
		contentPane.add(DNI);
		DNI.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI del cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(0, 71, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag=true;
				String dni= DNI.getText();
				
				
			
				//DNI
				if(dni.isEmpty()) {
					flag=false;
					JOptionPane.showMessageDialog(null, "DNI no puede estar vacio");
				}else {
					for (int i = 0; i < dni.length(); i++) {
						if (Character.isLetter(dni.charAt(i))) {
							flag=false;
							JOptionPane.showMessageDialog(null, "Solo puedes poner numeros");
							break;
						}
					}
					if (flag==true && dni.length()!=8) {
						flag=false;
						JOptionPane.showMessageDialog(null, "Debe haber 8 numeros introducidos");
					}
				}
				
				
				if(flag==true) {
				Venta venta = new Venta(Date.valueOf(LocalDate.now()), libro.getPrecio(), dni, libro.getNombre(), usuario.getNombre());
				
				ControllerVenta.AgregarVenta(venta);
				libro.setDisponibilidad(false);
				sesion vista = new sesion(usuario);
				vista.setVisible(true);
				dispose();
				
				}else {
					JOptionPane.showMessageDialog(null, "error");
					
				}
			}
		});
		btnNewButton.setBounds(0, 122, 105, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL: " + libro.getPrecio());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 40, 182, 20);
		contentPane.add(lblNewLabel_2);
		
		JButton Volver = new JButton("<-");
		Volver.setBounds(0, 202, 89, 23);
		contentPane.add(Volver);
		Volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaLibros vista = new VistaLibros(usuario);
				vista.setVisible(true);
				dispose();
				
			}
		});
	}
}
