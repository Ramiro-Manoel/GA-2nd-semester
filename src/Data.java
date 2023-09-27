import java.io.Serializable;
import java.util.InputMismatchException;

public class Data implements Serializable{
	private int dia, mes, ano;

	public Data() {}
			
	public Data(int dia, int mes, int ano) throws DataException {
		try {
			
			if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
				throw new DataException();
			}

			if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
				if (dia >= 31) {
					throw new DataException();
				}
			}

			if (mes == 2) {
				if (dia > 28 && (ano % 4) != 0) {
					throw new DataException();
				}
			}
				this.dia = dia;
				this.mes = mes;
				this.ano = ano;
		}
		
		catch (DataException c) {
			System.out.println(c + "\nData setada como valor default (01/01/2000)");
			this.dia = 1;
			this.mes = 1;
			this.ano = 2000;
		}
	

	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		if(dia < 10 && mes >=10) {
			return "0" + dia + "/" + mes + "/" + ano;
		}
		if(dia >= 10 && mes < 10) {
			return dia + "/" + "0" + mes + "/" + ano;
		}
		if(dia < 10 && mes < 10) {
			return "0" + dia + "/" + "0" + mes + "/" + ano;
		}
		return dia+"/"+mes+"/"+ano;
	}
	
	
	
	
	
	

}
