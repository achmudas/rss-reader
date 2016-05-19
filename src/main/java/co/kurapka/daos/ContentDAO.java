package co.kurapka.daos;

import co.kurapka.model.Content;
import co.kurapka.model.mappers.ContentMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by achmudas on 30/04/16.
 */
public interface ContentDAO {

    @SqlUpdate("insert into content (feed_content, is_new, user_clicked) values (:content.content, :content.newContent, :content.userClicked)")
    @GetGeneratedKeys
    long insert(@BindBean("content") Content content);

    @SqlQuery("select id, feed_content, is_new, user_clicked from content where id = :id")
    @Mapper(ContentMapper.class)
    Content findById(@Bind("id") int id);


    @SqlUpdate("update content set feed_content = :content.content, is_new = :content.newContent, user_clicked = :content.userClicked where id = :content.id")
    void updateContent(@BindBean("content") Content content);
}
