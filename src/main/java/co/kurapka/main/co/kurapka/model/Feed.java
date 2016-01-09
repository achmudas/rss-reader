package co.kurapka.main.co.kurapka.model;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by achmudas on 09/01/16.
 */
public class Feed {

    private int id;
    private String name;
    private String url;
    private int userId;

    public Feed(int id, String name, String url, int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public class FeedMapper implements ResultSetMapper<Feed>
    {
        public Feed map(int index, ResultSet r, StatementContext ctx) throws SQLException
        {
            return new Feed(r.getInt("id"), r.getString("name"), r.getString("url"), r.getInt("user_id"));
        }
    }

}
