package com.panel.Model.Interface;
import com.panel.Model.Class.Person;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends CrudRepository<Person, Integer>{
    
    Person findById(int id);
    Optional<Person> findAll(Sort sort);
}
