package am.plexonic.web.rs_client.impl;

import org.springframework.beans.factory.annotation.Value;

import javax.ws.rs.client.Client;

/**
 * The BaseServiceClient implementation.
 */
public abstract class BaseServiceClient {
    /**
     * Jersey REST client
     */
    protected Client client;

    /**
     * The server url.
     */
    @Value("http://localhost:8080/test-api/service")
    protected String serverUrl;

    /**
     * Regular constructor.
     *
     * @param client the client
     */
    public BaseServiceClient(Client client) {
        this.client = client;
    }

}
