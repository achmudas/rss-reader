package co.kurapka.model.mappers;

import co.kurapka.model.Feed;
import co.kurapka.model.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mka on 2016.01.26.
 */
public class UserMapper implements ResultSetMapper<User> {

    public User map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new User(r.getInt("id"), r.getString("fullName"), r.getString("pass"), r.getString("email"));
    }
}
