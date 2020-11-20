package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    public Set<Student> getStudentsForSubject(String teacherName, String subjectName) {
        Subject subject = (Subject) entityManager
                .createQuery("SELECT DISTINCT i FROM Subject i INNER JOIN i.teacher t INNER JOIN i.students s WHERE t.firstName = :teacherName AND i.category =:subjectName")
                .setParameter("teacherName", teacherName).setParameter("subjectName", subjectName).getSingleResult();
        Set<Student> studentsResult = subject.getStudents();
        return studentsResult;
    }

    public Teacher createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
        return teacher;
    }

    public List<Teacher> getAllTeachers() {
        return entityManager
                .createQuery("SELECT i FROM Teacher i", Teacher.class)
                .getResultList();
    }
}
