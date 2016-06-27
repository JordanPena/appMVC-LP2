package Visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.Cliente;
import Modelo.loja;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class telaCadastroLoja extends JFrame {

	private JPanel contentPane;
	private JTextField tfNomeLoja;
	private JTextField tfCidade;
	private JTextField tfTel;

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
		
		tfNomeLoja = new JTextField();
		tfNomeLoja.setBounds(105, 55, 114, 19);
		contentPane.add(tfNomeLoja);
		tfNomeLoja.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(12, 106, 70, 15);
		contentPane.add(lblCidade);
		
		tfCidade = new JTextField();
		tfCidade.setBounds(105, 104, 114, 19);
		contentPane.add(tfCidade);
		tfCidade.setColumns(10);
		
		JLabel lblTel = new JLabel("Tel:");
		lblTel.setBounds(12, 155, 70, 15);
		contentPane.add(lblTel);
		
		tfTel = new JTextField();
		tfTel.setBounds(105, 153, 114, 19);
		contentPane.add(tfTel);
		tfTel.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				loja lj = new loja();//posso criar um objeto do modelo na view? 
				lj.setCidade(tfCidade.getText());
				lj.setNomeFilial(tfNomeLoja.getText());
				lj.setTel(tfTel.getText());
				
				Cliente clienteCadastra = new Cliente(lj);
				Thread thClient = new Thread(clienteCadastra);
				thClient.start();
				
			}
		});
		btnSalvar.setBounds(150, 224, 117, 25);
		contentPane.add(btnSalvar);
	}

}
