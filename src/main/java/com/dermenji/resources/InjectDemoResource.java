package com.dermenji.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Alex on 9/10/2016.
 */
@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    @GET
    @Path("annotations")
    public String getParamesUsingAnnotations(@MatrixParam("param") String matrixParam,
                                             @MatrixParam("customHeaderValue") String header,
                                             @CookieParam("name") String cookie) {
        return "Metrix param " + matrixParam + " Header param: " + header + " Cookie: " + cookie;
    }

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
        String path = uriInfo.getAbsolutePath().toString();
        String cookies = headers.getCookies().toString();
        return  "Path : " + path + " Cookies: " + cookies;
    }

}
