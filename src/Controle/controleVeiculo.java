package Controle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.veiculo;

public class controleVeiculo {
	private veiculo carro = new veiculo();
	

	public void salvar(veiculo carro) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();
		etx.begin();

		this.carro.setModelo(carro.getModelo());
		this.carro.setAno(carro.getAno());
		this.carro.setLoja(carro.getLoja());

		em.persist(this.carro);

		etx.commit();

	}

}
