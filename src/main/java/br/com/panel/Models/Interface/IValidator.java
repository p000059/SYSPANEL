package br.com.panel.Models.Interface;
import javax.xml.bind.ValidationException;

public interface IValidator<T> {
    
    void valida(T object) throws ValidationException;
}
