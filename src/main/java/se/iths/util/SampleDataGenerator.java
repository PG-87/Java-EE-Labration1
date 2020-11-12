package se.iths.util;

import se.iths.entity.Student;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData(){
        entityManager.persist(new Student("Maja", "Olsson", "majaOlle@gmail.com"));
        entityManager.persist(new Student("Anton", "Adamsson", "anton@gmail.com"));
        entityManager.persist(new Student("Greger", "Strömstedt", "greggan@hotmail.com"));
        entityManager.persist(new Student("Rolf", "Lassgård", "roffepoffe@gmail.com"));
    }
}
