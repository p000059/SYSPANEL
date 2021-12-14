package br.com.syspanel.Model.Validation;
import br.com.syspanel.Model.Interface.IValidator;
import javax.xml.bind.ValidationException;

public class ValidatorName implements IValidator<String> {

    private String message = "Erro de Preenchimento";
    
    @Override
    public void valida(String namePerson) throws ValidationException {
        
        if(namePerson == null){
            throw new RuntimeException(message);
        }
        
        if(namePerson.isEmpty()){
            throw new RuntimeException(message);
        }
        
        if(namePerson.trim().isEmpty()){
            throw new RuntimeException(message);
        }
    }
    
    
}
