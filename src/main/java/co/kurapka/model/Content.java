package co.kurapka.model;

/**
 * Created by achmudas on 30/04/16.
 */
public class Content {

    private int id;
    private String content;
    private boolean isNew;

    public Content(int id, String content, boolean isNew) {
        this.id = id;
        this.content = content;
        this.isNew = isNew;
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

    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }
}
