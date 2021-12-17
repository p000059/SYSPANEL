package com.panel.Model.Class;
import com.panel.Model.Interface.IValidator;
import com.sun.istack.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Person {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPerson;
    
    private String namePerson;
    private String status;
    
    //@OneToMany(mappedBy = "person", orphanRemoval = true)
    //private Status status;
    private String local;
    private String expectedStart;
    private String startSurgery;
    private String endSurgery;
    private String expectedOutput;
    
    public Person() {
    }
    
    public Person(int idPerson) {
        this.idPerson = idPerson;
    }

    public Person(int idPerson, String namePerson) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
    }

    public Person(int idPerson, String namePerson, String status) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
    }

    public Person(int idPerson, String namePerson, String status, String local) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
        this.local = local;
    }

    public Person(int idPerson, String namePerson, String status, String local, String expectedStart) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
        this.local = local;
        this.expectedStart = expectedStart;
    }

    public Person(int idPerson, String namePerson, String status, String local, String expectedStart, String startSurgery) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
    }

    public Person(int idPerson, String namePerson, String status, String local, String expectedStart, String startSurgery, String endSurgery) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
    }

    public Person(int idPerson, String namePerson, String status, String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput) {
        this.idPerson = idPerson;
        this.namePerson = namePerson;
        this.status = status;
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }
    
    public Person(String endSurgery, String expectedOutput) {
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String startSurgery, String endSurgery, String expectedOutput) {
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String expectedStart, String startSurgery, String endSurgery, String expectedOutput) {
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput) {
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String status, String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput) {
        this.status = status;
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
    }

    public Person(String namePerson, String statusPerson, String local, String expectedStart, String startSurgery, String endSurgery, String expectedOutput) {
        this.namePerson = namePerson;
        this.status = statusPerson;
        this.local = local;
        this.expectedStart = expectedStart;
        this.startSurgery = startSurgery;
        this.endSurgery = endSurgery;
        this.expectedOutput = expectedOutput;
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

    public void setNamePerson(String namePerson){
    
        this.namePerson = namePerson;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
            
        this.status = status;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        
        this.local = local;
    }

    public String getExpectedStart() {
        return expectedStart;
    }

    public void setExpectedStart(String expectedStart) {
        
        this.expectedStart = expectedStart;
    }

    public String getStartSurgery() {
        return startSurgery;
    }

    public void setStartSurgery(String startSurgery) {
        this.startSurgery = startSurgery;
    }

    public String getEndSurgery() {
        return endSurgery;
    }

    public void setEndSurgery(String endSurgery) {
        this.endSurgery = endSurgery;
    }

    public String getExpectedOutput() {
        return expectedOutput;
    }

    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }

}
