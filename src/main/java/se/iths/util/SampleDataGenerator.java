package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

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

        Student student1 = new Student("Maja", "Olsson", "majaOlle@gmail.com");
        Student student2 = new Student("Anton", "Adamsson", "anton@gmail.com");
        Student student3 = new Student("Greger", "Strömstedt", "greggan@hotmail.com");
        Student student4 = new Student("Rolf", "Lassgård", "roffepoffe@gmail.com");

        Subject subject1 = new Subject("Matte");
        Subject subject2 = new Subject("Engelska");

        Teacher teacher = new Teacher("Roger", "Niklasson", "roger.niklasson@iths.se", "0742-771233");

        student1.addSubject(subject1);
        student1.addSubject(subject2);
        student2.addSubject(subject1);
        student3.addSubject(subject2);
        student4.addSubject(subject2);

        teacher.addSubject(subject1);
        teacher.addSubject(subject2);


        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);

        entityManager.persist(teacher);
    }
}