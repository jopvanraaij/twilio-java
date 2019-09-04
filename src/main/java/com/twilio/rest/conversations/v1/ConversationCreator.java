/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.conversations.v1;

import com.twilio.base.Creator;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class ConversationCreator extends Creator<Conversation> {
    private String friendlyName;
    private DateTime dateCreated;
    private DateTime dateUpdated;
    private String messagingServiceSid;
    private String attributes;

    /**
     * The human-readable name of this conversation, limited to 256 characters.
     * Optional..
     *
     * @param friendlyName The human-readable name of this conversation.
     * @return this
     */
    public ConversationCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The date that this resource was created..
     *
     * @param dateCreated The date that this resource was created.
     * @return this
     */
    public ConversationCreator setDateCreated(final DateTime dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    /**
     * The date that this resource was last updated..
     *
     * @param dateUpdated The date that this resource was last updated.
     * @return this
     */
    public ConversationCreator setDateUpdated(final DateTime dateUpdated) {
        this.dateUpdated = dateUpdated;
        return this;
    }

    /**
     * The unique id of the [SMS
     * Service](https://www.twilio.com/docs/sms/services/api) this conversation
     * belongs to..
     *
     * @param messagingServiceSid The unique id of the SMS Service this
     *                            conversation belongs to.
     * @return this
     */
    public ConversationCreator setMessagingServiceSid(final String messagingServiceSid) {
        this.messagingServiceSid = messagingServiceSid;
        return this;
    }

    /**
     * An optional string metadata field you can use to store any data you wish. The
     * string value must contain structurally valid JSON if specified.  **Note**
     * that if the attributes are not set "{}" will be returned..
     *
     * @param attributes An optional string metadata field you can use to store any
     *                   data you wish.
     * @return this
     */
    public ConversationCreator setAttributes(final String attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Created Conversation
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Conversation create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CONVERSATIONS.toString(),
            "/v1/Conversations",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Conversation creation failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Conversation.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (dateCreated != null) {
            request.addPostParam("DateCreated", dateCreated.toString());
        }

        if (dateUpdated != null) {
            request.addPostParam("DateUpdated", dateUpdated.toString());
        }

        if (messagingServiceSid != null) {
            request.addPostParam("MessagingServiceSid", messagingServiceSid);
        }

        if (attributes != null) {
            request.addPostParam("Attributes", attributes);
        }
    }
}