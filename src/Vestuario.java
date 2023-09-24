
public class Vestuario extends Loja {

	private boolean produtosImportados;

	public Vestuario() {}
	
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

	@Override
	public String toString() {
		return "Vestuario [" + super.toString() +"produtosImportados=" + produtosImportados + "]";
	}

}
