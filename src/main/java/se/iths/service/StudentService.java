package se.iths.service;

import se.iths.entity.Student;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        if (student != null)
        entityManager.merge(student);
        return student;
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> findStudentByLastName(String lastName) {
        return entityManager.
                createQuery("SELECT p FROM Student p WHERE p.lastName = \'" + lastName + "\'", Student.class)
                .getResultList();
    }

    public List<Student> getAllStudents(){
        return entityManager.createQuery("SELECT i from Student i", Student.class).getResultList();
    }

    public void removeStudentById(Long id) {
        entityManager.remove(findStudentById(id));
    }
}
