/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.voice;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import com.twilio.twiml.TwiML;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Client>}
 */
public class Client extends TwiML {
    public enum Event {
        INITIATED("initiated"),
        RINGING("ringing"),
        ANSWERED("answered"),
        COMPLETED("completed");

        private final String value;

        private Event(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }
    }

    private final URI url;
    private final HttpMethod method;
    private final List<Client.Event> statusCallbackEvent;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String name;

    /**
     * For XML Serialization/Deserialization
     */
    private Client() {
        this(new Builder((String) null));
    }

    /**
     * Create a new {@code <Client>} element
     */
    private Client(Builder b) {
        super("Client", b);
        this.url = b.url;
        this.method = b.method;
        this.statusCallbackEvent = b.statusCallbackEvent;
        this.statusCallback = b.statusCallback;
        this.statusCallbackMethod = b.statusCallbackMethod;
        this.name = b.name;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getName() == null ? null : this.getName();
    }

    /**
     * Attributes to set on the generated XML element
     * 
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getUrl() != null) {
            attrs.put("url", this.getUrl().toString());
        }
        if (this.getMethod() != null) {
            attrs.put("method", this.getMethod().toString());
        }
        if (this.getStatusCallbackEvents() != null) {
            attrs.put("statusCallbackEvent", this.getStatusCallbackEventsAsString());
        }
        if (this.getStatusCallback() != null) {
            attrs.put("statusCallback", this.getStatusCallback().toString());
        }
        if (this.getStatusCallbackMethod() != null) {
            attrs.put("statusCallbackMethod", this.getStatusCallbackMethod().toString());
        }

        return attrs;
    }

    /**
     * Client URL
     * 
     * @return Client URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * Client URL Method
     * 
     * @return Client URL Method
     */
    public HttpMethod getMethod() {
        return method;
    }

    /**
     * Events to trigger status callback
     * 
     * @return Events to trigger status callback
     */
    public List<Client.Event> getStatusCallbackEvents() {
        return statusCallbackEvent;
    }

    protected String getStatusCallbackEventsAsString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Client.Event> iter = this.getStatusCallbackEvents().iterator();
        while (iter.hasNext()) {
            sb.append(iter.next().toString());
            if (iter.hasNext()) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    /**
     * Status Callback URL
     * 
     * @return Status Callback URL
     */
    public URI getStatusCallback() {
        return statusCallback;
    }

    /**
     * Status Callback URL Method
     * 
     * @return Status Callback URL Method
     */
    public HttpMethod getStatusCallbackMethod() {
        return statusCallbackMethod;
    }

    /**
     * Client name
     * 
     * @return Client name
     */
    public String getName() {
        return name;
    }

    /**
     * Create a new {@code <Client>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private URI url;
        private HttpMethod method;
        private List<Client.Event> statusCallbackEvent;
        private URI statusCallback;
        private HttpMethod statusCallbackMethod;
        private String name;

        /**
         * Create a {@code <Client>} with name
         */
        public Builder(String name) {
            this.name = name;
        }

        /**
         * Client URL
         */
        public Builder url(URI url) {
            this.url = url;
            return this;
        }

        /**
         * Client URL
         */
        public Builder url(String url) {
            this.url = Promoter.uriFromString(url);
            return this;
        }

        /**
         * Client URL Method
         */
        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        /**
         * Events to trigger status callback
         */
        public Builder statusCallbackEvents(List<Client.Event> statusCallbackEvent) {
            this.statusCallbackEvent = statusCallbackEvent;
            return this;
        }

        /**
         * Events to trigger status callback
         */
        public Builder statusCallbackEvents(Client.Event statusCallbackEvent) {
            this.statusCallbackEvent = Promoter.listOfOne(statusCallbackEvent);
            return this;
        }

        /**
         * Status Callback URL
         */
        public Builder statusCallback(URI statusCallback) {
            this.statusCallback = statusCallback;
            return this;
        }

        /**
         * Status Callback URL
         */
        public Builder statusCallback(String statusCallback) {
            this.statusCallback = Promoter.uriFromString(statusCallback);
            return this;
        }

        /**
         * Status Callback URL Method
         */
        public Builder statusCallbackMethod(HttpMethod statusCallbackMethod) {
            this.statusCallbackMethod = statusCallbackMethod;
            return this;
        }

        /**
         * Create and return resulting {@code <Client>} element
         */
        public Client build() {
            return new Client(this);
        }
    }
}