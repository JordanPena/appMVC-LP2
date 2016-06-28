package Controle;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import Modelo.loja;
import Modelo.lojaDAO;

public class controleLoja {
	private lojaDAO  ljDAO = new lojaDAO();
	private loja lj = new loja();
	private loja exibelj;



	public void salvarDAO(loja lj){
		
		this.lj.setNomeFilial(lj.getNomeFilial());
		this.lj.setCidade(lj.getCidade());
		this.lj.setTel(lj.getTel());
		ljDAO.inserir(this.lj);
		
	}


	public List getLojas(){

		return ljDAO.listarLojas();

	}

	public String getNome(){

		return lj.getNomeFilial();
	}


	public String pesquisar(String strg) {
		int sizeList = getLojas().size();

		List<loja> listaBD = getLojas();

		for(int i=0;i<sizeList;i++){			
			exibelj = listaBD.get(i);
			if(exibelj.getNomeFilial() == strg){

				return exibelj.getNomeFilial();
			}else{
				return null;
			}
		}
		return exibelj.getNomeFilial();
	}


}
