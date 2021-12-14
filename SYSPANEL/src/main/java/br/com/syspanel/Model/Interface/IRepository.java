package br.com.syspanel.Model.Interface;
import br.com.syspanel.Model.Class.Person;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Sort;

public interface IRepository extends CrudRepository<Person, Integer>{
    
    public Person findById(int id);
    public ArrayList<Person> findAll(Sort sort);
}
