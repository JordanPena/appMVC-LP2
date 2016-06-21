package Visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.Cliente;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaCadastroLoja extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastroLoja frame = new telaCadastroLoja();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telaCadastroLoja() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFilial = new JLabel("Filial: ");
		lblFilial.setBounds(12, 57, 70, 15);
		contentPane.add(lblFilial);
		
		textField = new JTextField();
		textField.setBounds(105, 55, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(12, 106, 70, 15);
		contentPane.add(lblCidade);
		
		textField_1 = new JTextField();
		textField_1.setBounds(105, 104, 114, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(12, 155, 70, 15);
		contentPane.add(lblTel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(105, 153, 114, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente clienteCadastra = new Cliente();
				Thread thClient = new Thread(clienteCadastra);
				thClient.start();
				
			}
		});
		btnSalvar.setBounds(150, 224, 117, 25);
		contentPane.add(btnSalvar);
	}

}
