package co.kurapka.model.mappers;

import co.kurapka.model.Feed;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by achmudas on 10/01/16.
 */

public class FeedMapper implements ResultSetMapper<Feed>
{
    public Feed map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Feed(r.getInt("id"), r.getString("name"), r.getString("url"), r.getInt("user_id"), r.getInt("content_id"));
    }
}
