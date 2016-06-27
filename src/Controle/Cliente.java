package Controle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

import Modelo.loja;
import Modelo.veiculo;

//import Modelo.Pessoa;


public class Cliente implements Runnable{
	private Socket con;
	private loja lojaOut;
	private veiculo carroOut;
	
	public Cliente(Object tmp) {
		
		if(tmp.getClass().getName() == "Modelo.loja"){
			this.lojaOut = (loja) tmp;
		}else {
			this.carroOut = (veiculo) tmp;
		}
		
	}

	public void run(){
		try{
			con = new Socket("localhost",9999);
			System.out.println("podemos enviar algo..");

			ObjectOutputStream outobj = new ObjectOutputStream(con.getOutputStream());
			if(lojaOut != null){
				outobj.writeObject(lojaOut);
			}else {
				outobj.writeObject(carroOut);
			}
			
			
			outobj.close();

		}catch(IOException e){
			System.out.println("IOException "+e);
		}

	}


}