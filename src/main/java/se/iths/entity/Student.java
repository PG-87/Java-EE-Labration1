package se.iths.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty
    @NotNull
    private String firstName;
    @NotEmpty
    @NotNull
    private String lastName;
    @NotEmpty
    @NotNull
    private String email;

    private String phoneNumber;


    public Student(@NotEmpty @NotNull String firstName, @NotEmpty @NotNull String lastName, @NotEmpty @NotNull String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Student() {
        
    }
}
