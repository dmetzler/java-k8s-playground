package org.dmetzler;

import javax.inject.Inject;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/shoot")
public class TakeDownResource {

    @Inject
    SimpleHealthCheck hc;

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public String shootApplication() {
        hc.up = false;
        return "Application should now be irresponsive";

    }

}