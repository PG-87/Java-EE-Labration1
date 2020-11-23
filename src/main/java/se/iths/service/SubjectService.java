package se.iths.service;

import se.iths.entity.Subject;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createNewSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT i FROM Subject i", Subject.class).getResultList();
    }

    public List<Subject> getAllSubjectsSortedByCategory(){
        String query = "SELECT i FROM Subject i ORDER BY i.category";
        return entityManager.createQuery(query, Subject.class).getResultList();
    }

    public List<Subject> findSubjectByName(String category) {
        return entityManager
                .createQuery("SELECT s FROM Subject s WHERE s.category =\'" + category + "\'", Subject.class)
                .getResultList();
    }
}
