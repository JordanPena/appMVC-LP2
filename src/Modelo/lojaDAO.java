package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controle.conexaoMySQL;

public class lojaDAO {
	
	private Connection conn;
	private PreparedStatement pstm;
	private ResultSet rs;

	private final String SELECT=" SELECT * FROM loja";
	private final String UPDATE=" UPDATE loja SET NOMEFILIAL=?, CIDADE=?, TEL=? WHERE ID=? ";
	private final String DELETE=" DELETE FROM LOJA WHERE ID=? ";

	public List listarLojas(){
		List<loja> lojas =new ArrayList();
		loja lj=null;
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement(SELECT);
			rs=pstm.executeQuery();

			while(rs.next()){
				lj=new loja();
				lj.setNomeFilial(rs.getString("nomeFilial"));
				lj.setCidade(rs.getString("cidade"));

				lojas.add(lj);
			}

		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}

		return lojas;
	}

	public void inserir(loja lj){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement("INSERT INTO loja(nomefilial, cidade, tel)VALUES(? , ?, ?)");
			pstm.setString(1, lj.getNomeFilial());
			pstm.setString(2, lj.getCidade());
			pstm.setString(3, lj.getTel());
			
			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}

	public void atualizar(loja lj){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement(UPDATE);
			pstm.setString(1, lj.getNomeFilial());
			pstm.setString(2, lj.getCidade());
			pstm.setString(3, lj.getTel());
						
			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}

	public void excluir(loja lj){
		try {
			conn=conexaoMySQL.getConexaoMySQL();
			pstm=conn.prepareStatement(DELETE);
			pstm.setLong(1, lj.getId());

			pstm.executeUpdate();
		} catch (Exception e) {
			System.err.println("Ocorreu um erro, causa:"+e.getMessage());
			e.printStackTrace();
		}finally{
			conexaoMySQL.FecharConexao();
		}
	}
}