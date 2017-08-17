package co.kurapka.comporator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by achmudas on 16/08/2017.
 */
public class ContentComporator {

    private static final Logger logger = LoggerFactory.getLogger(ContentComporator.class);

    public void compareAndLog(String url, String currentContent, String downloadedContent) {



//        logger.info("Current content: {}", currentContent);
//        logger.info("================================================================================");
//        logger.info("Downloaded content: {}", downloadedContent);
        logger.info("URL={}, Difference={}", url, findDifference(currentContent, downloadedContent));
    }

    private String findDifference(CharSequence cs1, CharSequence cs2) {
        StringBuilder difference = new StringBuilder();
        if (cs1 == cs2) {
            return difference.toString();
        }
        if (cs1 == null || cs2 == null) {
            return difference.toString();
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                difference.append(cs2.charAt(i));
            }
        }
        return difference.toString();
    }
}
