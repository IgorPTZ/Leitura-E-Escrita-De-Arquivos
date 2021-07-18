package leitura.escrita.arquivos;

public class Pessoa {
	
	private String nome;
	
	private String email;
	
	private Long idade;
	
	public Pessoa (String nome, String email, Long idade) {
		
		this.nome = nome;
		
		this.email = email;
		
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "[nome=" + nome + ", email=" + email + ", idade=" + idade + "]";
	}
}
