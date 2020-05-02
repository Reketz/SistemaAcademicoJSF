package br.com.jsf.expection;

public class ErroSystem extends Exception{

    public ErroSystem(String string) {
        super(string);
    }

    public ErroSystem(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }
    
}
