package Controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.veiculo;
import Modelo.veiculoDAO;

public class controleVeiculo {
	private veiculo carro = new veiculo();
	private veiculoDAO carroDAO = new veiculoDAO();
	

	public void salvarDAO(veiculo carro) {

		this.carro.setModelo(carro.getModelo());
		this.carro.setLoja(carro.getLoja());
		this.carro.setAno(carro.getAno());
		carroDAO.inserir(this.carro);
				
	}
	

}
