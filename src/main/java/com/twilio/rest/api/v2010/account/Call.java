/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.api.v2010.account;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import com.twilio.type.Endpoint;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Call extends Resource {
    private static final long serialVersionUID = 133518260457854L;

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

        /**
         * Generate a Event from a string.
         * @param value string value
         * @return generated Event
         */
        @JsonCreator
        public static Event forValue(final String value) {
            return Promoter.enumFromString(value, Event.values());
        }
    }

    public enum Status {
        QUEUED("queued"),
        RINGING("ringing"),
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        BUSY("busy"),
        FAILED("failed"),
        NO_ANSWER("no-answer"),
        CANCELED("canceled");

        private final String value;

        private Status(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            return Promoter.enumFromString(value, Status.values());
        }
    }

    public enum UpdateStatus {
        CANCELED("canceled"),
        COMPLETED("completed");

        private final String value;

        private UpdateStatus(final String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        /**
         * Generate a UpdateStatus from a string.
         * @param value string value
         * @return generated UpdateStatus
         */
        @JsonCreator
        public static UpdateStatus forValue(final String value) {
            return Promoter.enumFromString(value, UpdateStatus.values());
        }
    }

    /**
     * Create a CallCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to Phone number, SIP address, or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param url The absolute URL that returns TwiML for this call
     * @return CallCreator capable of executing the create
     */
    public static CallCreator creator(final String pathAccountSid,
                                      final com.twilio.type.Endpoint to,
                                      final com.twilio.type.Endpoint from,
                                      final URI url) {
        return new CallCreator(pathAccountSid, to, from, url);
    }

    /**
     * Create a CallCreator to execute create.
     *
     * @param to Phone number, SIP address, or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param url The absolute URL that returns TwiML for this call
     * @return CallCreator capable of executing the create
     */
    public static CallCreator creator(final com.twilio.type.Endpoint to,
                                      final com.twilio.type.Endpoint from,
                                      final URI url) {
        return new CallCreator(to, from, url);
    }

    /**
     * Create a CallCreator to execute create.
     *
     * @param pathAccountSid The SID of the Account that will create the resource
     * @param to Phone number, SIP address, or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param applicationSid The SID of the Application resource that will handle
     *                       the call
     * @return CallCreator capable of executing the create
     */
    public static CallCreator creator(final String pathAccountSid,
                                      final com.twilio.type.Endpoint to,
                                      final com.twilio.type.Endpoint from,
                                      final String applicationSid) {
        return new CallCreator(pathAccountSid, to, from, applicationSid);
    }

    /**
     * Create a CallCreator to execute create.
     *
     * @param to Phone number, SIP address, or client identifier to call
     * @param from Twilio number from which to originate the call
     * @param applicationSid The SID of the Application resource that will handle
     *                       the call
     * @return CallCreator capable of executing the create
     */
    public static CallCreator creator(final com.twilio.type.Endpoint to,
                                      final com.twilio.type.Endpoint from,
                                      final String applicationSid) {
        return new CallCreator(to, from, applicationSid);
    }

    /**
     * Create a CallDeleter to execute delete.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       delete
     * @param pathSid The unique string that identifies this resource
     * @return CallDeleter capable of executing the delete
     */
    public static CallDeleter deleter(final String pathAccountSid,
                                      final String pathSid) {
        return new CallDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a CallDeleter to execute delete.
     *
     * @param pathSid The unique string that identifies this resource
     * @return CallDeleter capable of executing the delete
     */
    public static CallDeleter deleter(final String pathSid) {
        return new CallDeleter(pathSid);
    }

    /**
     * Create a CallFetcher to execute fetch.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       fetch
     * @param pathSid The SID of the Call resource to fetch
     * @return CallFetcher capable of executing the fetch
     */
    public static CallFetcher fetcher(final String pathAccountSid,
                                      final String pathSid) {
        return new CallFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a CallFetcher to execute fetch.
     *
     * @param pathSid The SID of the Call resource to fetch
     * @return CallFetcher capable of executing the fetch
     */
    public static CallFetcher fetcher(final String pathSid) {
        return new CallFetcher(pathSid);
    }

    /**
     * Create a CallReader to execute read.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       read
     * @return CallReader capable of executing the read
     */
    public static CallReader reader(final String pathAccountSid) {
        return new CallReader(pathAccountSid);
    }

    /**
     * Create a CallReader to execute read.
     *
     * @return CallReader capable of executing the read
     */
    public static CallReader reader() {
        return new CallReader();
    }

    /**
     * Create a CallUpdater to execute update.
     *
     * @param pathAccountSid The SID of the Account that created the resource(s) to
     *                       update
     * @param pathSid The unique string that identifies this resource
     * @return CallUpdater capable of executing the update
     */
    public static CallUpdater updater(final String pathAccountSid,
                                      final String pathSid) {
        return new CallUpdater(pathAccountSid, pathSid);
    }

    /**
     * Create a CallUpdater to execute update.
     *
     * @param pathSid The unique string that identifies this resource
     * @return CallUpdater capable of executing the update
     */
    public static CallUpdater updater(final String pathSid) {
        return new CallUpdater(pathSid);
    }

    /**
     * Converts a JSON String into a Call object using the provided ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Call object represented by the provided JSON
     */
    public static Call fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Call.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Call object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Call object represented by the provided JSON
     */
    public static Call fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Call.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String annotation;
    private final String answeredBy;
    private final String apiVersion;
    private final String callerName;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String direction;
    private final String duration;
    private final DateTime endTime;
    private final String forwardedFrom;
    private final String from;
    private final String fromFormatted;
    private final String groupSid;
    private final String parentCallSid;
    private final String phoneNumberSid;
    private final String price;
    private final Currency priceUnit;
    private final String sid;
    private final DateTime startTime;
    private final Call.Status status;
    private final Map<String, String> subresourceUris;
    private final String to;
    private final String toFormatted;
    private final String uri;

    @JsonCreator
    private Call(@JsonProperty("account_sid")
                 final String accountSid,
                 @JsonProperty("annotation")
                 final String annotation,
                 @JsonProperty("answered_by")
                 final String answeredBy,
                 @JsonProperty("api_version")
                 final String apiVersion,
                 @JsonProperty("caller_name")
                 final String callerName,
                 @JsonProperty("date_created")
                 final String dateCreated,
                 @JsonProperty("date_updated")
                 final String dateUpdated,
                 @JsonProperty("direction")
                 final String direction,
                 @JsonProperty("duration")
                 final String duration,
                 @JsonProperty("end_time")
                 final String endTime,
                 @JsonProperty("forwarded_from")
                 final String forwardedFrom,
                 @JsonProperty("from")
                 final String from,
                 @JsonProperty("from_formatted")
                 final String fromFormatted,
                 @JsonProperty("group_sid")
                 final String groupSid,
                 @JsonProperty("parent_call_sid")
                 final String parentCallSid,
                 @JsonProperty("phone_number_sid")
                 final String phoneNumberSid,
                 @JsonProperty("price")
                 final String price,
                 @JsonProperty("price_unit")
                 @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                 final Currency priceUnit,
                 @JsonProperty("sid")
                 final String sid,
                 @JsonProperty("start_time")
                 final String startTime,
                 @JsonProperty("status")
                 final Call.Status status,
                 @JsonProperty("subresource_uris")
                 final Map<String, String> subresourceUris,
                 @JsonProperty("to")
                 final String to,
                 @JsonProperty("to_formatted")
                 final String toFormatted,
                 @JsonProperty("uri")
                 final String uri) {
        this.accountSid = accountSid;
        this.annotation = annotation;
        this.answeredBy = answeredBy;
        this.apiVersion = apiVersion;
        this.callerName = callerName;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.direction = direction;
        this.duration = duration;
        this.endTime = DateConverter.rfc2822DateTimeFromString(endTime);
        this.forwardedFrom = forwardedFrom;
        this.from = from;
        this.fromFormatted = fromFormatted;
        this.groupSid = groupSid;
        this.parentCallSid = parentCallSid;
        this.phoneNumberSid = phoneNumberSid;
        this.price = price;
        this.priceUnit = priceUnit;
        this.sid = sid;
        this.startTime = DateConverter.rfc2822DateTimeFromString(startTime);
        this.status = status;
        this.subresourceUris = subresourceUris;
        this.to = to;
        this.toFormatted = toFormatted;
        this.uri = uri;
    }

    /**
     * Returns The The SID of the Account that created this resource.
     *
     * @return The SID of the Account that created this resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The annotation provided for the call.
     *
     * @return The annotation provided for the call
     */
    public final String getAnnotation() {
        return this.annotation;
    }

    /**
     * Returns The Either `human` or `machine` if this call was initiated with
     * answering machine detection. Empty otherwise..
     *
     * @return Either `human` or `machine` if this call was initiated with
     *         answering machine detection. Empty otherwise.
     */
    public final String getAnsweredBy() {
        return this.answeredBy;
    }

    /**
     * Returns The The API Version used to create the call.
     *
     * @return The API Version used to create the call
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The caller's name if this call was an incoming call to a phone
     * number with caller ID Lookup enabled. Otherwise, empty..
     *
     * @return The caller's name if this call was an incoming call to a phone
     *         number with caller ID Lookup enabled. Otherwise, empty.
     */
    public final String getCallerName() {
        return this.callerName;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that this resource was created.
     *
     * @return The RFC 2822 date and time in GMT that this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The RFC 2822 date and time in GMT that this resource was last
     * updated.
     *
     * @return The RFC 2822 date and time in GMT that this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The A string describing the direction of the call. `inbound` for
     * inbound calls, `outbound-api` for calls initiated via the REST API or
     * `outbound-dial` for calls initiated by a `Dial` verb..
     *
     * @return A string describing the direction of the call. `inbound` for inbound
     *         calls, `outbound-api` for calls initiated via the REST API or
     *         `outbound-dial` for calls initiated by a `Dial` verb.
     */
    public final String getDirection() {
        return this.direction;
    }

    /**
     * Returns The The length of the call in seconds..
     *
     * @return The length of the call in seconds.
     */
    public final String getDuration() {
        return this.duration;
    }

    /**
     * Returns The The end time of the call. Null if the call did not complete
     * successfully..
     *
     * @return The end time of the call. Null if the call did not complete
     *         successfully.
     */
    public final DateTime getEndTime() {
        return this.endTime;
    }

    /**
     * Returns The The forwarding phone number if this call was an incoming call
     * forwarded from another number (depends on carrier supporting forwarding).
     * Otherwise, empty..
     *
     * @return The forwarding phone number if this call was an incoming call
     *         forwarded from another number (depends on carrier supporting
     *         forwarding). Otherwise, empty.
     */
    public final String getForwardedFrom() {
        return this.forwardedFrom;
    }

    /**
     * Returns The The phone number, SIP address or Client identifier that made this
     * call. Phone numbers are in E.164 format (e.g., +16175551212). SIP addresses
     * are formatted as `name@company.com`. Client identifiers are formatted
     * `client:name`..
     *
     * @return The phone number, SIP address or Client identifier that made this
     *         call. Phone numbers are in E.164 format (e.g., +16175551212). SIP
     *         addresses are formatted as `name@company.com`. Client identifiers are
     *         formatted `client:name`.
     */
    public final String getFrom() {
        return this.from;
    }

    /**
     * Returns The The calling phone number, SIP address, or Client identifier
     * formatted for display..
     *
     * @return The calling phone number, SIP address, or Client identifier
     *         formatted for display.
     */
    public final String getFromFormatted() {
        return this.fromFormatted;
    }

    /**
     * Returns The The Group SID associated with this call. If no Group is
     * associated with the call, the field is empty..
     *
     * @return The Group SID associated with this call. If no Group is associated
     *         with the call, the field is empty.
     */
    public final String getGroupSid() {
        return this.groupSid;
    }

    /**
     * Returns The The SID that identifies the call that created this leg..
     *
     * @return The SID that identifies the call that created this leg.
     */
    public final String getParentCallSid() {
        return this.parentCallSid;
    }

    /**
     * Returns The If the call was inbound, this is the SID of the
     * IncomingPhoneNumber resource that received the call. If the call was
     * outbound, it is the SID of the OutgoingCallerId resource from which the call
     * was placed..
     *
     * @return If the call was inbound, this is the SID of the IncomingPhoneNumber
     *         resource that received the call. If the call was outbound, it is the
     *         SID of the OutgoingCallerId resource from which the call was placed.
     */
    public final String getPhoneNumberSid() {
        return this.phoneNumberSid;
    }

    /**
     * Returns The The charge for this call, in the currency associated with the
     * account. Populated after the call is completed. May not be immediately
     * available..
     *
     * @return The charge for this call, in the currency associated with the
     *         account. Populated after the call is completed. May not be
     *         immediately available.
     */
    public final String getPrice() {
        return this.price;
    }

    /**
     * Returns The The currency in which `Price` is measured..
     *
     * @return The currency in which `Price` is measured.
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The unique string that identifies this resource.
     *
     * @return The unique string that identifies this resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The start time of the call. Null if the call has not yet been
     * dialed..
     *
     * @return The start time of the call. Null if the call has not yet been dialed.
     */
    public final DateTime getStartTime() {
        return this.startTime;
    }

    /**
     * Returns The The status of this call..
     *
     * @return The status of this call.
     */
    public final Call.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The A list of related subresources identified by their relative URIs.
     *
     * @return A list of related subresources identified by their relative URIs
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    /**
     * Returns The The phone number, SIP address or Client identifier that received
     * this call. Phone numbers are in E.164 format (e.g., +16175551212). SIP
     * addresses are formatted as `name@company.com`. Client identifiers are
     * formatted `client:name`..
     *
     * @return The phone number, SIP address or Client identifier that received
     *         this call. Phone numbers are in E.164 format (e.g., +16175551212).
     *         SIP addresses are formatted as `name@company.com`. Client identifiers
     *         are formatted `client:name`.
     */
    public final String getTo() {
        return this.to;
    }

    /**
     * Returns The The phone number, SIP address or Client identifier that received
     * this call. Formatted for display..
     *
     * @return The phone number, SIP address or Client identifier that received
     *         this call. Formatted for display.
     */
    public final String getToFormatted() {
        return this.toFormatted;
    }

    /**
     * Returns The The URI of this resource, relative to `https://api.twilio.com`.
     *
     * @return The URI of this resource, relative to `https://api.twilio.com`
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Call other = (Call) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(annotation, other.annotation) &&
               Objects.equals(answeredBy, other.answeredBy) &&
               Objects.equals(apiVersion, other.apiVersion) &&
               Objects.equals(callerName, other.callerName) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(direction, other.direction) &&
               Objects.equals(duration, other.duration) &&
               Objects.equals(endTime, other.endTime) &&
               Objects.equals(forwardedFrom, other.forwardedFrom) &&
               Objects.equals(from, other.from) &&
               Objects.equals(fromFormatted, other.fromFormatted) &&
               Objects.equals(groupSid, other.groupSid) &&
               Objects.equals(parentCallSid, other.parentCallSid) &&
               Objects.equals(phoneNumberSid, other.phoneNumberSid) &&
               Objects.equals(price, other.price) &&
               Objects.equals(priceUnit, other.priceUnit) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(startTime, other.startTime) &&
               Objects.equals(status, other.status) &&
               Objects.equals(subresourceUris, other.subresourceUris) &&
               Objects.equals(to, other.to) &&
               Objects.equals(toFormatted, other.toFormatted) &&
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            annotation,
                            answeredBy,
                            apiVersion,
                            callerName,
                            dateCreated,
                            dateUpdated,
                            direction,
                            duration,
                            endTime,
                            forwardedFrom,
                            from,
                            fromFormatted,
                            groupSid,
                            parentCallSid,
                            phoneNumberSid,
                            price,
                            priceUnit,
                            sid,
                            startTime,
                            status,
                            subresourceUris,
                            to,
                            toFormatted,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("annotation", annotation)
                          .add("answeredBy", answeredBy)
                          .add("apiVersion", apiVersion)
                          .add("callerName", callerName)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("direction", direction)
                          .add("duration", duration)
                          .add("endTime", endTime)
                          .add("forwardedFrom", forwardedFrom)
                          .add("from", from)
                          .add("fromFormatted", fromFormatted)
                          .add("groupSid", groupSid)
                          .add("parentCallSid", parentCallSid)
                          .add("phoneNumberSid", phoneNumberSid)
                          .add("price", price)
                          .add("priceUnit", priceUnit)
                          .add("sid", sid)
                          .add("startTime", startTime)
                          .add("status", status)
                          .add("subresourceUris", subresourceUris)
                          .add("to", to)
                          .add("toFormatted", toFormatted)
                          .add("uri", uri)
                          .toString();
    }
}