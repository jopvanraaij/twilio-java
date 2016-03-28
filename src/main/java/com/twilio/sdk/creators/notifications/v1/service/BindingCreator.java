/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.creators.notifications.v1.service;

import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.converters.Promoter;
import com.twilio.sdk.creators.Creator;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.RestException;
import com.twilio.sdk.resources.notifications.v1.service.Binding;

import java.util.List;

public class BindingCreator extends Creator<Binding> {
    private final String serviceSid;
    private final String endpoint;
    private final String identity;
    private final Binding.BindingType bindingType;
    private final String address;
    private List<String> tag;
    private String notificationProtocolVersion;

    /**
     * Construct a new BindingCreator.
     * 
     * @param serviceSid The service_sid
     * @param endpoint The endpoint
     * @param identity The identity
     * @param bindingType The binding_type
     * @param address The address
     */
    public BindingCreator(final String serviceSid, 
                          final String endpoint, 
                          final String identity, 
                          final Binding.BindingType bindingType, 
                          final String address) {
        this.serviceSid = serviceSid;
        this.endpoint = endpoint;
        this.identity = identity;
        this.bindingType = bindingType;
        this.address = address;
    }

    /**
     * The tag.
     * 
     * @param tag The tag
     * @return this
     */
    public BindingCreator setTag(final List<String> tag) {
        this.tag = tag;
        return this;
    }

    /**
     * The tag.
     * 
     * @param tag The tag
     * @return this
     */
    public BindingCreator setTag(final String tag) {
        return setTag(Promoter.listOfOne(tag));
    }

    /**
     * The notification_protocol_version.
     * 
     * @param notificationProtocolVersion The notification_protocol_version
     * @return this
     */
    public BindingCreator setNotificationProtocolVersion(final String notificationProtocolVersion) {
        this.notificationProtocolVersion = notificationProtocolVersion;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Binding
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Binding execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.NOTIFICATIONS,
            "/v1/Services/" + this.serviceSid + "/Bindings",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Binding creation failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_CREATED) {
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
        
        return Binding.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (endpoint != null) {
            request.addPostParam("Endpoint", endpoint);
        }
        
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }
        
        if (bindingType != null) {
            request.addPostParam("BindingType", bindingType.toString());
        }
        
        if (address != null) {
            request.addPostParam("Address", address);
        }
        
        if (tag != null) {
            for (Object prop : tag) {
                request.addPostParam("Tag", prop.toString());
            }
        }
        
        if (notificationProtocolVersion != null) {
            request.addPostParam("NotificationProtocolVersion", notificationProtocolVersion);
        }
    }
}