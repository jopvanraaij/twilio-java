/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v1.flow;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class EngagementFetcher extends Fetcher<Engagement> {
    private final String pathFlowSid;
    private final String pathSid;

    /**
     * Construct a new EngagementFetcher.
     *
     * @param pathFlowSid Flow SID
     * @param pathSid The SID of the Engagement resource to fetch
     */
    public EngagementFetcher(final String pathFlowSid,
                             final String pathSid) {
        this.pathFlowSid = pathFlowSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched Engagement
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Engagement fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.STUDIO.toString(),
            "/v1/Flows/" + this.pathFlowSid + "/Engagements/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Engagement fetch failed: Unable to connect to server");
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

        return Engagement.fromJson(response.getStream(), client.getObjectMapper());
    }
}