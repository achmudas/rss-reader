package co.kurapka.scrambler;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by achmudas on 03/06/16.
 */
public class ScramblerTest {

    private Scrambler scrambler;

    private String html ="<body class=\"home blog custom-background custom-background-white custom-font-enabled single-author\"> \n" +
            "  <div id=\"page\" class=\"hfeed site\"> \n" +
            "   <header id=\"mas434_.thead\" class=\"site-header\" role=\"banner\"> \n" +
            "    <hgroup> \n" +
            "    <!-- [Format Time: 0.0031 seconds] -->\n" +
            "       <div class=\"crayon-num\" data-line=\"crayon-5752a7ea6eb1e131946077-5\">\n" +
            "         5\n" +
            "       </div>" +
            "     <h1 class=\"site-title\"><a href=\"http://kurapka.co/\" title=\"kurapka.co\" rel=\"home\">kurapka.co</a></h1> \n" +
            "     <h2 class=\"site-description\"></h2> \n";

    private String simplierHtml = "<body id=\"test\">5</body>";

    @Before
    public void setUp() {
        scrambler = new Scrambler();
    }


    @Test
    public void htmlScrambled() {
        String expectedHtml = "5";
        Assertions.assertThat(scrambler.removeDynamicParts(simplierHtml)).isEqualTo(expectedHtml);
    }

    @Test
    public void harderHtmlScrambled() {
        String expectedHtml = "5kurapka.co";
        Assertions.assertThat(scrambler.removeDynamicParts(html)).isEqualTo(expectedHtml);
    }
}
