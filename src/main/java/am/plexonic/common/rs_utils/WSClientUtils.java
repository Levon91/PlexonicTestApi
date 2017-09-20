package am.plexonic.common.rs_utils;

import am.plexonic.common.rs_utils.exception.ServerUnavailableException;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

/**
 * Ws client utilities.
 */
public final class WSClientUtils {
    /**
     * The private constructor.
     */
    private WSClientUtils() {
    }

    /**
     * Creates the new client instance configured with specific features.
     *
     * @return the new client instance
     */
    public static Client create() {
        ClientConfig clientConfig = new ClientConfig(JacksonFeature.class,
                JacksonJaxbJsonProvider.class,
                JacksonJsonProvider.class);
        return ClientBuilder.newClient(clientConfig);
    }

    /**
     * Logs the passed message and returns WebApplicationException with the passed message.
     *
     * @param message the message
     * @return the exception of type {@link WebApplicationException}
     */
    public static WebApplicationException getExceptionBy(String message) {

        return new WebApplicationException(Response.serverError()
                .entity(message).build());
    }

    /**
     * Logs the passed message and returns WebApplicationException with the passed status and message.
     *
     * @param status  the status
     * @param message the message
     * @return the exception of type {@link WebApplicationException}
     */
    public static WebApplicationException getExceptionBy(int status, String message) {

        return new WebApplicationException(
                Response.status(Response.Status.fromStatusCode(status))
                        .entity(message).build()
        );
    }

    /**
     * Returns ServerUnavailableException with the passed url and cause.
     *
     * @param url the url
     * @param e   the cause
     * @return the exception of type {@link ServerUnavailableException}
     */
    public static ServerUnavailableException getServerUnavailableException(String url, Throwable e) {
        return new ServerUnavailableException("Could not connect to remote host [url: " + url + "]", e);
    }
}
