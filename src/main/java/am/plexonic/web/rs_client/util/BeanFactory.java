package am.plexonic.web.rs_client.util;

import am.plexonic.common.rs_utils.WSClientUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.client.Client;

/**
 * Bean factory.
 */
@Configuration("bankserverClientBeanFactory")
public class BeanFactory {
    @Bean
    public Client bsWSClient() {
        return WSClientUtils.create();
    }
}
