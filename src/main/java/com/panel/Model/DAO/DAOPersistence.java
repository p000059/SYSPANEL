package com.panel.Model.DAO;
import com.panel.Model.Class.Person;
import com.panel.Model.Class.ValidatorException;
import com.panel.Model.Interface.IRepository;
import com.panel.Model.Interface.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.ResponseBody;

public class DAOPersistence {
    
    @Autowired
    private IRepository iRepository;
    
    
    private IValidator iValidator = new ValidatorException();
    
    private Person objPerson = new Person();
    
    public Person validatePerson(Person objPerson, String namePerson, String status, String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput){
        
            objPerson.setNamePerson(namePerson);
            objPerson.setStatus(status);
            objPerson.setLocal(local);
            objPerson.setExpectedStart(expectedStart);
            objPerson.setStartSurgery(startSurgery);
            objPerson.setEndSurgery(endSurgery);
            objPerson.setExpectedOutput(expectedOutput);
            
            return objPerson;
    }
    
    public Person validateObj(String namePerson, String status, String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput){
        
        if(iValidator.validate(namePerson)){
            objPerson.setNamePerson(namePerson);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());
        }
        if(iValidator.validate(status)){
            objPerson.setStatus(status);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());
        }
        if(iValidator.validate(local)){
            objPerson.setLocal(local);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());
        }
        if(iValidator.validate(expectedStart)){
            
            objPerson.setExpectedStart(expectedStart);
        }
        else{
        }        
        if(iValidator.validate(startSurgery)){
            
            objPerson.setStartSurgery(startSurgery);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());            
        }
        if(iValidator.validate(endSurgery)){
            
            objPerson.setEndSurgery(endSurgery);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());            
        }
        if(iValidator.validate(expectedOutput)){
            
            objPerson.setExpectedOutput(expectedOutput);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());            
        }
        
        return objPerson;
    }
}
