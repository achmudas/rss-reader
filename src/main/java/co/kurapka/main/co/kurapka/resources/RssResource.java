package co.kurapka.main.co.kurapka.resources;

import co.kurapka.main.co.kurapka.daos.RssDAO;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by achmudas on 27/12/15.
 */

@Path("/rss")
@Produces(MediaType.APPLICATION_JSON)
public class RssResource {

    private RssDAO rssDAO;

    public RssResource(RssDAO rssDAO) {
        this.rssDAO = rssDAO;
    }

    @GET
    @Path("/getNews/{rssId}")
    public String getNews(@PathParam("rssId") LongParam personId) {
        return "Nothing" + personId;
    }
}
