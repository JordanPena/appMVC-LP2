package Visao;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controle.Cliente;
import Controle.controleLoja;
import Modelo.loja;
import Modelo.veiculo;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCadastroCarro extends JFrame {

	private JPanel contentPane;
	private JTextField tfModelo;
	private JTextField tfAno;
	private JComboBox comboBoxlj = new JComboBox();

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
		
		
		comboBoxlj.setBounds(90, 98, 122, 24);
		contentPane.add(comboBoxlj);
		this.preencheCbx();
		
		tfModelo = new JTextField();
		tfModelo.setBounds(94, 41, 114, 19);
		contentPane.add(tfModelo);
		tfModelo.setColumns(10);
		
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
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				veiculo carro = new veiculo();
				carro.setModelo(tfModelo.getText());
				carro.setAno(tfAno.getText());
				carro.setLoja(comboBoxlj.getSelectedItem());
				Object tmp = carro;
				
				Cliente clienteCadastra = new Cliente(tmp);
				Thread thClient = new Thread(clienteCadastra);
				thClient.start();
							
				
			}
		});
		btnOk.setBounds(161, 263, 117, 25);
		contentPane.add(btnOk);
		
		tfAno = new JTextField();
		tfAno.setBounds(94, 170, 114, 19);
		contentPane.add(tfAno);
		tfAno.setColumns(10);
		


	}
	private void preencheCbx() {
		controleLoja controlelj = new controleLoja();
		int sizeList = controlelj.getLojas().size();
		List<loja> listaCombo = controlelj.getLojas();

		for(int i=1;i<sizeList;i++){			
			loja exibelj = listaCombo.get(i);
			comboBoxlj.addItem(exibelj.getNomeFilial());
		}
	}

}
