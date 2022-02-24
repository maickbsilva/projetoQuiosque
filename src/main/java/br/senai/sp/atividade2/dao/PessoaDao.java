package br.senai.sp.atividade2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.senai.sp.atividade2.model.Pessoa;

public class PessoaDao {
	private Connection conexao;

	public PessoaDao() {
		conexao = ConnectionFactory.conectar();
	}
	
	public void inserir(Pessoa pessoa) {
		
		String sql = "insert into tb_cadastro" + "(nome, endereco, email, genero, celular, nascimento, prodInteresse)" + 
				"value(?,?,?,?,?,?,?)";
		
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEndereco());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getGenero());
			stmt.setString(5, pessoa.getCelular());
			stmt.setDate(6, new Date(pessoa.getNascimento().getTimeInMillis()));
			stmt.setString(7, pessoa.getProdInteresse());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Pessoa> listar(){
		String sql = "select * from tb_cadastro order by id asc";
		PreparedStatement stmt;
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				p.setGenero(rs.getString("genero"));
				p.setCelular(rs.getString("celular"));

				//criar um calendar com a data atual
				Calendar nascimento = Calendar.getInstance();
				//extrair o java.sql.Date do banco de dados
				Date nascDb = rs.getDate("nascimento");
				//passar o long do java.sql.Date para o Calendar
				nascimento.setTimeInMillis(nascDb.getTime());
				// setar o nascimento no jogador
				p.setNascimento(nascimento);
				
				p.setProdInteresse(rs.getString("prodInteresse"));
			
				lista.add(p);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
			
	}
	
	
	public void excluir(long idPessoa) {
		String sql = "delete from tb_cadastro where id = ?";
		
		PreparedStatement stmt;
		
		try {
			
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idPessoa);
			stmt.execute();
			stmt.close();
			conexao.close();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void atualizar(Pessoa pessoa) {
		
		String sql = "update tb_cadastro set nome=?, endereco=?, email=?, genero=?, celular=?, nascimento=?, prodInteresse=? where id=?";
		
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEndereco());
			stmt.setString(3, pessoa.getEmail());
			stmt.setString(4, pessoa.getGenero());
			stmt.setString(5, pessoa.getCelular());
			stmt.setDate(6, new Date(pessoa.getNascimento().getTimeInMillis()));
			stmt.setString(7, pessoa.getProdInteresse());
			stmt.setLong(8, pessoa.getId());
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Pessoa buscar(long idPessoa){
		String sql = "select * from tb_cadastro where id =?";
		PreparedStatement stmt;
		Pessoa p = null;
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idPessoa);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				p.setGenero(rs.getString("genero"));
				p.setCelular(rs.getString("celular"));
				p.setProdInteresse(rs.getString("prodInteresse"));
				
				//criar um calendar com a data atual
				Calendar nascimento = Calendar.getInstance();
				//extrair o java.sql.Date do banco de dados
				Date nascDb = rs.getDate("nascimento");
				//passar o long do java.sql.Date para o Calendar
				nascimento.setTimeInMillis(nascDb.getTime());
				// setar o nascimento no jogador
				p.setNascimento(nascimento);
				
			}
			rs.close();
			stmt.close();
			conexao.close();
			return p;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
			
	}
	
	public List<Pessoa> filtroGenero(){
		String sql = "select * from tb_cadastro order by genero asc";
		PreparedStatement stmt;
		
		List<Pessoa> lista = new ArrayList<Pessoa>();
		
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getLong("id"));
				p.setNome(rs.getString("nome"));
				p.setEndereco(rs.getString("endereco"));
				p.setEmail(rs.getString("email"));
				p.setGenero(rs.getString("genero"));
				p.setCelular(rs.getString("celular"));

				//criar um calendar com a data atual
				Calendar nascimento = Calendar.getInstance();
				//extrair o java.sql.Date do banco de dados
				Date nascDb = rs.getDate("nascimento");
				//passar o long do java.sql.Date para o Calendar
				nascimento.setTimeInMillis(nascDb.getTime());
				// setar o nascimento no jogador
				p.setNascimento(nascimento);
				
				p.setProdInteresse(rs.getString("prodInteresse"));
			
				lista.add(p);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
			
	}
	
	public int estatisticaGenero(String genero){
		int qtd = 0;
		String sql = "select COUNT(genero) from tb_cadastro where genero = ? ";
		PreparedStatement stmt;
		
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, genero);
			ResultSet rs = stmt.executeQuery();

			if(rs.next()) {
				qtd = rs.getInt(1);	
			}
			
			rs.close();
			stmt.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return qtd;
			
	}
	
	public List<Pessoa> idades() {
		
		String sql = "select nascimento from tb_cadastro";
		PreparedStatement stmt;
		
		List<Pessoa> lista = new ArrayList<Pessoa>();

		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			
			while(rs.next()) {
				Pessoa p = new Pessoa();

				//criar um calendar com a data atual
				Calendar nascimento = Calendar.getInstance();
				//extrair o java.sql.Date do banco de dados
				Date nascDb = rs.getDate("nascimento");
				//passar o long do java.sql.Date para o Calendar
				nascimento.setTimeInMillis(nascDb.getTime());
				// setar o nascimento no jogador
				p.setNascimento(nascimento);
							
				lista.add(p);
			}
			
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
			
			
		} catch (SQLException e) {
			throw new RuntimeException();
		}


		
	}
	
}



