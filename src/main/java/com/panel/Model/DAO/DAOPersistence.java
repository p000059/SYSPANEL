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
    
    private String namePerson;
    private String status;

    private IValidator iValidator = new ValidatorException();
    
    private Person objPerson = new Person();
    
    public DAOPersistence(){}
    
    public DAOPersistence(String namePerson, String status){
        this.namePerson = namePerson;
        this.status = status;
        
    }
    
    @ResponseBody
    public Person validateObj(String namePerson, String status){
        
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
        
        return objPerson;
    }
    
    public void validateStatus(){
    }
    
    public void generalValidate(){
    }
}
