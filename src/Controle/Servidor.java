package Controle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

//import Modelo.Pessoa;

public class Servidor implements Runnable{
	private Socket conexao;
	private Thread t;
	//private controlePessoa control;
	//private Pessoa pessoa;
	ServerSocket s = null;

	public void run(){

		try{
			s = new ServerSocket(9999);
			System.out.println("servidor aguardando..");

			while(true){
				conexao = s.accept();
				System.out.println("Nova conexão");

				
				/*ObjectInputStream inobj =  new ObjectInputStream (conexao.getInputStream());
				Pessoa p = (Pessoa) inobj.readObject();	
				System.out.println(p);
				control = new controlePessoa();
				control.salvar(p); */
				
				
			}
		}catch(IOException e){
			System.out.println("IOException "+e);
		}
	}


}
