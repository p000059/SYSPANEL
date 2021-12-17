package com.panel.Controller.Person;
import com.panel.Model.Class.Person;
import com.panel.Model.DAO.DAOPersistence;
import com.panel.Model.DAO.DAOStatus;
import com.panel.Model.Interface.IRepository;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/panel")
@CrossOrigin(origins = "*")
public class PersonController {
    
    @Autowired
    private IRepository iRepository;
    
    @GetMapping(path = "/")
    public Optional<Person> loadAllPerson(){
        
        return iRepository.findAll(Sort.by(Sort.Direction.ASC, "idPerson"));
    }
    
    @PostMapping(path = "/")
    public @ResponseBody String createPerson(@RequestParam String namePerson, @RequestParam String status){
        
        try {
            DAOPersistence objPerson = new DAOPersistence();
            
            iRepository.save(objPerson.validateObj(namePerson, status));
            return "Saved";
        } 
        catch (Exception e) {
            
            return e.getMessage();
        }
    }
    
    @PutMapping(path = "/{idPerson}")
    public @ResponseBody String updatePerson(@PathVariable int idPerson, @RequestParam String namePerson, @RequestParam String status){
        
        try {
            //Status objStatus = new Status();
            Person objPerson = iRepository.findById(idPerson);

            //objStatus.setNameStatus(nameStatus);
            objPerson.setNamePerson(namePerson);
            objPerson.setStatus(status);

            iRepository.save(objPerson);
            return "Updated";            
        } 
        catch (Exception e) {
            return e.getMessage();
        }
    }
    
    @DeleteMapping(path = "/{idPerson}")
    public @ResponseBody String deletePerson(@PathVariable int idPerson){
        
        iRepository.deleteById(idPerson);
        return "Deleted";
    }
    
    @GetMapping(path = "/{idPerson}")
    public @ResponseBody Person searchPerson(@PathVariable int idPerson){
        
        return iRepository.findById(idPerson);
//      
    }
}
