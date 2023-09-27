import java.io.Serializable;

public class Informatica extends Loja implements Serializable{

	private double seguroEletronicos;

	public Informatica() {}
	
	public Informatica(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
			Data dataFundacao, double seguroEletronicos, int tamanho) {
		super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanho);
		this.seguroEletronicos = seguroEletronicos;
	}

	public double getSeguroEletronicos() {
		return seguroEletronicos;
	}

	public void setSeguroEletronicos(double seguroEletronicos) {
		this.seguroEletronicos = seguroEletronicos;
	}

	public void exibeDados() {
		System.out.println("(Informatica) nome: " + super.getNome() + ", quantidade de funcionarios: "
				+ super.getQuantidadeFuncionarios() + ", salario base: R$" + super.getSalarioBaseFuncionario() + "\n"
				+ super.getEndereco()+ "\nData de fundação:" + super.getDataFundacao() + ", seguro dos eletronicos: R$" + seguroEletronicos);
				super.imprimeProdutos();
	}
	
	@Override
	public String toString() {
		return "Informatica [seguroEletronicos=" + seguroEletronicos + ", toString()=" + super.toString() + "]";
	}
	
	
}
