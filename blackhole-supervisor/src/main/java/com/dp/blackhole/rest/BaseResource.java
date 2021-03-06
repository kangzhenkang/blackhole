package com.dp.blackhole.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.dp.blackhole.supervisor.ConfigManager;
import com.dp.blackhole.supervisor.Supervisor;

@Path("/")
public class BaseResource {
    private static final Log LOG = LogFactory.getLog(BaseResource.class);
    
    protected ConfigManager configService = ServiceFactory.getConfigManager();
    protected Supervisor supervisorService = ServiceFactory.getSupervisor();
    
    @GET
    @Path("/log/package/{package}/{level}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response index(@PathParam("package") String p, @PathParam("level") String l) {
        LOG.info("GET: change " + p + " log level to " + l);
        Level level = Level.toLevel(l);
        Logger logger = LogManager.getLogger(p);
        logger.setLevel(level);
        return Response.ok().build();
    }

    @GET
    @Path("/log/root/{level}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response index(@PathParam("level") String l) {
        LOG.info("GET: change root log level to " + l);
        Level level = Level.toLevel(l);
        LogManager.getRootLogger().setLevel(level);
        return Response.ok().build();
    }
}
