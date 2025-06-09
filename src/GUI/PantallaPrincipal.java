package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import BLL.Usuario;
import DLL.ControllerUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Email;
	private JPasswordField Contraseña;
	private JButton BotonLogin;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido a la Libreria!!!!!!!!!!!!!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setBounds(10, 11, 350, 35);
		contentPane.add(lblNewLabel);
		
		Email = new JTextField();
		Email.setBounds(0, 91, 123, 20);
		contentPane.add(Email);
		Email.setColumns(10);
		
		Contraseña = new JPasswordField();
		Contraseña.setBounds(0, 149, 123, 20);
		contentPane.add(Contraseña);
		
		BotonLogin = new JButton("LOGIN");
		BotonLogin.setBounds(0, 194, 89, 23);
		contentPane.add(BotonLogin);
		BotonLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario logueado =  Usuario.login(Email.getText(),Contraseña.getText());
				if (logueado == null) {
					JOptionPane.showMessageDialog(null,"error");
				} else {
					sesion pantalla = new sesion(logueado);
					pantalla.setVisible(true);
					dispose();
				}
			}
		});
		
		
		lblNewLabel_1 = new JLabel("Introducir EMAIL.");
		lblNewLabel_1.setBounds(0, 75, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2 = new JLabel("Introducir CONTRASEÑA.");
		lblNewLabel_2.setBounds(0, 128, 146, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton REGISTRO = new JButton("REGISTRAR");
		REGISTRO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarUsuario vista = new RegistrarUsuario();
				vista.setVisible(true);
				dispose();
			}
		});
		REGISTRO.setBounds(99, 194, 89, 23);
		contentPane.add(REGISTRO);
	}
}
