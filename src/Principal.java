import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static Shopping criaShopping() {

		Scanner sc = new Scanner(System.in);
		Shopping shopping = new Shopping();
		int tam = -1;

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
		} while (tam < 0);

		return shopping;

	}

	public static void criaLoja(Loja loja) throws DataException {

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

	public static Vestuario criaVestuario(Shopping shopping) throws DataException {

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

	public static Alimentacao criaAlimentacao(Shopping shopping) throws DataException {

		Scanner sc = new Scanner(System.in);
		Alimentacao alimentacao = new Alimentacao();
		criaLoja(alimentacao);

		System.out.println("digite a data de alvará:");
		alimentacao.setDataAlvara(criaData());

		return alimentacao;
	}

	public static Informatica criaInformatica(Shopping shopping) throws DataException {

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

	public static Produto criaProduto() throws DataException {
		Scanner sc = new Scanner(System.in);

		System.out.println("digite o nome do produto");
		String nome = sc.nextLine();

		double preco = 0;
		do {
			try {
				System.out.println("digite o preço do produto:");
				preco = sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite apenas números");
			}
		} while (preco == 0);

		System.out.println("Data de validade");
		return new Produto(nome, preco, criaData());
	}

	public static int selecionaLoja(Shopping shopping, String mensagem) {
		Scanner sc = new Scanner(System.in);

		System.out.println(mensagem + "/n");
		shopping.exibeLojas();

		int retorno = -1;

		do {
			try {
				retorno = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("você digitou um caractere inválido, por favor digite apenas números");
			}
			sc.nextLine();
		} while (retorno == -1);

		return retorno;
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

	public static Data criaData() throws DataException {

		Scanner sc = new Scanner(System.in);

		int dia = -1;
		int mes = -1;
		int ano = -1;
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
		} while (dia == -1 || mes == -1 || ano == -1);

		return new Data(dia, mes, ano);

	}

	public static void MenuLojas(Shopping shopping) throws DataException {

		Scanner sc = new Scanner(System.in);

		int op = 0;
		do {
			System.out.println("qual o tipo da loja que deseja criar?:" + "\n1- vestuario" + "\n2- alimentação"
					+ "\n3- informatica" + "\n0- sair");

			op = sc.nextInt();

			switch (op) {
			case 1:
				if (shopping.insereLoja(criaVestuario(shopping)) == false) {
					System.out.println("O shopping não suporta mais lojas, tente novamente quando novas vagas abrirem");
				}
				break;
			case 2:
				if (shopping.insereLoja(criaAlimentacao(shopping)) == false) {
					System.out.println("O shopping não suporta mais lojas, tente novamente quando novas vagas abrirem");
				}
				break;
			case 3:
				if (shopping.insereLoja(criaInformatica(shopping)) == false) {
					System.out.println("O shopping não suporta mais lojas, tente novamente quando novas vagas abrirem");
				}
				break;
			case 0:
				break;
			default:
				System.out.println("opção inválida");
				break;
			}
		} while (op != 0);

	}

	public static void main(String[] args) throws DataException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Shopping shopping = new Shopping();
		int indexLoja = 0;
		int op = 0;

		do {
			System.out.println("------------MENU-----------" + "\n1- criar um Shopping" + "\n2- criar uma loja"
					+ "\n3- criar Produtos para a Loja" + "\n4- remover um Produto" + "\n5- remover uma Loja"
					+ "\n6- verificar vencimento de Produto" + "\n7- imprimir quantidade de Lojas por tipo"
					+ "\n8- imprimir Loja com seguro mais caro"
					+ "\n9- imprimir dados de uma Loja específica informada pelo usuário incluindo Produtos"
					+ "\n10- imprimir dados do Shopping"
					+ "\n11- imprimir os gastos com salário de uma Loja específica informada pelo usuário"
					+ "\n12- gravar objetos em arquivo local" + "\n13- ler objetos de arquivo local" + "\n0- sair"
					+ "\n---DIGITE A OPÇÃO DESEJADA---");

			op = sc.nextInt();

			switch (op) {
			case 1:
				shopping = criaShopping();
				break;
			case 2:

				if (shopping.getLojas() != null) {
					MenuLojas(shopping);
				} else {
					System.out.println("O shopping ainda não existe, crie-o primeiro");
				}

				break;
			case 3:
				if (shopping.getLojas() != null) {
					indexLoja = selecionaLoja(shopping, "digite o numero da loja que deseja adicionar o produto:");
					shopping.getLojas()[indexLoja].insereProduto(criaProduto());
				} else {
					System.out.println("o shopping ainda não foi criado");
				}
				break;
			case 4:
				try {
					indexLoja = selecionaLoja(shopping, "digite o numero da loja que deseja remover o produto:");
					shopping.getLojas()[indexLoja].imprimeProdutos();
					System.out.println("\ndigite o nome do produto que deseja remover");
					sc.nextLine();
					if (shopping.getLojas()[indexLoja].removeProduto(sc.nextLine())) {
						System.out.println("produto removido com sucesso");
					} else {
						System.out.println("produto não encontrado, nada foi removido");
					}
				} catch (Exception e) {
					System.out.println("opção inválida (não possui produtos na loja ou digitou loja não válida");
				}
				break;
			case 5:
				try {
					shopping.exibeLojas();
					System.out.println("digite o nome da loja que deseja remover");
					sc.nextLine();
					if (shopping.removeLoja(sc.nextLine())) {
						System.out.println("loja removida com sucesso");
					} else {
						System.out.println("loja informada não encontrada, nenhuma loja foi removida");
					}
				} catch (Exception e) {
					System.out.println("o shopping ainda não foi criado");
				}
				break;
			case 6:

				try {
					indexLoja = selecionaLoja(shopping,
							"digite o numero da loja que possui o produto que deseja ver a validade");
					shopping.getLojas()[indexLoja].imprimeProdutos();
					System.out.println("\ndigite o numero do produto que ver a validade");
					sc.nextLine();
					int indexProduto = sc.nextInt();
					System.out.println("digite a data que deseja saber se o produto estará vencido");
					if (shopping.getLojas()[indexLoja].getEstoqueProdutos()[indexProduto].estaVencido(criaData())) {
						System.out.println("o produto está vencido");
					} else {
						System.out.println("o produto não está vencido");
					}

				} catch (Exception e) {
					System.out.println("loja ou produto digitados são inválidos");
				}
				break;
			case 7:
				try {
					System.out.println("Digite o tipo de loja que deseja ver a quantidade");
					sc.nextLine();
					System.out
							.println("existem " + shopping.quantidadeLojasPorTipo(sc.nextLine()) + " lojas desse tipo");
				} catch (Exception e) {
					System.out.println("voce digitou errado");
				}
				break;
			case 8:
				try {
					System.out.println("a loja com o seguro mais alto é a " + shopping.lojaSeguroMaisCaro().getNome() + "(R$"+ ((Informatica) shopping.lojaSeguroMaisCaro()).getSeguroEletronicos() + ")" );
				} catch (Exception e) {
					System.out.println("o shopping ainda não foi criado");
				}
				break;
			case 9:
				try {
					indexLoja = selecionaLoja(shopping, "digite o numero da loja que deseja ver as informações");
					shopping.getLojas()[indexLoja].exibeDados();
				} catch (Exception e) {
					System.out.println("essa loja não existe");
				}

				break;
			case 10:
				try {
					shopping.exibeDados();
				} catch (Exception e) {
					System.out.println("essa o shopping ainda não existe");
				}
				break;
			case 11:
				try {
					indexLoja = selecionaLoja(shopping, "digite o numero da loja que deseja ver os gastos com salario");
					System.out.println("os gastos da loja selecionada com salario são de: R$"
							+ shopping.getLojas()[indexLoja].gastosComSalario());
				} catch (Exception e) {
					System.out.println("essa loja não existe");
				}
				break;
			case 12:
				try {
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("shopping.dat"));
					out.writeObject(shopping);
					out.close();
					System.out.println("objetos gravados nos arquivos locais");
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			case 13:
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream("shopping.dat"));
					shopping = (Shopping) in.readObject();
					in.close();
					System.out.println("objetos restaurados dos arquivos locais ao progama");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 0:
				System.out.println("obrigado por utilizar nosso menu");
				break;
			default:
				System.out.println("Opção inválida! digite um número com dentre as opções");
				break;
			}
		} while (op != 0);

	}

}
