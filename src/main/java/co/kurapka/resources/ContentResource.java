package co.kurapka.resources;

import co.kurapka.daos.ContentDAO;
import co.kurapka.daos.RssDAO;
import co.kurapka.model.Content;
import co.kurapka.model.Feed;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by achmudas on 30/04/16.
 */
@Path("/content")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContentResource {

    private static final Logger logger = LoggerFactory.getLogger(ContentResource.class);

    private ContentDAO contentDAO;
    private RssDAO rssDAO;

    public ContentResource(ContentDAO contentDAO, RssDAO rssDAO) {
        this.contentDAO = contentDAO;
        this.rssDAO = rssDAO;
    }

    @GET
    @Path("/{contentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Content getContent(@PathParam("contentId") int id) throws IOException {
        Content content = contentDAO.findById(id);
        Feed feed = rssDAO.findByContentId(id);

        String currentContent = content.getContent();
        String downloadedContent = downloadContent(feed);

        if (StringUtils.isNotBlank(currentContent) && StringUtils.equals(currentContent, downloadedContent)) {
            content.setIsNew(false);
        } else {
            content.setIsNew(true);
        }

        return content;
    }

    private String downloadContent(Feed feed) throws IOException {
        String downloadedContent = null;
        try {
            downloadedContent = Jsoup.connect(feed.getUrl()).get().html();
        } catch (IOException e) {
            logger.error("Error during scrambling feed", e);
            throw e;
        }
        return downloadedContent;
    }
}
