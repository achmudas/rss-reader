package co.kurapka.model.mappers;

import co.kurapka.model.Content;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by achmudas on 03/05/16.
 */
public class ContentMapper implements ResultSetMapper<Content> {

    public Content map(int index, ResultSet r, StatementContext ctx) throws SQLException
    {
        return new Content(r.getInt("id"), r.getString("feed_content"), r.getBoolean("is_new"));
    }
}
