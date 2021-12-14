package br.com.panel.Models.ValidatorClass;
import br.com.panel.Models.Interface.IValidator;
import javax.xml.bind.ValidationException;

public class ValidatorName implements IValidator<String>{

    private String msg = "Erro de preenchimento!";
    
    @Override
    public void valida(String name) throws ValidationException {
        
        if(name == null){            
            throw new RuntimeException(msg);
        }
        
        if(name.isEmpty()){
            throw new RuntimeException(msg);
        }
        
        if(name.trim().isEmpty()){
            throw new RuntimeException(msg);
        }
    }
}
