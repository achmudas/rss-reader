package co.kurapka.model;

/**
 * Created by achmudas on 09/01/16.
 */
public class Feed {

    private long id;
    private String name;
    private String url;
    private long userId;

    public Feed(){}

    public Feed(int id, String name, String url, int userId) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
