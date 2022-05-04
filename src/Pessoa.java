import java.time.LocalDate;



public class Pessoa {
	//1– Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).
	String nome;
	LocalDate dataNascimento;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Pessoa(String nome, LocalDate dataNascimento) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
	}
	public Pessoa() {
	}
	
}
