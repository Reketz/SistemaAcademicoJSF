package br.com.jsf.util;

import javax.faces.application.FacesMessage;
import org.primefaces.PrimeFaces;

public class FacesMessageUtil {
    
    public static void success(){
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensagem", "Operação realizada com sucesso!"), true);
    }
    public static void fail(String dynamicMessage){
        PrimeFaces.current().dialog().showMessageDynamic(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Mensagem", dynamicMessage), true);
    }
    
}
