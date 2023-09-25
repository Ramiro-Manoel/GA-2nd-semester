import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static Shopping criaShopping() {

		Scanner sc = new Scanner(System.in);
		Shopping shopping = new Shopping();
		int tam = 0;

		System.out.println("qual o nome do shopping?");
		shopping.setNome(sc.nextLine());
		System.out.println("endereco:");
		shopping.setEndereco(criaEndereco());
		System.out.println("quantas lojas cabem dentro do shopping?");

		do {
			try {
				tam = sc.nextInt();
				shopping.setLojas(new Loja[tam]);
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
			} catch (NegativeArraySizeException e) {
				System.out.println("você digitou um número negativo, por favor digite um número positivo");
			}
			sc.nextLine();
		} while (tam <= 0);

		return shopping;

	}

	public static void criaLoja(Loja loja) throws DataExececao {

		Scanner sc = new Scanner(System.in);

		System.out.println("qual o nome da loja");
		loja.setNome(sc.nextLine());

		System.out.println("qual o a quantidade de funcionarios da loja?");
		int quant = 0;
		do {
			try {
				quant = sc.nextInt();
				loja.setQuantidadeFuncionarios(quant);
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
			}
			sc.nextLine();
		} while (quant == 0);

		System.out.println("qual o salário base dos funcionarios da loja?");
		double salario = 0;
		do {
			try {
				salario = sc.nextInt();
				loja.setSalarioBaseFuncionario(salario);
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
			}
			sc.nextLine();
		} while (salario == 0);

		System.out.println("endereco: ");
		loja.setEndereco(criaEndereco());
		System.out.println("data de fundação:");
		loja.setDataFundacao(criaData());
		System.out.println("digite o tamanho do estoque de produtos que a loja possui");
		int tam = 0;
		do {
			try {
				tam = sc.nextInt();
				loja.setEstoqueProdutos(new Produto[tam]);
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
			} catch (NegativeArraySizeException e) {
				System.out.println("você digitou um número negativo, por favor digite um número positivo");
			}
			sc.nextLine();
		} while (tam <= 0);

	}

	public static Vestuario criaVestuario() throws DataExececao {

		Scanner sc = new Scanner(System.in);

		Vestuario vestuario = new Vestuario();

		criaLoja(vestuario);

		System.out.println("a loja recebe/vende produtos importados?" + "\n1- sim" + "\n2- não");
		int op = 0;
		do {
			try {
				op = sc.nextInt();
				switch (op) {
				case 1:
					vestuario.setProdutosImportados(true);
					break;
				case 2:
					vestuario.setProdutosImportados(false);
					break;
				default:
					System.out.println("opção inválida");
				}
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
				sc.nextLine();
			}
		} while (op != 1 && op != 2);

		return (Vestuario) vestuario;

	}

	public static Alimentacao criaAlimentacao() throws DataExececao {

		Scanner sc = new Scanner(System.in);
		Alimentacao alimentacao = new Alimentacao();
		criaLoja(alimentacao);

		System.out.println("digite a data de alvará:");
		alimentacao.setDataAlvara(criaData());

		return alimentacao;
	}

	public static Informatica criaInformatica() throws DataExececao {

		Scanner sc = new Scanner(System.in);
		Informatica informatica = new Informatica();
		criaLoja(informatica);

		System.out.println("qual o seguro dos produtos eletronicos?");

		double seguro = 0;
		do {
			try {
				seguro = sc.nextInt();
				informatica.setSeguroEletronicos(seguro);

			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite um número");
				sc.nextLine();
			}
		} while (seguro == 0);

		return informatica;

	}

	public static Endereco criaEndereco() {

		Scanner sc = new Scanner(System.in);

		Endereco endereco = new Endereco();

		System.out.println("qual o nome da rua?");
		endereco.setNomeDaRua(sc.nextLine());
		System.out.println("qual a cidade?");
		endereco.setCidade(sc.nextLine());
		System.out.println("qual o estado?");
		endereco.setEstado(sc.nextLine());
		System.out.println("qual o pais?");
		endereco.setPais(sc.nextLine());
		System.out.println("qual o cep?");
		endereco.setCep(sc.nextLine());
		System.out.println("qual o numero?");
		endereco.setNumero(sc.nextLine());
		System.out.println("qual o complemento?");
		endereco.setComplemento(sc.nextLine());

		return endereco;
	}

	public static Data criaData() throws DataExececao {

		Scanner sc = new Scanner(System.in);

		int dia = 0;
		int mes = 0;
		int ano = 0;
		do {
			try {
				System.out.println("digite o dia:");
				dia = sc.nextInt();
				System.out.println("digite o mes:");
				mes = sc.nextInt();
				System.out.println("digite o ano:");
				ano = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite apenas números");
			}
			sc.nextLine();
		} while (dia == 0 || mes == 0 || ano == 0);

		return new Data(dia, mes, ano);

	}

	public static void main(String[] args) throws DataExececao {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Shopping shopping = new Shopping();
		int op = 0;

		do {
			System.out.println("------------MENU-----------" + "\n1- criar um Shopping" + "\n2- criar uma loja"
					+ "\n3- criar Produtos para a Loja" + "\n4- remover um Produto" + "\n5- remover uma Loja"
					+ "\n6- verificar vencimento de Produto" + "\n7- imprimir quantidade de Lojas por tipo"
					+ "\n8- imprimir Loja com seguro mais caro"
					+ "\n9- imprimir dados de uma Loja específica informada pelo usuário incluindo Produtos"
					+ "\n10- imprimir dados do Shopping"
					+ "\n11- imprimir os gastos com salário de uma Loja específica informada pelo usuário" + "\n0- sair"
					+ "\n---DIGITE A OPÇÃO DESEJADA---");

			op = sc.nextInt();

			switch (op) {
			case 1:
				shopping = criaShopping();
				break;
			case 2:

				op = 0;
				do {
					System.out.println("qual o tipo da loja que deseja criar?:" + "\n1- vestuario" + "\n2- alimentação"
							+ "\n3- informatica" + "\n0- sair");

					op = sc.nextInt();

					switch (op) {
					case 1:
						Vestuario vestuario = criaVestuario();
						System.out.println(vestuario);
						break;
					case 2:
						Alimentacao alimentacao = criaAlimentacao();
						System.out.println(alimentacao);
						break;
					case 3:
						Informatica informatica = criaInformatica();
						System.out.println(informatica);
						break;
					case 0:
						break;
					default:
						System.out.println("opção inválida");
						break;
					}
				} while (op != 0);
			op =  -1;
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				
				System.out.println("Lojas:");
				for(int i = 0; i < shopping.getLojas().length; i++) {
					System.out.println((i + 1) + " - " + shopping.getLojas()[i]);
				}
				System.out.println("digite o nome da loja que deseja remover");
				if(shopping.removeLoja(sc.nextLine())) {
					System.out.println("loja removida com sucesso");
				} else {
					System.out.println("loja informada não encontrada, nenhuma loja foi removida");
				}
				break;
			case 6:
				break;
			case 7:
				if (shopping.getNome() != null) {
					System.out.println("Digite o tipo de loja que deseja ver a quantidade");
					System.out.println("existem " + shopping.quantidadeLojasPorTipo(sc.nextLine()) + " lojas desse tipo");
				} else {
					System.out.println("o shopping ainda não foi criado");
				}
				break;
			case 8:
				if (shopping.getNome() != null) {
				System.out.println("a loja com o seguro mais alto é a " + shopping.lojaSeguroMaisCaro().getNome());
				} else {
					System.out.println("o shopping ainda não foi criado");
				}
				break;
			case 9:
				break;
			case 10:
				break;
			case 11:
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida! digite um número com dentre as opções");
				break;
			}
		} while (op != 0);

	}

}
