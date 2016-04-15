package co.kurapka.resources;

import co.kurapka.daos.RssDAO;
import co.kurapka.model.Feed;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by achmudas on 27/12/15.
 */

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RssResource {

    private RssDAO rssDAO;

    public RssResource(RssDAO rssDAO) {
        this.rssDAO = rssDAO;
    }

    @POST
    @Path("/addNewFeed")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewFeed(Feed feed) {
        rssDAO.insert(feed);
        return Response.ok().build();
    }

    @POST
    @Path("/deleteFeed{feedId}")
    public void deleteFeed(@PathParam("feedId") int id) {
        rssDAO.delete(id);
    }

    @GET
    @Path("/getFeed/{feedId}")
    public Feed getFeed(@PathParam("feedId") int id) {
       return rssDAO.findById(id);
    }

    @GET
    @Path("/getAllFeeds")
    public Feed getAllFeeds(@PathParam("feedId") int id) {
        return rssDAO.findById(id);
    }




}
