package am.plexonic.core.manager.service.rs;

import am.plexonic.core.manager.service.util.InitializerContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base service
 */
public abstract class BaseService {

    @Autowired
    protected InitializerContext initializerContext;
}
