package Visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.Servidor;

import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;

public class telaMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private static Servidor server;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaMain frame = new telaMain();
					frame.setVisible(true);
					
					server = new Servidor();
					Thread thServer = new Thread(server);
					thServer.start();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public telaMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNovaLoja = new JButton("Nova loja");
		btnNovaLoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				telaCadastroLoja tlLoja = new telaCadastroLoja();
				tlLoja.setVisible(true);
			
			}
		});
		btnNovaLoja.setBounds(53, 38, 117, 25);
		contentPane.add(btnNovaLoja);
		
		JButton btnNvCarro = new JButton("Novo carro");
		btnNvCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroCarro tlCarro = new TelaCadastroCarro();
				tlCarro.setVisible(true);
				
			}
		});
		btnNvCarro.setBounds(247, 38, 117, 25);
		contentPane.add(btnNvCarro);
		
		JButton btnBuscaRpidaDe = new JButton("Buscar");
		btnBuscaRpidaDe.setBounds(227, 137, 117, 25);
		contentPane.add(btnBuscaRpidaDe);
		
		JLabel lblBuscarVeculos = new JLabel("buscar veículo:");
		lblBuscarVeculos.setBounds(30, 113, 124, 15);
		contentPane.add(lblBuscarVeculos);
		
		textField = new JTextField();
		textField.setBounds(56, 140, 114, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBounds(193, 246, -137, -48);
		contentPane.add(table);
	}
}
