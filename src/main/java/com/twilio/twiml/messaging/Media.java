/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.twiml.messaging;

import com.twilio.converter.Promoter;
import com.twilio.twiml.TwiML;

import java.net.URI;

/**
 * TwiML wrapper for {@code <Media>}
 */
public class Media extends TwiML {
    private final URI url;

    /**
     * For XML Serialization/Deserialization
     */
    private Media() {
        this(new Builder((URI) null));
    }

    /**
     * Create a new {@code <Media>} element
     */
    private Media(Builder b) {
        super("Media", b);
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
     * Media URL
     * 
     * @return Media URL
     */
    public URI getUrl() {
        return url;
    }

    /**
     * Create a new {@code <Media>} element
     */
    public static class Builder extends TwiML.Builder<Builder> {
        private URI url;

        /**
         * Create a {@code <Media>} with url
         */
        public Builder(URI url) {
            this.url = url;
        }

        /**
         * Create a {@code <Media>} with url
         */
        public Builder(String url) {
            this.url = Promoter.uriFromString(url);
        }

        /**
         * Create and return resulting {@code <Media>} element
         */
        public Media build() {
            return new Media(this);
        }
    }
}