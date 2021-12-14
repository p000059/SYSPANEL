package br.com.syspanel.Controller.Person;
import br.com.syspanel.Model.Class.Person;
import br.com.syspanel.Model.Interface.IRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
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
    
    @GetMapping(path = "/loadAllPerson")
    public List<Person> loadAllPerson(){
        
        return iRepository.findAll(Sort.by(Sort.Direction.ASC, "idPerson"));
    }
    
    @PostMapping(path = "/createPerson")
    public @ResponseBody String createPerson(@RequestParam String namePerson, @RequestParam String statusPerson){
        
        Person objPerson = new Person();
        objPerson.setNamePerson(namePerson);
        objPerson.setStatusPerson(statusPerson);
        iRepository.save(objPerson);
        return "Saved";
    }
    
    @PutMapping(path = "/updatePerson/{idPerson}")
    public @ResponseBody String updatePerson(@PathVariable int idPerson, @RequestParam String namePerson, @RequestParam String statusPerson){
        
        Person objPerson = iRepository.findById(idPerson);
        objPerson.setNamePerson(namePerson);
        objPerson.setStatusPerson(statusPerson);
        iRepository.save(objPerson);
        return "Updated";
    }
    
    @DeleteMapping(path = "/deletePerson/{idPerson}")
    public @ResponseBody String deletePerson(@PathVariable int idPerson){
        
        iRepository.deleteById(idPerson);
        return "Deleted";
    }
    
    @GetMapping(path = "/searchPerson/{idPerson}")
    public @ResponseBody Person searchPerson(@PathVariable int idPerson){
        
        Person objPerson = new Person();
        
        for(int i = 0; i < this.loadAllPerson().size(); i++){
            
            if(loadAllPerson().get(i).getIdPerson() == idPerson){
                objPerson = loadAllPerson().get(i);
                break;
            }
        }
        
        return objPerson;
    }
}
