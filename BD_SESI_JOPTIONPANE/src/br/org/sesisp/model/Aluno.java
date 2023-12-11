 package br.org.sesisp.model;

public class Aluno {
	//atributos
	private int ra;
	private String nome;
	private int idade;
		
	public Aluno(int ra, String nome, int idade) {
		super();
		this.setRa(ra);
		this.setNome(nome);
		this.setIdade(idade);
	}

	public Aluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
	
}
