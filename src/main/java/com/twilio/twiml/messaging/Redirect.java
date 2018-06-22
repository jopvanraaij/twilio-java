/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.messaging;

import com.twilio.converter.Promoter;
import com.twilio.http.HttpMethod;
import com.twilio.twiml.TwiML;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * TwiML wrapper for {@code <Redirect>}
 */
public class Redirect extends TwiML {
    private final HttpMethod method;
    private final URI url;

    /**
     * For XML Serialization/Deserialization
     */
    private Redirect() {
        this(new Builder((URI) null));
    }

    /**
     * Create a new {@code <Redirect>} element
     */
    private Redirect(Builder b) {
        super("Redirect", b);
        this.method = b.method;
        this.url = b.url;
    }

    /**
     * The body of the TwiML element
     * 
     * @return Element body as a string if present else null
     */
    protected String getElementBody() {
        return this.getUrl() == null ? null : this.getUrl().toString();
    }

    /**
     * Attributes to set on the generated XML element
     * 
     * @return A Map of attribute keys to values
     */
    protected Map<String, String> getElementAttributes() {
        // Preserve order of attributes
        Map<String, String> attrs = new HashMap<>();

        if (this.getMethod() != null) {
            attrs.put("method", this.getMethod().toString());
        }

        return attrs;
    }

    /**
     * Redirect URL method
     * 
     * @return Redirect URL method
     */
    public HttpMethod getMethod() {
        return method;
    }

    /**
     * Redirect URL
     * 
     * @return Redirect URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * Create a new {@code <Redirect>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private HttpMethod method;
        private URI url;

        /**
         * Create a {@code <Redirect>} with url
         */
        public Builder(URI url) {
            this.url = url;
        }

        /**
         * Create a {@code <Redirect>} with url
         */
        public Builder(String url) {
            this.url = Promoter.uriFromString(url);
        }

        /**
         * Redirect URL method
         */
        public Builder method(HttpMethod method) {
            this.method = method;
            return this;
        }

        /**
         * Create and return resulting {@code <Redirect>} element
         */
        public Redirect build() {
            return new Redirect(this);
        }
    }
}