package co.kurapka.daos;

import co.kurapka.model.Feed;
import co.kurapka.model.User;
import co.kurapka.model.mappers.FeedMapper;
import co.kurapka.model.mappers.UserMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by mka on 2016.01.26.
 */
public interface SignDAO {

    @SqlUpdate("insert into user (id, fullName, pass, email) values (:user.id, :user.fullName, :user.pass, :user.email)")
    void insert(@BindBean("user") User user);

    @SqlQuery("select id, name, url, user_id from feed where id = :id")
    @Mapper(UserMapper.class)
    Feed findByEmail(@Bind("email") String email);
}
