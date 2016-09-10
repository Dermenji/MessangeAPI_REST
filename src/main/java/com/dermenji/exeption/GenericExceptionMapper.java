package com.dermenji.exeption;


import com.dermenji.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable dataNotFoundExeption) {
        ErrorMessage errorMessage = new ErrorMessage(dataNotFoundExeption.getMessage(), 500, "google.com");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }
}
