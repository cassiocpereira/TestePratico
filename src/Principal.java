import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Principal {
	// 3 � Deve conter uma classe Principal para executar as seguintes a��es:

	public static void main(String[] args) {

		// 3.1 � Inserir todos os funcion�rios, na mesma ordem e informa��es da tabela acima.
		List<Funcionario> listaFuncionarios = carregaListaFuncionarios();

		// 3.2 � Remover o funcion�rio �Jo�o� da lista.
		listaFuncionarios = removeFuncionarioJoao(listaFuncionarios);

		/*
		 * 3.3 � Imprimir todos os funcion�rios com todas suas informa��es, sendo que: �
		 * informa��o de data deve ser exibido no formato dd/mm/aaaa; � informa��o de
		 * valor num�rico deve ser exibida no formatado com separador de milhar como
		 * ponto e decimal como v�rgula.
		 */
		imprimeListafuncionario(listaFuncionarios);

		// 3.4 � Os funcion�rios receberam 10% de aumento de sal�rio, atualizar a lista de funcion�rios com novo valor.
		aplicarAumentoSalario(listaFuncionarios);
		
		//3.5 � Agrupar os funcion�rios por fun��o em um MAP, sendo a chave a �fun��o� e o valor a �lista de funcion�rios�.
		Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = agruparFuncionariosPorFuncao(listaFuncionarios);
		
		//3.6 � Imprimir os funcion�rios, agrupados por fun��o.
		imprimirFuncionariosAgrupadosPorFuncao(funcionariosAgrupadosPorFuncao);
		
		//3.8 � Imprimir os funcion�rios que fazem anivers�rio no m�s 10 e 12.
		imprimirFuncionariosAniversario10e12(listaFuncionarios);
		
		//3.9 � Imprimir o funcion�rio com a maior idade, exibir os atributos: nome e idade.
		imprimirFuncionarioComMaiorIdade(listaFuncionarios);

		//3.10 � Imprimir a lista de funcion�rios por ordem alfab�tica.
		imprimirFuncionariosEmOrdemAlfabetica(listaFuncionarios);
		
		//3.11 � Imprimir o total dos sal�rios dos funcion�rios.
		imprimirTotalSalario(listaFuncionarios);
		
		//3.12 � Imprimir quantos sal�rios m�nimos ganha cada funcion�rio, considerando que o sal�rio m�nimo � R$1212.00.
		imprimirQtdSalariosPorFuncionario(listaFuncionarios);
	}

	private static List<Funcionario> carregaListaFuncionarios() {
		
		System.out.println("### CARREGANDO LISTA DE FUNCIONARIOS ### \n");
		
		List<Funcionario> listaRetorno = new ArrayList<Funcionario>();

		listaRetorno.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18),
				new BigDecimal(2009.44).setScale(2, RoundingMode.HALF_DOWN), "Operador"));
		listaRetorno.add(new Funcionario("Jo�o", LocalDate.of(1990, 5, 12),
				new BigDecimal(2284.38).setScale(2, RoundingMode.HALF_DOWN), "Operador"));
		listaRetorno.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2),
				new BigDecimal(9836.14).setScale(2, RoundingMode.HALF_DOWN), "Coordenador"));
		listaRetorno.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14),
				new BigDecimal(19119.88).setScale(2, RoundingMode.HALF_DOWN), "Diretor"));
		listaRetorno.add(new Funcionario("Alice", LocalDate.of(1995, 1, 05),
				new BigDecimal(2234.68).setScale(2, RoundingMode.HALF_DOWN), "Recepcionista"));
		listaRetorno.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19),
				new BigDecimal(1582.72).setScale(2, RoundingMode.HALF_DOWN), "Operador"));
		listaRetorno.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31),
				new BigDecimal(4071.84).setScale(2, RoundingMode.HALF_DOWN), "Contador"));
		listaRetorno.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8),
				new BigDecimal(3017.45).setScale(2, RoundingMode.HALF_DOWN), "Gerente"));
		listaRetorno.add(new Funcionario("Helo�sa", LocalDate.of(2003, 5, 24),
				new BigDecimal(1606.85).setScale(2, RoundingMode.HALF_DOWN), "Eletricista"));
		listaRetorno.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2),
				new BigDecimal(2799.93).setScale(2, RoundingMode.HALF_DOWN), "Gerente"));

		return listaRetorno;

	}

	private static List<Funcionario> removeFuncionarioJoao(List<Funcionario> funcionarios) {
		
		System.out.println("### REMOVENDO FUNCIONARIO JO�O DA LISTA ### \n");

		Predicate<Funcionario> joao = funcionario -> funcionario.getNome().equals("Jo�o");

		funcionarios.stream().filter(joao).forEach(f -> f.getNome());

		funcionarios.removeIf(joao);

		return funcionarios;

	}

	private static void imprimeListafuncionario(List<Funcionario> lista) {
		System.out.println("### IMPRIMINDO LISTA DE FUNCIONARIOS ###");
		lista.forEach(f -> {
			System.out.println(f.toString());
		});
		System.out.println("\n");
	}

	private static void aplicarAumentoSalario(List<Funcionario> listaFuncionarios) {
		System.out.println("### APLICANDO AUMENTO DE 10% NOS SALARIOS ### \n");
		listaFuncionarios.forEach(f -> {
			BigDecimal aumento = f.getSalario().multiply(new BigDecimal(0.1));
			f.setSalario(f.getSalario().add(aumento));
		});
	}

	private static Map<String, List<Funcionario>> agruparFuncionariosPorFuncao(List<Funcionario> listaFuncionarios) {
		System.out.println("### AGRUPANDO FUNCIONARIOS POR FUN��O ### \n");
		Set<String> funcoes = new TreeSet<>();
		listaFuncionarios.forEach(f -> {
			funcoes.add(f.getFuncao());
		});

		Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao = new HashMap<>();

		funcoes.forEach(fn -> {
			List<Funcionario> listaFuncionarioPorFuncao = new ArrayList<Funcionario>();
			listaFuncionarios.forEach(f -> {
				if (f.getFuncao().equals(fn)) {
					listaFuncionarioPorFuncao.add(f);
				}
			});

			funcionariosAgrupadosPorFuncao.put(fn, listaFuncionarioPorFuncao);

		});

		return funcionariosAgrupadosPorFuncao;
	}
	
	private static void imprimirFuncionariosAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosAgrupadosPorFuncao) {
		System.out.println("### IMPRIMINDO FUNCIONARIOS AGRUPADOS POR FUN��O ###");
		funcionariosAgrupadosPorFuncao.forEach((fn, f) -> System.out.println((fn + ":" + f)));
		System.out.println("\n");
	}
	
	private static void imprimirFuncionariosAniversario10e12(List<Funcionario> listaFuncionarios) {
		System.out.println("### IMPRIMINDO FUNCIONARIOS QUE FAZEM ANIVERS�RIO NOS MESES 10 E 12 ###");
		listaFuncionarios.forEach(f -> {
			if (f.getDataNascimento().getMonth().getValue() == 10
					|| f.getDataNascimento().getMonth().getValue() == 12) {
				System.out.println(f.toString());
			}
		});
		System.out.println("\n");
	}
	
	private static void imprimirFuncionarioComMaiorIdade(List<Funcionario> listaFuncionarios) {
		System.out.println("### IMPRIMINDO FUNCIONARIO COM MAIOR IDADE ###");
		Map<String, Integer> nomeIdadeFuncionario = new HashMap<>();
		listaFuncionarios.forEach(f -> {
			Integer idade = Period.between(f.getDataNascimento(), LocalDate.now()).getYears();
			nomeIdadeFuncionario.put(f.getNome(), idade);
		});
		String nome = Collections.max(nomeIdadeFuncionario.entrySet(), Map.Entry.comparingByValue()).getKey();
		System.out.println("Nome: "+ nome + " Idade: " + nomeIdadeFuncionario.get(nome) +"\n");
	}
	
	private static void imprimirFuncionariosEmOrdemAlfabetica(List<Funcionario> listaFuncionarios) {
		System.out.println("### IMPRIMINDO LISTA DE FUNCIONARIOS EM ORDEM ALFAB�TICA ###");
		List<Funcionario> listaFuncionariosPorOrdemAlfabetica = listaFuncionarios.stream().sorted()
				.collect(Collectors.toList());
		listaFuncionariosPorOrdemAlfabetica.forEach(fa -> System.out.println(fa));
		System.out.println("\n");
	}
	
	private static void imprimirTotalSalario(List<Funcionario> listaFuncionarios) {
		System.out.println("### IMPRIMINDO TOTAL DE SAL�RIOS ###");
		System.out.println(String.format("%,.2f",listaFuncionarios.stream().mapToDouble(s -> s.getSalario().doubleValue()).sum())+"\n");
	}
	
	private static void imprimirQtdSalariosPorFuncionario(List<Funcionario> listaFuncionarios) {
		System.out.println("### IMPRIMINDO QUANTIDADE DE SAL�RIO QUE CADA FUNCION�RIO GANHA ### \n");
		listaFuncionarios.forEach(f -> {
			Double qtdSalarios = f.getSalario().doubleValue() / 1212.00;
			System.out.println(f.getNome() + " ganha " + String.format("%.2f", qtdSalarios) + " sal�rio m�nimos.");
		});
	}
}
