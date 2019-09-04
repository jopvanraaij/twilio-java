/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service;

import com.twilio.base.Updater;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class DocumentUpdater extends Updater<Document> {
    private final String pathServiceSid;
    private final String pathSid;
    private Map<String, Object> data;
    private Integer ttl;

    /**
     * Construct a new DocumentUpdater.
     *
     * @param pathServiceSid The SID of the Sync Service with the Document resource
     *                       to update
     * @param pathSid The SID of the Document resource to update
     */
    public DocumentUpdater(final String pathServiceSid,
                           final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathSid = pathSid;
    }

    /**
     * A JSON string that represents an arbitrary, schema-less object that the Sync
     * Document stores. Can be up to 16KB in length..
     *
     * @param data A JSON string that represents an arbitrary, schema-less object
     *             that the Sync Document stores
     * @return this
     */
    public DocumentUpdater setData(final Map<String, Object> data) {
        this.data = data;
        return this;
    }

    /**
     * How long, in seconds, before the Sync Document expires and is deleted
     * (time-to-live). Can be an integer from 0 to 31,536,000 (1 year). The default
     * value is `0`, which means the Document resource does not expire. The Document
     * resource might not be deleted immediately after it expires..
     *
     * @param ttl How long, in seconds, before the Document resource expires and is
     *            deleted
     * @return this
     */
    public DocumentUpdater setTtl(final Integer ttl) {
        this.ttl = ttl;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Document
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Document update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Documents/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Document update failed: Unable to connect to server");
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

        return Document.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (data != null) {
            request.addPostParam("Data", Converter.mapToJson(data));
        }

        if (ttl != null) {
            request.addPostParam("Ttl", ttl.toString());
        }
    }
}