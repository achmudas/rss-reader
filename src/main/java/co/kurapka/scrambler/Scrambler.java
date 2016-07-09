package co.kurapka.scrambler;

import java.util.Arrays;
import java.util.List;

/**
 * Created by achmudas on 03/06/16.
 */
public class Scrambler {

    private static final String TAGS = "\\s*<(/)?.*?>\\s*";


    public String removeTags(String html) {
        String scrambledHtml = html.replaceAll(TAGS, "");;
        return scrambledHtml;
    }
}
