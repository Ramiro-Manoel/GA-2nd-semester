
public class Produto {
	private String nome;
	private double preco;
	private Data dataval;
	
	public Produto() {

	}
	
	public Produto(String nome, double preco, Data dataval) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.dataval = dataval;
	}
	
	public Data getDataval() {
		return dataval;
	}

	public void setDataval(Data dataval) {
		this.dataval = dataval;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", preco=" + preco + ", dataval=" + dataval + "]";
	}
	
	public boolean estaVencido(Data data) {
		if (data.getAno() > dataval.getAno()) {
			return true;
		}
		if (data.getAno() == dataval.getAno() && data.getMes() > dataval.getMes()) {
			return true;
		}
		if(data.getAno() == dataval.getAno() && data.getMes() == dataval.getMes() && data.getDia() > dataval.getDia()) {
			return true;
		}
		
			return false;
	}
	
	
}
