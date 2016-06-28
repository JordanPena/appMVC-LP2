package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Controle.conexaoMySQL;

public class veiculoDAO {
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	private final String SELECT=" SELECT * FROM veiculo";
	private final String UPDATE=" UPDATE veiculo SET MODELO=?, LOJA=?, ANO=? WHERE ID=? ";
	private final String DELETE=" DELETE FROM veiculo WHERE ID=? ";

	public void inserir(veiculo carro){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement("INSERT INTO veiculo(modelo, loja, ano)VALUES(? , ?, ?)");
			pstm.setString(1, carro.getModelo());
			pstm.setString(2, carro.getLoja().getName());
			pstm.setString(3, carro.getAno());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}

	public void atualizar(veiculo carro){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement(UPDATE);
			pstm.setString(1, carro.getModelo());
			pstm.setString(2, carro.getLoja().getName());
			pstm.setString(3, carro.getAno());
						
			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}

	public void excluir(veiculo carro){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement(DELETE);
			pstm.setLong(1, carro.getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}

}
