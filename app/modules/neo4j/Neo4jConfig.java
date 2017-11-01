package modules.neo4j;

import javax.inject.*;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import play.inject.ApplicationLifecycle;
import java.util.concurrent.CompletableFuture;


@Singleton
public class Neo4jConfig {

    private SessionFactory sessionFactory;
    play.api.Configuration cfg;

    @Inject
    public Neo4jConfig(ApplicationLifecycle lifecycle, play.api.Configuration configuration) {

        this.cfg = configuration;
        startService();

        lifecycle.addStopHook(() -> {
            sessionFactory.close();
            return CompletableFuture.completedFuture(null);
        });       
    }

    private void startService(){
        try {
            Configuration configuration = new Configuration.Builder()
                    .uri(cfg.underlying().getString("neo4jUrl"))
                    .credentials(cfg.underlying().getString("neo4jUser"),cfg.underlying().getString("neo4jPassword"))
                    .connectionPoolSize(150)
                    .encryptionLevel("REQUIRED")
                    .build();

            /*configuration.driverConfiguration()
                    .setDriverClassName("org.neo4j.ogm.drivers.bolt.driver.BoltDriver")
                    .setURI(cfg.underlying().getString("neo4jUrl"))
                    .setCredentials(cfg.underlying().getString("neo4jUser"),cfg.underlying().getString("neo4jPassword"))
                    .setConnectionPoolSize(150)
                    .setEncryptionLevel("REQUIRED");*/

            sessionFactory = new SessionFactory(configuration,"nodes");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public Session getSession(){
        if(sessionFactory == null){
            startService();
            if(sessionFactory == null){
                return null;
            }
        }
        return sessionFactory.openSession();
    }

}