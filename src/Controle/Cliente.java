package Controle;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;

//import Modelo.Pessoa;


public class Cliente implements Runnable{
	private Socket con;
	//private Pessoa pessoaSalvar;
	
	public void run(){
		try{
			con = new Socket("localhost",9999);
			System.out.println("podemos enviar algo..");

			/*ObjectOutputStream outobj = new ObjectOutputStream(con.getOutputStream());
			outobj.writeObject(pessoaSalvar);
			outobj.close();*/

		}catch(IOException e){
			System.out.println("IOException "+e);
		}

	}


}