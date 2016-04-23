package co.kurapka.daos;

import co.kurapka.model.Feed;
import co.kurapka.model.mappers.FeedMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.List;

/**
 * Created by achmudas on 27/12/15.
 */
public interface RssDAO {

    @SqlUpdate("insert into feed (name, url, user_id) values (:feed.name, :feed.url, :feed.userId)")
    void insert(@BindBean("feed") Feed feed);

    @SqlUpdate("delete from feed where id = :id")
    void delete(@Bind("id") int feedId);

    @SqlQuery("select id, name, url, user_id from feed where id = :id")
    @Mapper(FeedMapper.class)
    Feed findById(@Bind("id") int id);

    @SqlQuery("select id, name, url, user_id from feed where user_id = :userId")
    @Mapper(FeedMapper.class)
    List<Feed> findAll(@Bind("userId") int userId);
}
