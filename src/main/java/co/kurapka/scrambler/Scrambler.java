package co.kurapka.scrambler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by achmudas on 03/06/16.
 */
public class Scrambler {

//    private static final String IDS_PATTERN = "id=\"[^\\s]+ ";
//    private static final String CLASSES_PATTERN = "class=\"[^\\s]+ ";
//    private static final String DATA_LINE_PATTERN = "data-line=\"[^\\s]+ ";
//    private static final String COMMENTS = "";
    private static final String TAGS = "<(/)?.*?>";


    public String removeDynamicParts(String html) {
        String scrambledHtml = html.replaceAll(TAGS, "");
//                                    .replaceAll(CLASSES_PATTERN, "")
//                                    .replaceAll(DATA_LINE_PATTERN, "");
//                                    .replaceAll(COMMENTS, "");
        return scrambledHtml;
    }
}
