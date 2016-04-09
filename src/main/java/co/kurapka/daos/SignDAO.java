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

    @SqlUpdate("insert into \"user\" (username, pass, email) values (:username, :password, :email)")
    void insert(@BindBean User user);

    @SqlQuery("select id, username, pass, email from user where username = :username")
    @Mapper(UserMapper.class)
    User findByUsername(@Bind("username") String username);
}
