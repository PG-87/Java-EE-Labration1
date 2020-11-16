package se.iths.rest;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class JsonParseExceptionMapper implements ExceptionMapper<ProcessingException> {


    @Override
    public Response toResponse(ProcessingException exception) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Input incomplete or malformed. The request can not be parsed!")
                .type(MediaType.TEXT_PLAIN)
                .build();
    }
}
