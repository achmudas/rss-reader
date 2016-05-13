package co.kurapka.daos;

import co.kurapka.model.Content;
import co.kurapka.model.mappers.ContentMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by achmudas on 30/04/16.
 */
public interface ContentDAO {

    @SqlUpdate("insert into content (feed_content, is_new) values (:content.content, :content.newContent)")
    @GetGeneratedKeys
    long insert(@BindBean("content") Content content);

    @SqlQuery("select id, feed_content, is_new from content where id = :id")
    @Mapper(ContentMapper.class)
    Content findById(@Bind("id") int id);
}
