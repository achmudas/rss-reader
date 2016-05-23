package co.kurapka.daos;

import co.kurapka.model.Content;
import co.kurapka.model.mappers.ContentMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by achmudas on 30/04/16.
 */
public interface ContentDAO {

    @SqlUpdate("insert into content (feed_content, is_new, user_clicked, feed_id) " +
            "values (:content.content, :content.newContent, :content.userClicked, :content.feedId)")
    @GetGeneratedKeys
    long insert(@BindBean("content") Content content);

    @SqlQuery("select id, feed_content, is_new, user_clicked, feed_id from content where feed_id = :feedId")
    @Mapper(ContentMapper.class)
    Content findByFeedId(@Bind("feedId") long feedId);


    @SqlUpdate("update content set feed_content = :content.content, is_new = :content.newContent, " +
            "user_clicked = :content.userClicked, feed_id = :content.feedId where id = :content.id")
    void updateContent(@BindBean("content") Content content);
}
