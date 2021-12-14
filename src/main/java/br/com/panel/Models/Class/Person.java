package br.com.panel.Models.Class;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import br.com.panel.Models.ValidatorClass.ValidatorName;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPerson;
    private String namePerson;

    public Person() {
    }

    public Person(int idPerson, String namePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        ValidatorName validatorName = new ValidatorName();
        //validatorName.valida(namePerson);
        this.namePerson = namePerson;
    }
    
}
