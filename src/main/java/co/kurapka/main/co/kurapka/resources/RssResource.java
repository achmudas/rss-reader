package co.kurapka.main.co.kurapka.resources;

import co.kurapka.main.co.kurapka.daos.RssDAO;
import co.kurapka.main.co.kurapka.model.Feed;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by achmudas on 27/12/15.
 */

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
public class RssResource {

    private RssDAO rssDAO;

    public RssResource(RssDAO rssDAO) {
        this.rssDAO = rssDAO;
    }

    @POST
    @Path("/addNewFeed")
    public void addNewFeed(Feed feed) {
        rssDAO.insert(feed);
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
