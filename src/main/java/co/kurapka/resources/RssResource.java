package co.kurapka.resources;

import co.kurapka.caching.CachingUtility;
import co.kurapka.daos.RssDAO;
import co.kurapka.model.Feed;
import co.kurapka.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by achmudas on 27/12/15.
 */

@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RssResource {

    private final CachingUtility caching;
    private RssDAO rssDAO;

    public RssResource(RssDAO rssDAO, CachingUtility caching) {
        this.caching = caching;
        this.rssDAO = rssDAO;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addNewFeed(Feed feed, @Context HttpServletRequest httpRequest) {
        User user = caching.getUserByToken(httpRequest.getHeader("Auth-Token"));
        feed.setUserId(user.getId());
        rssDAO.insert(feed);
        return Response.ok().build();
    }

    @GET
    @Path("/{feedId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Feed getFeed(@PathParam("feedId") int id) {
        return rssDAO.findById(id);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFeeds(@Context HttpServletRequest httpRequest) {
        User user = caching.getUserByToken(httpRequest.getHeader("Auth-Token"));
        List<Feed> feeds = rssDAO.findAll(user.getId());
        return Response.ok(feeds).build();
    }

    @DELETE
    @Path("/{feedId}")
    public Response deleteFeed(@PathParam("feedId") int id) {
        rssDAO.delete(id);
        return Response.ok().build();
    }

}
