package am.plexonic.common.rs_utils;

import am.plexonic.common.rs_utils.exception.ServerUnavailableException;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.uri.UriComponent;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Ws client utilities.
 */
public final class WSClientUtils {
    /**
     * The parameter's placeholder prefix.
     */
    public static final char PLACEHOLDER_PREFIX = '{';
    /**
     * The parameter's placeholder suffix.
     */
    public static final char PLACEHOLDER_SUFFIX = '}';

    /**
     * The multi value parameter name.
     */
    public static final String MULTI_VALUE_PARAMETER_NAME = "fields";

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
//                MultiPartFeature.class,
                JacksonJaxbJsonProvider.class,
                JacksonJsonProvider.class/*,
                JacksonCustomConfigurator.class*/);
        return ClientBuilder.newClient(clientConfig);
    }

    /**
     * Formats the url by replacing placeholders with the corresponding values.
     *
     * @param url    the url to be formatted
     * @param values the values
     * @return the formatted url
     */
    public static String formatUrl(String url, Object... values) {
        Object[] newValues = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = String.valueOf(values[i]);
        }
        return MessageFormat.format(url, newValues);
    }

    /**
     * Formats the url by replacing placeholders with the corresponding values.
     *
     * @param url    the url to be formatted
     * @param values the values
     * @return the formatted url
     */
    public static String formatUrl(String url, Map<String, Object> values) {
        for (Map.Entry<String, Object> value : values.entrySet()) {
            url = url.replace(PLACEHOLDER_PREFIX + value.getKey() + PLACEHOLDER_SUFFIX
                    , String.valueOf(value.getValue()));
        }
        return url;
    }

    /**
     * Encodes path param.
     *
     * @param value the value
     * @return the encoded value of path param
     */
    public static String encodePathParam(Object value) {
        return encodeUriComponent(value, UriComponent.Type.QUERY);
    }

    /**
     * Encodes query param.
     *
     * @param value the value
     * @return the encoded value of query param
     */
    public static String encodeQueryParam(Object value) {
        return encodeUriComponent(value, UriComponent.Type.QUERY_PARAM);
    }

    /**
     * Encodes uri component param.
     *
     * @param value the value
     * @return the encoded value of uri component param
     */
    public static String encodeUriComponent(Object value, UriComponent.Type type) {
        return UriComponent.encode(value.toString(), type);
    }

    /**
     * Creates multi value form data request entity.
     *
     * @param fields the fields
     * @return the form data request entity
     */
    public static Form createMultiValueForm(List<String> fields) {
        return fillInMultiValueForm(new Form(), fields);
    }

    /**
     * Fills in multi value form data request entity.
     *
     * @param form   the form
     * @param fields the fields
     * @return the form data request entity
     */
    public static Form fillInMultiValueForm(Form form, List<String> fields) {
        if (fields != null) {
            for (String field : fields) {
                form.param(MULTI_VALUE_PARAMETER_NAME, field);
            }
            return form;
        }

        throw new IllegalArgumentException("Fields can not be null");
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

    /**
     * Reads the binary response.
     *
     * @param httpResponse the http response
     * @return the result of type byte[]
     * @throws IOException if I/O exception of some sort has occurred
     */
    public static byte[] readBinaryResponse(Response httpResponse) throws IOException {
        InputStream in = httpResponse.readEntity(InputStream.class);
        if (in != null) {
            return IOUtils.toByteArray(in);
        }

        return null;
    }
}
