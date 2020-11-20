package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subject")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("create")
    @POST
    public Response createNewSubject(Subject subject){
        subjectService.createNewSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("getallsubjects")
    @GET
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @Path("sortedsubjects")
    @GET
    public List<Subject> getSubjectSortedByCategory() {
        return subjectService.getAllSubjectsSortedByCategory();
    }
}
