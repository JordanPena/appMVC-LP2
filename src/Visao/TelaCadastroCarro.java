package Visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class TelaCadastroCarro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCarro frame = new TelaCadastroCarro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastroCarro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(90, 98, 32, 24);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(94, 41, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(12, 41, 70, 15);
		contentPane.add(lblModelo);
		
		JLabel lblLoja = new JLabel("loja: ");
		lblLoja.setBounds(12, 103, 70, 15);
		contentPane.add(lblLoja);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setBounds(12, 172, 70, 15);
		contentPane.add(lblAno);
		
		JButton btnOk = new JButton("OK!");
		btnOk.setBounds(161, 263, 117, 25);
		contentPane.add(btnOk);
		
		textField_1 = new JTextField();
		textField_1.setBounds(94, 170, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}

}
