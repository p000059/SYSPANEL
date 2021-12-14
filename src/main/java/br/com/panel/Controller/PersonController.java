package br.com.panel.Controller;
import br.com.panel.Models.Class.Person;
import br.com.panel.Models.Interface.IRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    
    @GetMapping(path="/LoadAllPerson")
    public ArrayList<Person> loadAllPerson(){
        
        return iRepository.findAll(Sort.by(Sort.Direction.ASC, "idPerson"));
        
    }
    
    @PostMapping(path = "/CreatePerson")
    public @ResponseBody String addNewPerson (@RequestParam String namePerson){
        
        Person person = new Person();
        person.setNamePerson(namePerson);
        iRepository.save(person);
        return "Saved";
    }
    
    @PutMapping(path = "/UpdatePerson/{idPerson}")
    public @ResponseBody String updatePerson(@PathVariable int idPerson, @RequestParam String namePerson){
        
        Person person = iRepository.findById(idPerson);
        person.setNamePerson(namePerson);
        iRepository.save(person);
        return "Updated";
    }
    
    @DeleteMapping(path = "/DeletePerson/{idPerson}")
    public @ResponseBody String deletePerson(@PathVariable int idPerson){
        
        Person person = new Person();
        
        iRepository.deleteById(idPerson);
        return "Deleted";
    }
    
    @GetMapping(path = "/SearchPerson/{idPerson}")
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
