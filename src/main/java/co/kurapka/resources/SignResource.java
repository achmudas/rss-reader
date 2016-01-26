package co.kurapka.resources;

import co.kurapka.daos.RssDAO;
import co.kurapka.daos.SignDAO;
import co.kurapka.model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by mka on 2016.01.26.
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SignResource {

    private SignDAO signDAO;

    public SignResource(SignDAO signDAO) {
        this.signDAO = signDAO;
    }

    @POST
    @Path("/signUp")
    public void signUp(@PathParam("user") User user) {
        signDAO.insert(user);
    }

    @POST
    @Path("/signIn")
    public User signIn(@PathParam("username") String username, @PathParam("password") String password) {
        return new User("username1"); //FIXME
    }


}
