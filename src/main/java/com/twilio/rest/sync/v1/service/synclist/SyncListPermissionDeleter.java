/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.sync.v1.service.synclist;

import com.twilio.base.Deleter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class SyncListPermissionDeleter extends Deleter<SyncListPermission> {
    private final String pathServiceSid;
    private final String pathListSid;
    private final String pathIdentity;

    /**
     * Construct a new SyncListPermissionDeleter.
     *
     * @param pathServiceSid The SID of the Sync Service with the Sync List
     *                       Permission resource to delete
     * @param pathListSid The SID of the Sync List with the Sync List Permission
     *                    resource to delete
     * @param pathIdentity The application-defined string that uniquely identifies
     *                     the User's Sync List Permission resource to delete
     */
    public SyncListPermissionDeleter(final String pathServiceSid,
                                     final String pathListSid,
                                     final String pathIdentity) {
        this.pathServiceSid = pathServiceSid;
        this.pathListSid = pathListSid;
        this.pathIdentity = pathIdentity;
    }

    /**
     * Make the request to the Twilio API to perform the delete.
     *
     * @param client TwilioRestClient with which to make the request
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public boolean delete(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.DELETE,
            Domains.SYNC.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Lists/" + this.pathListSid + "/Permissions/" + this.pathIdentity + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("SyncListPermission delete failed: Unable to connect to server");
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

        return response.getStatusCode() == 204;
    }
}