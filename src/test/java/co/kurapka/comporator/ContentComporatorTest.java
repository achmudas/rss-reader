package co.kurapka.comporator;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by achmudas on 16/08/2017.
 */
public class ContentComporatorTest {

    private ContentComporator comp;

    @Before
    public void setUp() throws Exception {
        comp = new ContentComporator();
    }

    @Test
    public void printsOnlyDifference() throws Exception {
        String currentContent = "<html><body><div class=test><p>testing</p></div></body></html>";
        String downloadedContent = "<html><body><div class=test><b>testing</b></div></body></html>";
        comp.compareAndLog(currentContent, downloadedContent);
    }
}
