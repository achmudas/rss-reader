package co.kurapka.main;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by achmudas on 14/09/15.
 */
@Path("/rss_resources")
@Produces(MediaType.APPLICATION_JSON)
public class ReaderResource {

    @GET
    public String sayHello() throws InterruptedException {
        return "Hi";
    }
}
