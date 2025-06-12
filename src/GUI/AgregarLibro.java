package GUI;

import javax.swing.*;
import java.awt.event.*;
import DLL.ControllerLibro;

public class AgregarLibro extends JFrame {

	private JTextField txtTitulo;
	private JTextField txtAutor;
	private JTextField txtISBN;
	private JTextField txtPrecio;
	private JTextField txtStock;

	public AgregarLibro() {
		setTitle("Agregar Nuevo Libro");
		setSize(400, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("Título:");
		lblTitulo.setBounds(30, 30, 100, 25);
		getContentPane().add(lblTitulo);

		txtTitulo = new JTextField();
		txtTitulo.setBounds(140, 30, 200, 25);
		getContentPane().add(txtTitulo);

		JLabel lblAutor = new JLabel("Autor:");
		lblAutor.setBounds(30, 70, 100, 25);
		getContentPane().add(lblAutor);

		txtAutor = new JTextField();
		txtAutor.setBounds(140, 70, 200, 25);
		getContentPane().add(txtAutor);

//		JLabel lblISBN = new JLabel("ISBN:");
//		lblISBN.setBounds(30, 110, 100, 25);
//		getContentPane().add(lblISBN);

//		txtISBN = new JTextField();
//		txtISBN.setBounds(140, 110, 200, 25);
//		getContentPane().add(txtISBN);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(30, 150, 100, 25);
		getContentPane().add(lblPrecio);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(140, 150, 200, 25);
		getContentPane().add(txtPrecio);

//		JLabel lblStock = new JLabel("Stock:");
//		lblStock.setBounds(30, 190, 100, 25);
//		getContentPane().add(lblStock);
//
//		txtStock = new JTextField();
//		txtStock.setBounds(140, 190, 200, 25);
//		getContentPane().add(txtStock);

		JButton btnAgregar = new JButton("Agregar");
		String editorial = JOptionPane.showInputDialog("Ingrese editorial:");
		String categoria = JOptionPane.showInputDialog("Ingrese categoría:");
		boolean disponibilidad = true;
		btnAgregar.setBounds(140, 240, 100, 30);
		getContentPane().add(btnAgregar);

		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = txtTitulo.getText();
				String autor = txtAutor.getText();
//				String isbn = txtISBN.getText();
				double precio;
				//int stock;

				try {
					precio = Double.parseDouble(txtPrecio.getText());
					//stock = Integer.parseInt(txtStock.getText());

					//ControllerLibro controller = new ControllerLibro();
					ControllerLibro.AgregarLibro(titulo, autor, editorial, precio, categoria, disponibilidad);

					JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");
					dispose(); // cerrar ventana

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Precio o Stock con formato inválido.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Error al agregar el libro: " + ex.getMessage());
				}
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new AgregarLibro().setVisible(true);
		});
	}
}

