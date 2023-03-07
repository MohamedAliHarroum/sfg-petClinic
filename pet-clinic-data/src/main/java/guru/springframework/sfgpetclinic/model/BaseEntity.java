package guru.springframework.sfgpetclinic.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    public  BaseEntity (){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}