package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Gerente;
import BLL.Libro;
import BLL.Usuario;
import DLL.ControllerLibro;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class AgregarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarLibro frame = new AgregarLibro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AgregarLibro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 251);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Libro a la base de datos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(60, -1, 260, 30);
		contentPane.add(lblNewLabel);
		
		JLabel name = new JLabel("Nombre");
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(10, 40, 70, 20);
		contentPane.add(name);
		
		textField = new JTextField();
		textField.setBounds(10, 60, 97, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel author = new JLabel("Autor");
		author.setFont(new Font("Tahoma", Font.PLAIN, 14));
		author.setBounds(134, 41, 70, 20);
		contentPane.add(author);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(134, 61, 97, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(264, 61, 97, 20);
		contentPane.add(textField_2);
		
		JLabel editor = new JLabel("Editorial");
		editor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		editor.setBounds(264, 41, 70, 20);
		contentPane.add(editor);
		
		JLabel categoria = new JLabel("Categoria");
		categoria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoria.setBounds(70, 91, 70, 20);
		contentPane.add(categoria);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(70, 111, 97, 20);
		contentPane.add(textField_3);
		
		JLabel precio = new JLabel("Precio");
		precio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		precio.setBounds(192, 91, 70, 20);
		contentPane.add(precio);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double PrecioConvertido = Double.valueOf(precio.getText());
			
				
				Libro LibroNuevo = new Libro(0, name.getText(), author.getText(), editor.getText(), PrecioConvertido, categoria.getText(), true);
				
				LibroNuevo.agregarLibro(LibroNuevo);
				
				
			}
		});
		btnNewButton.setBounds(125, 154, 106, 42);
		contentPane.add(btnNewButton);
		
		JSpinner Precio = new JSpinner();
		Precio.setBounds(192, 111, 97, 20);
		contentPane.add(Precio);
	}
}
