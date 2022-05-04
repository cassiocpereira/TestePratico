import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa implements Comparable<Funcionario> {
	// 2 – Classe Funcionário que estenda a classe Pessoa, com os atributos: salário
	// (BigDecimal) e função (String).

	BigDecimal salario;
	String funcao;

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
		super(nome, dataNascimento);
		this.salario = salario;
		this.funcao = funcao;
	}

	public Funcionario() {
		super();
	}

	@Override
	public String toString() {
		return "Funcionario [Nome= " + nome + ", Data de Nascimento= "
				+ dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " Salário= "
				+ String.format("%,.2f", salario) + ", Função= " + funcao + " ]";
	}

	@Override
	public int compareTo(Funcionario o) {
		return this.getNome().compareToIgnoreCase(o.getNome());
	}

}
