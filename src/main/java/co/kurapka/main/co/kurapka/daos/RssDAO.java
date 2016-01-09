package co.kurapka.main.co.kurapka.daos;

import co.kurapka.main.co.kurapka.model.Feed;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by achmudas on 27/12/15.
 */
public interface RssDAO {

    @SqlUpdate("insert into feed (id, name, url, user_id) values (:feed.id, :feed.name, :feed.url, :feed.userId)")
    void insert(@BindBean("feed") Feed feed);

    @SqlUpdate("delete from feed where id = :id")
    void delete(@Bind("id") int feedId);

    @SqlQuery("select id, name, url, user_id from feed where id = :id")
    @Mapper(Feed.FeedMapper.class)
    Feed findById(@Bind("id") int id);

}
