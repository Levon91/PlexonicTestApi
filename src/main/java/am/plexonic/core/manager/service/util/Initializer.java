package am.plexonic.core.manager.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * The initializer.
 */
@Component
public final class Initializer {

    @Autowired
    private InitializerContext initializerContext;

    @PostConstruct
    public void contextInitialized() {

        try {
            System.setProperty("file.encoding", "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
