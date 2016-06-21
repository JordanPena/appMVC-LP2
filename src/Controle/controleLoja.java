package Controle;


import java.util.List;

import Modelo.loja;
import Modelo.lojaDAO;

public class controleLoja {
	private lojaDAO  ljDAO = new lojaDAO();
	private loja lj = new loja();
	private loja exibelj;

	public void salvar(String filial, String cidade) {
				
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
