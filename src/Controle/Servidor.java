package Controle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Modelo.loja;
import Modelo.veiculo;

//import Modelo.Pessoa;

public class Servidor implements Runnable{
	private Socket conexao;
	private Thread t;
	private loja lj = new loja();
	private veiculo carro = new veiculo();
	
	ServerSocket s = null;

	public void run(){

		try{
			s = new ServerSocket(9999);
			System.out.println("servidor aguardando..");

			while(true){
				conexao = s.accept();
				System.out.println("Nova conexão");


				ObjectInputStream inobj =  new ObjectInputStream (conexao.getInputStream());
				Object tmp = inobj.readObject();
				System.out.println(tmp);
				String varIn = tmp.getClass().getName();
				System.out.println(varIn);
				
				if(varIn == "Modelo.loja"){
					System.out.println("entei"+ this.lj);
					this.lj = (loja) tmp;
					controleLoja ctlj = new controleLoja();
					ctlj.salvarDAO(this.lj);
					System.out.println("chamei o ctl!"+ this.lj);
					
				}else if(varIn == "Modelo.veiculo"){
					
					this.carro = (veiculo) tmp;
					controleVeiculo ctlcarro = new controleVeiculo();
					ctlcarro.salvar(this.carro);				
				}
				
			}
		}catch(IOException e){
			System.out.println("IOException "+e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
