package co.kurapka.model;

/**
 * Created by achmudas on 30/04/16.
 */
public class Content {

    private int id;
    private String content;
    private boolean newContent;
    private boolean userClicked;

    public Content(int id, String content, boolean newContent, boolean userClicked) {
        this.id = id;
        this.content = content;
        this.newContent = newContent;
        this.userClicked = userClicked;
    }

    public Content() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
