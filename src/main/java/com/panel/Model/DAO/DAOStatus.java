package com.panel.Model.DAO;
import com.panel.Model.Class.Person;
import com.panel.Model.Interface.IValidator;

public class DAOStatus {

    private String status;
    private IValidator iValidator;
    private Person objPerson = new Person();
    
    public DAOStatus(String status){
        this.status = status;
    }
    
    public void validaObjStatus(){
        
        if(iValidator.validate(this.status)){
            objPerson.setStatus(this.status);
        }
        else{
            throw new IllegalArgumentException(iValidator.validateError());
        }
    }
}
