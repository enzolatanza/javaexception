package model.exceptions;
//Classe de exceção 
//extends RuntimeException o compilador não obriga a tratar a exceção
//extends Exception o compilador obriga a tratar a exceção
public class DomainException extends Exception{
	//Exception é do tipo Serializable assim tem que adicionar o padrão de versão 1L
	private static final long serialVersionUID = 1L;
	public DomainException(String msg) {
		super(msg);
	}
}
