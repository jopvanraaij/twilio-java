/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.wireless.v1;

import com.twilio.base.Page;
import com.twilio.base.Reader;
import com.twilio.base.ResourceSet;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class SimReader extends Reader<Sim> {
    private Sim.Status status;
    private String iccid;
    private String ratePlan;
    private String eId;
    private String simRegistrationCode;

    /**
     * Only return Sim resources with this status..
     *
     * @param status Only return Sim resources with this status
     * @return this
     */
    public SimReader setStatus(final Sim.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Only return Sim resources with this ICCID. Currently this should be a list
     * with maximum size 1..
     *
     * @param iccid Only return Sim resources with this ICCID
     * @return this
     */
    public SimReader setIccid(final String iccid) {
        this.iccid = iccid;
        return this;
    }

    /**
     * The `sid` or `unique_name` of the [RatePlan
     * resource](https://www.twilio.com/docs/wireless/api/rate-plan) used by the Sim
     * resources to read..
     *
     * @param ratePlan Only return Sim resources with this Rate Plan
     * @return this
     */
    public SimReader setRatePlan(final String ratePlan) {
        this.ratePlan = ratePlan;
        return this;
    }

    /**
     * Deprecated..
     *
     * @param eId Deprecated
     * @return this
     */
    public SimReader setEId(final String eId) {
        this.eId = eId;
        return this;
    }

    /**
     * Only return Sim resources with this registration code..
     *
     * @param simRegistrationCode Only return Sim resources with this registration
     *                            code
     * @return this
     */
    public SimReader setSimRegistrationCode(final String simRegistrationCode) {
        this.simRegistrationCode = simRegistrationCode;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Sim ResourceSet
     */
    @Override
    public ResourceSet<Sim> read(final TwilioRestClient client) {
        return new ResourceSet<>(this, client, firstPage(client));
    }

    /**
     * Make the request to the Twilio API to perform the read.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Sim ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Sim> firstPage(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.WIRELESS.toString(),
            "/v1/Sims",
            client.getRegion()
        );

        addQueryParams(request);
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the target page from the Twilio API.
     *
     * @param targetUrl API-generated URL for the requested results page
     * @param client TwilioRestClient with which to make the request
     * @return Sim ResourceSet
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Page<Sim> getPage(final String targetUrl, final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            targetUrl
        );

        return pageForRequest(client, request);
    }

    /**
     * Retrieve the next page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Next Page
     */
    @Override
    public Page<Sim> nextPage(final Page<Sim> page,
                              final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getNextPageUrl(
                Domains.WIRELESS.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Retrieve the previous page from the Twilio API.
     *
     * @param page current page
     * @param client TwilioRestClient with which to make the request
     * @return Previous Page
     */
    @Override
    public Page<Sim> previousPage(final Page<Sim> page,
                                  final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            page.getPreviousPageUrl(
                Domains.WIRELESS.toString(),
                client.getRegion()
            )
        );
        return pageForRequest(client, request);
    }

    /**
     * Generate a Page of Sim Resources for a given request.
     *
     * @param client TwilioRestClient with which to make the request
     * @param request Request to generate a page for
     * @return Page for the Request
     */
    private Page<Sim> pageForRequest(final TwilioRestClient client, final Request request) {
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Sim read failed: Unable to connect to server");
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

        return Page.fromJson(
            "sims",
            response.getContent(),
            Sim.class,
            client.getObjectMapper()
        );
    }

    /**
     * Add the requested query string arguments to the Request.
     *
     * @param request Request to add query string arguments to
     */
    private void addQueryParams(final Request request) {
        if (status != null) {
            request.addQueryParam("Status", status.toString());
        }

        if (iccid != null) {
            request.addQueryParam("Iccid", iccid);
        }

        if (ratePlan != null) {
            request.addQueryParam("RatePlan", ratePlan);
        }

        if (eId != null) {
            request.addQueryParam("EId", eId);
        }

        if (simRegistrationCode != null) {
            request.addQueryParam("SimRegistrationCode", simRegistrationCode);
        }

        if (getPageSize() != null) {
            request.addQueryParam("PageSize", Integer.toString(getPageSize()));
        }
    }
}