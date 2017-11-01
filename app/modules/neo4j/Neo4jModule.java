package modules.neo4j;

import com.google.inject.AbstractModule;

public class Neo4jModule extends AbstractModule {

    @Override
    public void configure() {
        bind(Neo4jConfig.class).asEagerSingleton();
    }   

}