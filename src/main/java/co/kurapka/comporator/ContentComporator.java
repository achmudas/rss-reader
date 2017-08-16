package co.kurapka.comporator;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by achmudas on 16/08/2017.
 */
public class ContentComporator {

    private static final Logger logger = LoggerFactory.getLogger(ContentComporator.class);

    public void compareAndLog(String currentContent, String downloadedContent) {



        logger.info("Current content: {}", currentContent);
        logger.info("================================================================================");
        logger.info("Downloaded content: {}", downloadedContent);
        logger.info(StringUtils.difference(currentContent, downloadedContent));

    }
}
