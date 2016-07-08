package co.kurapka.resources;

import co.kurapka.daos.ContentDAO;
import co.kurapka.daos.RssDAO;
import co.kurapka.model.Content;
import co.kurapka.model.Feed;
import co.kurapka.scrambler.Scrambler;
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
@Path("/feed")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContentResource {

    private static final Logger logger = LoggerFactory.getLogger(ContentResource.class);

    private ContentDAO contentDAO;
    private RssDAO rssDAO;
    private Scrambler scrambler;

    public ContentResource(ContentDAO contentDAO, RssDAO rssDAO, Scrambler scrambler) {
        this.contentDAO = contentDAO;
        this.rssDAO = rssDAO;
        this.scrambler = scrambler;
    }

    @GET
    @Path("{feedId}/content")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Content getContent(@PathParam("feedId") int feedId) throws IOException {
        Content content = contentDAO.findByFeedId(feedId);
        Feed feed = rssDAO.findById(feedId);

        String currentContent = content.getContent();
        String downloadedContent = scrambler.removeDynamicParts(downloadContent(feed));

        logger.info("Current feed id: {}", content.getFeedId());
        logger.info("Current content is not blank: {}", StringUtils.isNotBlank(currentContent));
        logger.info("Contents are equal: {}", StringUtils.equals(currentContent, downloadedContent));
        logger.info("User clicked on content: {}", content.isUserClicked());

        if (StringUtils.isNotBlank(currentContent) && StringUtils.equals(currentContent, downloadedContent)
                && content.isUserClicked()) {
            content.setNewContent(false);
        } else {
            content.setContent(downloadedContent);
            content.setNewContent(true);
            content.setUserClicked(false);
            logger.info("Current content: {}", currentContent);
            logger.info("================================================================================");
            logger.info("Downloaded content: {}", downloadedContent);
//            logger.info(StringUtils.difference(currentContent, downloadedContent));
        }
        contentDAO.updateContent(content);
        return content;
    }

    private String downloadContent(Feed feed) throws IOException {
        String downloadedContent = null;
        try {
            downloadedContent = Jsoup.connect(
                    feed.getUrl())
                    .validateTLSCertificates(false).get().html();

        } catch (IOException e) {
            logger.error("Error during scrambling feed", e);
            throw e;
        }
        return downloadedContent;
    }

    @PUT
    @Path("{feedId}/content")
    @Consumes(MediaType.APPLICATION_JSON)
    public Content userClicked(@PathParam("feedId") int feedId){
        Content content = contentDAO.findByFeedId(feedId); //FIXME probably would be smarter to send all content object for performance
        content.setNewContent(false);
        content.setUserClicked(true);
        contentDAO.updateContent(content);
        return content;
    }

}
