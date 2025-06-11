package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import BLL.Usuario;
import DLL.ControllerUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class RegistrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreUsuario;
	private JTextField apellidoUsuario;
	private JTextField dniUsuario;
	private JPasswordField contrasenaUsuario;
	private JTextField emailUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarUsuario frame = new RegistrarUsuario();
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
	public RegistrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Titulo = new JLabel("Registrar Usuario");
		Titulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Titulo.setBounds(111, 0, 199, 41);
		contentPane.add(Titulo);
		
		JLabel Nombre = new JLabel("Nombre");
		Nombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Nombre.setBounds(10, 60, 86, 14);
		contentPane.add(Nombre);
		
		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(10, 75, 103, 20);
		contentPane.add(nombreUsuario);
		nombreUsuario.setColumns(10);
		
		apellidoUsuario = new JTextField();
		apellidoUsuario.setColumns(10);
		apellidoUsuario.setBounds(134, 75, 103, 20);
		contentPane.add(apellidoUsuario);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(134, 60, 86, 14);
		contentPane.add(lblApellido);
		
		dniUsuario = new JTextField();
		dniUsuario.setColumns(10);
		dniUsuario.setBounds(261, 75, 103, 20);
		contentPane.add(dniUsuario);
		
		JLabel Dni = new JLabel("DNI");
		Dni.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Dni.setBounds(261, 60, 86, 14);
		contentPane.add(Dni);
		
		JLabel Contrasena = new JLabel("Insertar contraseña");
		Contrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Contrasena.setBounds(10, 120, 165, 14);
		contentPane.add(Contrasena);
		
		contrasenaUsuario = new JPasswordField();
		contrasenaUsuario.setBounds(10, 135, 165, 20);
		contentPane.add(contrasenaUsuario);
		
		JLabel Email = new JLabel("Insertar Email");
		Email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Email.setBounds(199, 120, 165, 14);
		contentPane.add(Email);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario UsuarioRegistrandose = new Usuario(0, nombreUsuario.getText(), apellidoUsuario.getText(), emailUsuario.getText(), contrasenaUsuario.getText(), dniUsuario.getText(), "");
				Usuario.RegistrarUsuario(UsuarioRegistrandose);
				if(true) {
				PantallaPrincipal vista = new PantallaPrincipal();
				vista.setVisible(true);
				dispose();
				}
				
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRegistrar.setBounds(122, 230, 134, 23);
		contentPane.add(btnRegistrar);
		
		emailUsuario = new JTextField();
		emailUsuario.setBounds(199, 135, 165, 20);
		contentPane.add(emailUsuario);
		emailUsuario.setColumns(10);
	}
}
