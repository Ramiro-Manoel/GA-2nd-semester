import java.io.Serializable;
import java.util.Arrays;

public class Shopping implements Serializable{
	
	private String nome;
	private Endereco endereco;
	private Loja[] lojas;

	public Shopping() {}
	
	public Shopping(String nome, Endereco endereco, int tam) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.lojas = new Loja[tam];
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Loja[] getLojas() {
		return lojas;
	}

	public void setLojas(Loja[] lojas) {
		this.lojas = lojas;
	}

	
	public void exibeDados() {
		System.out.println(toString());
		exibeLojas();
	}
	
	@Override
	public String toString() {
		return "(Shopping) nome: " + nome + "\nendereço: " + endereco;
	}

	public void exibeLojas() {
		System.out.println("lojas:");
		for (int i = 0; i < lojas.length; i++) {
			if(lojas[i] instanceof Vestuario) {
				System.out.println(i + " - " + lojas[i].getNome() + " (Vestuario)");
			}
			if(lojas[i] instanceof Alimentacao) {
				System.out.println(i + " - " + lojas[i].getNome() + " (Alimentacao)");
			}
			if(lojas[i] instanceof Informatica) {
				System.out.println(i + " - " + lojas[i].getNome() + " (Informatica)");
			}
		}
	}
	
	public boolean insereLoja(Loja loja) {
		for (int i = 0; i < lojas.length; i++) {
			if (lojas[i] == null) {
				lojas[i] = loja;
				return true;
			}
		}
		return false;
	}

	public boolean removeLoja(String loja) {
		for (int i = 0; i < lojas.length; i++) {
			if (lojas[i].getNome().equalsIgnoreCase(loja)) {
				lojas[i] = null;
				return true;
			}
		}
		return false;
	}

	public int quantidadeLojasPorTipo(String loja) {
		int quant = 0;
		if (loja.equalsIgnoreCase("Vestuario")) {
			for (int i = 0; i < lojas.length; i++) {
				if (lojas[i] instanceof Vestuario) {
					quant++;
				}
			}
			return quant;
		}

		if (loja.equalsIgnoreCase("Alimentacao")) {
			for (int i = 0; i < lojas.length; i++) {
				if (lojas[i] instanceof Alimentacao) {
					quant++;
				}
			}
			return quant;
		}

		if (loja.equalsIgnoreCase("Informatica")) {
			for (int i = 0; i < lojas.length; i++) {
				if (lojas[i] instanceof Informatica) {
					quant++;
				}
			}
			return quant;
		}
		return -1;
	}

	public Loja lojaSeguroMaisCaro() {
		
		int lojaMaisCara = -1;
		double maior = 0;
		for (int i = 0; i < lojas.length; i++) {
			if (lojas[i] instanceof Informatica) {
				if(((Informatica) lojas[i]).getSeguroEletronicos() > maior) {
				maior = ((Informatica) lojas[i]).getSeguroEletronicos();
				lojaMaisCara = i;
				}
			}
			
		}
		if(lojaMaisCara > -1) {
			return lojas[lojaMaisCara];
		}
		return null;
	}

}
