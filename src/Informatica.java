
public class Informatica extends Loja {

	private double seguroEletronicos;

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

	@Override
	public String toString() {
		return "Informatica [seguroEletronicos=" + seguroEletronicos + ", toString()=" + super.toString() + "]";
	}
	
	
}
