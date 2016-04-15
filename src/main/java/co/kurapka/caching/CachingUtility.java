package co.kurapka.caching;



import co.kurapka.model.User;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by achmudas on 15/04/16.
 */
public class CachingUtility {

    private static final Logger logger = LoggerFactory.getLogger(CachingUtility.class);

    private LoadingCache<String, User> cache;


    public CachingUtility() {
        cache = CacheBuilder.newBuilder()
                .maximumSize(5000)
                .expireAfterAccess(10, TimeUnit.MINUTES)
                .build(
                        new CacheLoader<String, User>() {
                            public User load(String accessToken) throws Exception {
                                return null;
                            }
                        });
    }

    public User getUserByToken(String token) {
        try {
            return cache.get(token);
        } catch (ExecutionException e) {
            logger.error("Error loading user by token", e);
            return null;
        }
    }

    public void cacheUserByToken(String token, User user) {
        cache.put(token, user);
    }
}
