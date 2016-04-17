package co.kurapka.main;

import co.kurapka.caching.CachingUtility;
import co.kurapka.daos.RssDAO;
import co.kurapka.daos.SignDAO;
import co.kurapka.model.User;
import co.kurapka.resources.RssResource;
import co.kurapka.resources.SignResource;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import java.util.concurrent.TimeUnit;

/**
 * Created by achmudas on 01/09/15.
 */
public class Main extends Application<ReaditConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void initialize(Bootstrap<ReaditConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/html", "/", "index.html"));
        bootstrap.addBundle(new MigrationsBundle<ReaditConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ReaditConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
    }

    @Override
    public void run(ReaditConfiguration configuration, Environment environment) throws Exception {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "postgresql");
        final RssDAO rssDAO = jdbi.onDemand(RssDAO.class);
        final SignDAO signDAO = jdbi.onDemand(SignDAO.class);

        CachingUtility caching = new CachingUtility();


//        final Auth


        environment.jersey().register(new RssResource(rssDAO));
        environment.jersey().register(new SignResource(signDAO, caching));
        ((DefaultServerFactory) configuration.getServerFactory()).setJerseyRootPath("/api/*");
    }

//    @Override
//    public void run(JModernConfiguration configuration, Environment environment) throws Exception {
//
//        JmxReporter.forRegistry(environment.metrics()).build().start();
//        environment.jersey().register(new HelloWorldResource(configuration));
//
//        Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration()).build("client");
//        environment.jersey().register(new ConsumerResource(client));
//
//    }
//
//    public static class JModernConfiguration extends Configuration{
//        @JsonProperty private @NotEmpty String template;
//        @JsonProperty private @NotEmpty String defaultName;
//
//        @Valid @NotNull @JsonProperty JerseyClientConfiguration httpClient = new JerseyClientConfiguration();
//
//        public String getTemplate() {
//            return template;
//        }
//
//        public String getDefaultName() {
//            return defaultName;
//        }
//
//        public JerseyClientConfiguration getJerseyClientConfiguration() {
//            return httpClient;
//        }
//    }
//
//    @Path("/hello-world")
//    @Produces(MediaType.APPLICATION_JSON)
//    public static class HelloWorldResource {
//        private final AtomicLong counter = new AtomicLong();
//        private final String template;
//        private final String defaultName;
//
//        public HelloWorldResource(JModernConfiguration cfg) {
//            this.template = cfg.getTemplate();
//            this.defaultName = cfg.getDefaultName();
//        }
//
//        @Timed
//        @GET
//        public Saying sayHello(@QueryParam("name") Optional<String> name) throws InterruptedException {
//            final String value = String.format(template, name.or(defaultName));
//            Thread.sleep(ThreadLocalRandom.current().nextInt(10, 500));
//            return new Saying(counter.incrementAndGet(), value);
//        }
//    }
//
//    @Path("/consumer")
//    @Produces(MediaType.TEXT_PLAIN)
//    public static class ConsumerResource {
//        private final Client client;
//
//        public ConsumerResource(Client client) {
//            this.client = client;
//        }
//
//        @Timed
//        @GET
//        public String consume() {
//            Saying saying = client.resource(UriBuilder.fromUri("http://localhost:8080/hello-world")
//                    .queryParam("name", "consumer")
//                    .build())
//                    .get(Saying.class);
//            return String.format("The service is saying: %s (id: %d)", saying.getContent(), saying.getId());
//        }
//
//    }
//
//
//    public static class Saying {
//        private long id;
//        private @Length(max = 10) String content;
//
//        public Saying(long id, String content) {
//            this.id = id;
//            this.content = content;
//        }
//
//        public Saying() {} // required for deserialization
//
//        @JsonProperty public long getId() { return id; }
//        @JsonProperty public String getContent() { return content; }
//    }
}
