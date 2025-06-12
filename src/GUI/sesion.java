package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class sesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public sesion(Usuario usuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario actual:" + usuario.getNombre());
		lblNewLabel.setBounds(10, 11, 398, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ir a tabla");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				VistaUsuarios vista = new VistaUsuarios(usuario);
				vista.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(24, 171, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver libros");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaLibros vista = new VistaLibros();
				vista.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(138, 171, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
