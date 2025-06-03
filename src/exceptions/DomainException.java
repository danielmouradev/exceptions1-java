package exceptions;

/**
 RunTimeException = Não obriga você a tratar a exceção
 Exception = Obriga você a tratar a exceção
 */

public class DomainException extends RuntimeException{

    //Permite instanciar uma exceção passando uma mensagem pra ela
    public DomainException (String mensagem){
        super(mensagem);
    }
}
