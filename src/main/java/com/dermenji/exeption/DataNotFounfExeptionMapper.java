package com.dermenji.exeption;


import com.dermenji.model.ErrorMessage;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class DataNotFounfExeptionMapper implements ExceptionMapper<DataNotFoundExeption> {

    @Override
    public Response toResponse(DataNotFoundExeption dataNotFoundExeption) {
        ErrorMessage errorMessage = new ErrorMessage(dataNotFoundExeption.getMessage(), 404, "google.com");
        return Response.status(Status.NOT_FOUND).entity(errorMessage).build();

    }
}
