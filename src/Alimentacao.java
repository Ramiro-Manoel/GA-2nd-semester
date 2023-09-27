import java.io.Serializable;

public class Alimentacao extends Loja implements Serializable{
	
	private Data dataAlvara;

	public Alimentacao(){}
	
	public Alimentacao(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
			Data dataFundacao, Data dataAlvara, int tamanho) {
		super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanho);
		this.dataAlvara = dataAlvara;
	}

	public Data getDataAlvara() {
		return dataAlvara;
	}

	public void setDataAlvara(Data dataAlvara) {
		this.dataAlvara = dataAlvara;
	}
	
	public void exibeDados() {
		System.out.println("(Alimentacao) nome: " + super.getNome() + ", quantidade de funcionarios: "
				+ super.getQuantidadeFuncionarios() + ", salario base: R$" + super.getSalarioBaseFuncionario() + "\n"
				+ super.getEndereco()+ "\nData de fundação:" + super.getDataFundacao() + ", data de alvará: " + dataAlvara.toString());
				super.imprimeProdutos();
	}
	@Override
	public String toString() {
		return "Alimentacao ["+ super.toString() +"dataAlvara=" + dataAlvara + "]";
	}


	
	
}
