package br.org.sesisp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

import br.org.sesisp.controller.Conexao;
import br.org.sesisp.model.Aluno;


public class crudDAO {
	
	//CRUD
	
	//create inserção de dados
	
	public void create(Aluno aluno) {
		String sql = "INSERT INTO alunos(nome, idade) VALUES (?,?)";
		Connection conn = null;
		PreparedStatement p = null;	
		
		try {
			conn = (Connection) Conexao.criandoconexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setString(1, aluno.getNome());
			p.setInt(2, aluno.getIdade());
			p.execute();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Erro ao inserir dados! \nERRO" + e);
		}finally {
			try {
				if (p != null);
				p.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	
	
	public void update(Aluno aluno) {
		String select_sql = "SELECT COUNT(*) FROM alunos WHERE ra = ?";
		String sql ="UPDATE alunos SET nome = ?, idade = ? WHERE ra = ?";
		Connection conn = null;
		PreparedStatement sl =null;
		PreparedStatement update = null;
		//ResultSet resultado = null;
		
		try {
			conn = (Connection) Conexao.criandoconexao();
			sl = (PreparedStatement) conn.prepareStatement(select_sql);
			
			System.out.println("ate aqui 1" + sl);
			
			sl.setInt(1,aluno.getRa());
			ResultSet resultado = sl.executeQuery();
					
			
				
			if (resultado.next() && resultado.getInt(1) > 0) {
				
				update = (PreparedStatement) conn.prepareStatement(sql);
				System.out.println("ate aqui 2" + update);
								
				update.setString(1, aluno.getNome());
				update.setInt(2, aluno.getIdade());
				update.setInt(3, aluno.getRa());
				System.out.println("ate aqui 4");
				update.execute();
				System.out.println("ate aqui 5");
				System.out.println(aluno.getNome() + " "+ aluno.getIdade());
				
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			System.out.println("dados atualizados com sucesso");
			}else {
				JOptionPane.showMessageDialog(null,  "Erro ao atualizars os dados: \nERRO");
			}
			
			//p.setInt(3,aluno.getRa());
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro ao atualizars os dados: \nERRO"+e);
		}finally {
			try {
				if (update != null) {
				update.close();
			} 
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Aluno> read(){
		String sql = "SELECT * FROM alunos";
		List<Aluno> alunos = new ArrayList<Aluno>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		
		try {
			conn = (Connection) Conexao.criandoconexao();
			p= (PreparedStatement) conn.prepareStatement(sql);
			resultado = p.executeQuery();
			while(resultado.next()) {
				Aluno ver_aluno = new Aluno();
				ver_aluno.setRa(resultado.getInt("ra"));
				ver_aluno.setNome(resultado.getString("nome"));
				ver_aluno.setIdade(resultado.getInt("idade"));
				
				alunos.add(ver_aluno);
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro ao inserir os dados: \nERRO"+e);
		}finally {
			try {
				if (p != null) {
				p.close();
			} 
			}catch (Exception e) {
				e.printStackTrace();
			}
		
		 }
		return alunos;
		
	}
	
	
	
	public boolean delete(int ra) {
		String sql = "DELETE FROM alunos WHERE ra = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = (Connection) Conexao.criandoconexao();
			p= (PreparedStatement) conn.prepareStatement(sql);
			p.setInt(1, ra);
			p.execute();
			JOptionPane.showMessageDialog(null,"dados excluidos com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Erro ao excluir dados: \nERRO"+e);
		} finally {
			try {
				if (p != null) {
				p.close();
			} 
			}catch (Exception e) {
				e.printStackTrace();
			}
		 }
		return false;
	}
	
	
	
	
	
}
	
	
