package am.plexonic.core.manager.service.util;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

/**
 * A set of initializer context properties.
 */
@Component
@DependsOn("initializer")
public final class InitializerContext {

    private InitializerContext() {
    }
}
