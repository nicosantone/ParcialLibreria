package GUI;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import BLL.Usuario;
import DLL.ControllerUsuario;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class VistaUsuarios extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private Usuario usuarioSeleccionado;
    private JTextField inpFiltro;

  

    public VistaUsuarios() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblSeleccionado = new JLabel("Seleccionado:");
        lblSeleccionado.setBounds(10, 10, 760, 20);
        contentPane.add(lblSeleccionado);


        model = new DefaultTableModel(
        		new String[]{"ID", 
        				"Nombre",
        				"Apellido",
        				"Email",
        				"Contraseña",
        				"Dni",
        				"Tipo",
        				}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 40, 760, 200);
        contentPane.add(scrollPane);

        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(10, 270, 150, 40);
        contentPane.add(btnAgregar);

        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(170, 270, 150, 40);
        contentPane.add(btnEditar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(330, 270, 150, 40);
        contentPane.add(btnEliminar);

        // Acción al seleccionar fila
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = table.getSelectedRow();
                if (row != -1) {

                    usuarioSeleccionado = new Usuario(
                        (int) model.getValueAt(row, 0),
                        (String) model.getValueAt(row, 1),
                        (String) model.getValueAt(row, 2),
                        (String) model.getValueAt(row, 3),
                        (String) model.getValueAt(row, 4),
                        (String) model.getValueAt(row, 5),
                        (String) model.getValueAt(row, 6)
                     
                    );
                    lblSeleccionado.setText(usuarioSeleccionado.toString());
                    
                   
                }
            }
        });
        inpFiltro = new JTextField();
        inpFiltro.setBounds(560, 273, 100, 34);
        contentPane.add(inpFiltro);
        inpFiltro.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("criterio");
        lblNewLabel.setBounds(560, 251, 46, 14);
        contentPane.add(lblNewLabel);
        
        JButton btnfiltrar = new JButton("filtrar");
        btnfiltrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		//cargarTablaFILTRAR(inpFiltro.getText());
        		
        	}
        });
        btnfiltrar.setBounds(560, 331, 111, 40);
        contentPane.add(btnfiltrar);
        
        JButton btnLimpia = new JButton("Limpiar");
        btnLimpia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		  cargarTabla();
        		  inpFiltro.setText("");
        	}
        });
        btnLimpia.setBounds(560, 384, 111, 40);
        contentPane.add(btnLimpia);
        // Cargar datos
        cargarTabla();

    }

    private void cargarTabla() {
    
        model.setRowCount(0);
        LinkedList<Usuario> usuarios = ControllerUsuario.MostrarUsuarios();
        for (Usuario elemento : usuarios) {
            model.addRow(new Object[]{
            		elemento.getId(), 
            		elemento.getNombre(),
            		elemento.getApellido(), 
            		elemento.getEmail(),
            		elemento.getContrasena(),
            		elemento.getDni(),
            		elemento.getTipo()
            		}
            );
    		
        	}
    }
//    }
//    private void cargarTablaFILTRAR(String filtro) {
//    	
//    	
//        model.setRowCount(0);
//        LinkedList<Usuario> usuarios = DLLUsuario.mostrarUsuarios();
//        for (Usuario usuario : usuarios) {
//        	if(usuario.getNombre().toLowerCase().startsWith(
//        			filtro.toLowerCase())
//        			||
//        			usuario.getNombre().contains(filtro)) {
//            model.addRow(new Object[]{
//            		usuario.getId(), 
//            		usuario.getNombre(),
//            		usuario.getEmail(), 
//            		usuario.getTipo(),
//            		usuario.getPassword()
//            		}
//            );
//        	}
//        }
//    }
}
