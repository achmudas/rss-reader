package co.kurapka.model;

/**
 * Created by achmudas on 30/04/16.
 */
public class Content {

    private long id;
    private String content;
    private boolean newContent;
    private boolean userClicked;
    private long feedId;

    public Content(long id, String content, boolean newContent, boolean userClicked, long feedId) {
        this.id = id;
        this.content = content;
        this.newContent = newContent;
        this.userClicked = userClicked;
        this.feedId = feedId;
    }

    public Content() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isNewContent() {
        return newContent;
    }

    public void setNewContent(boolean newContent) {
        this.newContent = newContent;
    }

    public boolean isUserClicked() {
        return userClicked;
    }

    public void setUserClicked(boolean userClicked) {
        this.userClicked = userClicked;
    }

    public long getFeedId() {
        return feedId;
    }

    public void setFeedId(long feedId) {
        this.feedId = feedId;
    }
}
