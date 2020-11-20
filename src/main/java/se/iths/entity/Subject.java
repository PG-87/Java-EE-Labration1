package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "Subject")
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @NotNull
    private String category;

    @ManyToMany(mappedBy = "subjects", cascade = CascadeType.PERSIST)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Teacher teacher;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Student> getStudents(){
        return students;
    }

    public Subject(@NotEmpty @NotNull String category) {
        this.category = category;
    }

    public Subject() {
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void remove(Subject subject) {
    }
}
