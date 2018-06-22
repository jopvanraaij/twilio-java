/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.ipmessaging.v2.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Binding extends Resource {
    private static final long serialVersionUID = 102481637129176L;

    public enum BindingType {
        GCM("gcm"),
        APN("apn"),
        FCM("fcm");

        private final String value;

        private BindingType(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a BindingType from a string.
         * @param value string value
         * @return generated BindingType
         */
        @JsonCreator
        public static BindingType forValue(final String value) {
            return Promoter.enumFromString(value, BindingType.values());
        }
    }

    /**
     * Create a BindingReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @return BindingReader capable of executing the read
     */
    public static BindingReader reader(final String pathServiceSid) {
        return new BindingReader(pathServiceSid);
    }

    /**
     * Create a BindingFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     * @return BindingFetcher capable of executing the fetch
     */
    public static BindingFetcher fetcher(final String pathServiceSid, 
                                         final String pathSid) {
        return new BindingFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a BindingDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     * @return BindingDeleter capable of executing the delete
     */
    public static BindingDeleter deleter(final String pathServiceSid, 
                                         final String pathSid) {
        return new BindingDeleter(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a Binding object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Binding object represented by the provided JSON
     */
    public static Binding fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Binding.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Binding object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Binding object represented by the provided JSON
     */
    public static Binding fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Binding.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String endpoint;
    private final String identity;
    private final String credentialSid;
    private final Binding.BindingType bindingType;
    private final List<String> messageTypes;
    private final URI url;
    private final Map<String, String> links;

    @JsonCreator
    private Binding(@JsonProperty("sid")
                    final String sid, 
                    @JsonProperty("account_sid")
                    final String accountSid, 
                    @JsonProperty("service_sid")
                    final String serviceSid, 
                    @JsonProperty("date_created")
                    final String dateCreated, 
                    @JsonProperty("date_updated")
                    final String dateUpdated, 
                    @JsonProperty("endpoint")
                    final String endpoint, 
                    @JsonProperty("identity")
                    final String identity, 
                    @JsonProperty("credential_sid")
                    final String credentialSid, 
                    @JsonProperty("binding_type")
                    final Binding.BindingType bindingType, 
                    @JsonProperty("message_types")
                    final List<String> messageTypes, 
                    @JsonProperty("url")
                    final URI url, 
                    @JsonProperty("links")
                    final Map<String, String> links) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.endpoint = endpoint;
        this.identity = identity;
        this.credentialSid = credentialSid;
        this.bindingType = bindingType;
        this.messageTypes = messageTypes;
        this.url = url;
        this.links = links;
    }

    /**
     * Returns The A 34 character string that uniquely identifies this resource..
     * 
     * @return A 34 character string that uniquely identifies this resource.
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The unique id of the Account responsible for this binding..
     * 
     * @return The unique id of the Account responsible for this binding.
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The unique id of the Service this binding belongs to..
     * 
     * @return The unique id of the Service this binding belongs to.
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The date that this resource was created..
     * 
     * @return The date that this resource was created.
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date that this resource was last updated..
     * 
     * @return The date that this resource was last updated.
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The unique endpoint identifier for this Binding..
     * 
     * @return The unique endpoint identifier for this Binding.
     */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /**
     * Returns The A unique string identifier for the Binding for this User in this
     * Service..
     * 
     * @return A unique string identifier for the Binding for this User in this
     *         Service.
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The The unique id of the Credential for this binding..
     * 
     * @return The unique id of the Credential for this binding.
     */
    public final String getCredentialSid() {
        return this.credentialSid;
    }

    /**
     * Returns The The push technology to use for this binding..
     * 
     * @return The push technology to use for this binding.
     */
    public final Binding.BindingType getBindingType() {
        return this.bindingType;
    }

    /**
     * Returns The List of message types for this binding..
     * 
     * @return List of message types for this binding.
     */
    public final List<String> getMessageTypes() {
        return this.messageTypes;
    }

    /**
     * Returns The An absolute URL for this binding..
     * 
     * @return An absolute URL for this binding.
     */
    public final URI getUrl() {
        return this.url;
    }

    /**
     * Returns The Absolute URLs to access the Users for this Binding..
     * 
     * @return Absolute URLs to access the Users for this Binding.
     */
    public final Map<String, String> getLinks() {
        return this.links;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Binding other = (Binding) o;

        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(endpoint, other.endpoint) && 
               Objects.equals(identity, other.identity) && 
               Objects.equals(credentialSid, other.credentialSid) && 
               Objects.equals(bindingType, other.bindingType) && 
               Objects.equals(messageTypes, other.messageTypes) && 
               Objects.equals(url, other.url) && 
               Objects.equals(links, other.links);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            dateCreated,
                            dateUpdated,
                            endpoint,
                            identity,
                            credentialSid,
                            bindingType,
                            messageTypes,
                            url,
                            links);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("endpoint", endpoint)
                          .add("identity", identity)
                          .add("credentialSid", credentialSid)
                          .add("bindingType", bindingType)
                          .add("messageTypes", messageTypes)
                          .add("url", url)
                          .add("links", links)
                          .toString();
    }
}