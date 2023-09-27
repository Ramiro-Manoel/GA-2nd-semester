import java.io.Serializable;

public class DataException extends Exception implements Serializable{
	
	
	public String getMessage() {
		return "data invalida";
	}
}
