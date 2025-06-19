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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VenderLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public VenderLibro(Libro libro, Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 377, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Vendiendo libro: " + libro.getNombre());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(0, 0, 351, 40);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(0, 91, 105, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI del cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(0, 71, 116, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirmar con tu contraseña.");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(0, 122, 167, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Vender");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Venta venta = new Venta(Date.valueOf(LocalDate.now()), libro.getPrecio(), lblNewLabel_1.getText(), libro.getNombre(), usuario.getNombre());
				
				ControllerVenta.AgregarVenta(venta);
			}
		});
		btnNewButton.setBounds(0, 183, 105, 46);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(0, 144, 105, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("TOTAL: " + libro.getPrecio());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(0, 40, 182, 20);
		contentPane.add(lblNewLabel_2);
	}
}
