/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v1.flow.execution;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecutionContext extends Resource {
    private static final long serialVersionUID = 274461811661129L;

    /**
     * Create a ExecutionContextFetcher to execute fetch.
     *
     * @param pathFlowSid The SID of the Flow
     * @param pathExecutionSid The SID of the Execution
     * @return ExecutionContextFetcher capable of executing the fetch
     */
    public static ExecutionContextFetcher fetcher(final String pathFlowSid,
                                                  final String pathExecutionSid) {
        return new ExecutionContextFetcher(pathFlowSid, pathExecutionSid);
    }

    /**
     * Converts a JSON String into a ExecutionContext object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return ExecutionContext object represented by the provided JSON
     */
    public static ExecutionContext fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExecutionContext.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a ExecutionContext object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return ExecutionContext object represented by the provided JSON
     */
    public static ExecutionContext fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, ExecutionContext.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Map<String, Object> context;
    private final String flowSid;
    private final String executionSid;
    private final URI url;

    @JsonCreator
    private ExecutionContext(@JsonProperty("account_sid")
                             final String accountSid,
                             @JsonProperty("context")
                             final Map<String, Object> context,
                             @JsonProperty("flow_sid")
                             final String flowSid,
                             @JsonProperty("execution_sid")
                             final String executionSid,
                             @JsonProperty("url")
                             final URI url) {
        this.accountSid = accountSid;
        this.context = context;
        this.flowSid = flowSid;
        this.executionSid = executionSid;
        this.url = url;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The current state of the flow.
     *
     * @return The current state of the flow
     */
    public final Map<String, Object> getContext() {
        return this.context;
    }

    /**
     * Returns The SID of the Flow.
     *
     * @return The SID of the Flow
     */
    public final String getFlowSid() {
        return this.flowSid;
    }

    /**
     * Returns The SID of the Execution.
     *
     * @return The SID of the Execution
     */
    public final String getExecutionSid() {
        return this.executionSid;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ExecutionContext other = (ExecutionContext) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(context, other.context) &&
               Objects.equals(flowSid, other.flowSid) &&
               Objects.equals(executionSid, other.executionSid) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            context,
                            flowSid,
                            executionSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("context", context)
                          .add("flowSid", flowSid)
                          .add("executionSid", executionSid)
                          .add("url", url)
                          .toString();
    }
}