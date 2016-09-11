package ventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import funciones.Cuil;
import funciones.Funciones;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textDni;
	private JTextField textCuil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("OBTENER CUIL");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textDni = new JTextField();
		textDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDni.setBounds(95, 23, 100, 20);
		panel.add(textDni);
		textDni.setColumns(10);
		
		JLabel lblDni = new JLabel("D.N.I:");
		lblDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDni.setBounds(46, 19, 59, 28);
		panel.add(lblDni);
		
		JComboBox comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Femenino"}));
		comboSexo.setSelectedIndex(0);
		comboSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboSexo.setBounds(95, 54, 100, 20);
		panel.add(comboSexo);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSexo.setBounds(46, 58, 46, 14);
		panel.add(lblSexo);
		
		JButton btnObtenerCuil = new JButton("Obtener CUIL");
		btnObtenerCuil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				char sexo = 'q';
				if (comboSexo.getSelectedIndex() == 0) {
					sexo = 'm';
				}else{
					sexo = 'f';
				}
				try {
					textCuil.setText(Cuil.getCuil(Integer.parseInt(textDni.getText()), sexo));
				}catch (Exception e) {
					System.out.println(e.getMessage());
					JOptionPane.showMessageDialog(contentPane, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					textCuil.setText("");
				}
			}
		});
		btnObtenerCuil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnObtenerCuil.setBounds(46, 85, 149, 23);
		panel.add(btnObtenerCuil);
		
		textCuil = new JTextField();
		textCuil.setEditable(false);
		textCuil.setHorizontalAlignment(SwingConstants.CENTER);
		textCuil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCuil.setBounds(46, 119, 149, 20);
		panel.add(textCuil);
		textCuil.setColumns(10);
		
		JLabel lblAgustinPadron = new JLabel("Agustin Padron");
		lblAgustinPadron.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Funciones.openURL("http://github.com/agus0/generadorCuil");
			}
		});
		lblAgustinPadron.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAgustinPadron.setBounds(126, 158, 110, 14);
		panel.add(lblAgustinPadron);
	}
}
