package co.kurapka.caching;

import co.kurapka.model.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by achmudas on 15/04/16.
 */
public class CachingUtilityTest {

    private CachingUtility caching;

    @Before
    public void setUp() {
        caching = new CachingUtility();
    }

    @Test
    public void cacheIsLoaded() {
        caching.cacheUserByToken("token1", new User(5, "achmudas", "pass", "achmudas@kurapka.co"));
        caching.cacheUserByToken("token2", new User(78, "deluxo", "pass12", "deluxo@kurapka.co"));
        Assertions.assertThat(caching.getUserByToken("token2").getUsername()).isEqualTo("deluxo");
    }
}
