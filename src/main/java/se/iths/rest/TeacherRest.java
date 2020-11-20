package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Set;

@Path("teacher")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TeacherRest {

    @Inject
    TeacherService teacherService;

    @Path("create")
    @POST
    public Response hireNewTeacher(Teacher teacher){
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).build();
    }

    @Path("getallteachers")
    @GET
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @Path("getstudents/{teachername}/{subjectname}")
    @GET
    public Set<Student> getStudentsForSubject(@PathParam("teachername") String teacherName, @PathParam("subjectname") String subject) {
        return teacherService.getStudentsForSubject(teacherName, subject);
    }
}
