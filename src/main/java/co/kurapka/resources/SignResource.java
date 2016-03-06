package co.kurapka.resources;

import co.kurapka.daos.RssDAO;
import co.kurapka.daos.SignDAO;
import co.kurapka.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by mka on 2016.01.26.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SignResource {

    private static final Logger logger = LoggerFactory.getLogger(SignResource.class);

    private SignDAO signDAO;

    public SignResource(SignDAO signDAO) {
        this.signDAO = signDAO;
    }

    @POST
    @Path("/signUp")
    @Consumes(MediaType.APPLICATION_JSON)
    public void signUp(User user) {
        logger.info("User to be registered: {}", user);
        signDAO.insert(user);
    }

    @POST
    @Path("/signIn")
    public User signIn(@PathParam("username") String username, @PathParam("password") String password) {
        return new User("username1"); //FIXME
    }


}
