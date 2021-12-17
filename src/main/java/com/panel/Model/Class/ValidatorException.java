package com.panel.Model.Class;

import com.panel.Model.Interface.IValidator;

public class ValidatorException implements IValidator{

    @Override
    public boolean validate(String string) {
        if(string.equals("")){
            return false;
        }
         if(string.isEmpty()){
            return false;
        }
        
        if(string.trim().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public String validateError() {
       return "Verificar o preenchimento de campo!";
    }
}
