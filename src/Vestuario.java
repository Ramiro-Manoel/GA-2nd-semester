import java.io.Serializable;

public class Vestuario extends Loja implements Serializable{

	private boolean produtosImportados;

	public Vestuario() {
	}

	public Vestuario(String nome, int quantidadeFuncionarios, double salarioBaseFuncionario, Endereco endereco,
			Data dataFundacao, boolean produtosImportados, int tamanho) {
		super(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, tamanho);
		this.produtosImportados = produtosImportados;
	}

	public boolean isProdutosImportados() {
		return produtosImportados;
	}

	public void setProdutosImportados(boolean produtosImportados) {
		this.produtosImportados = produtosImportados;
	}
	
	public void exibeDados() {
		System.out.println("(Vestuario) nome: " + super.getNome() + ", quantidade de funcionarios: "
				+ super.getQuantidadeFuncionarios() + ", salario base: R$" + super.getSalarioBaseFuncionario() + "\n"
				+ super.getEndereco()+ "\nData de fundação:" + super.getDataFundacao() + ", produtos importados: " + produtosImportados);
				super.imprimeProdutos();
	}
	
	@Override
	public String toString() {
		return "(Vestuario) nome: " + super.getNome() + ", quantidade de funcionarios: "
				+ super.getQuantidadeFuncionarios() + ", salario base: R$" + super.getSalarioBaseFuncionario() + "\n"
				+ super.getEndereco()+ "\nData de fundação:" + super.getDataFundacao() ;
	}

}
