package br.com.syspanel.Model.Interface;
import javax.xml.bind.ValidationException;

public interface IValidator<T> {
    
    void valida(T object) throws ValidationException;
}
