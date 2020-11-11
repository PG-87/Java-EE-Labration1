package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("create")
    @POST
    public Response createNewStudent(Student student){
        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null){
            return Response.ok(foundStudent).build();
        } else {
            throw new StudentNotFoundException("Cant find the student");
        }
    }

    @Path("getByLastName/{lastName}")
    @GET
    public List<Student> getStudentByLastName(@PathParam("lastName") String lastName) {
        List<Student> foundStudents = studentService.findStudentByLastName(lastName);
        if (!foundStudents.isEmpty()){
            return studentService.findStudentByLastName(lastName);
        } else {
            throw new StudentNotFoundException("No student with that last name exist in database");
        }
    }

    @Path("getAllStudents")
    @GET
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        Student updatedStudent = studentService.updateStudent(student);
        if (updatedStudent != null) {
            return Response
                   .ok(updatedStudent)
                   .build();
        } else {
            throw new StudentNotFoundException("Cant find student to update!");
        }
    }

    @Path("removeStudent/{id}")
    @DELETE
    public Response removeStudent(@PathParam("id") Long id){
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null){
            studentService.removeStudentById(id);
            return Response.ok()
                    .entity("Student with Id: " + id + " was successfully deleted!")
                    .build();
        } else {
            throw new StudentNotFoundException("Wrong Id!");
        }
    }
}
