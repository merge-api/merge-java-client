/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats;

import com.merge.api.ats.types.EndUserDetailsRequest;
import com.merge.api.ats.types.LinkToken;
import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;

public class LinkTokenClient {
    protected final ClientOptions clientOptions;

    private final RawLinkTokenClient rawClient;

    public LinkTokenClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.rawClient = new RawLinkTokenClient(clientOptions);
    }

    /**
     * Get responses with HTTP metadata like headers
     */
    public RawLinkTokenClient withRawResponse() {
        return this.rawClient;
    }

    /**
     * Creates a link token to be used when linking a new end user.
     */
    public LinkToken create(EndUserDetailsRequest request) {
        return this.rawClient.create(request).body();
    }

    /**
     * Creates a link token to be used when linking a new end user.
     */
    public LinkToken create(EndUserDetailsRequest request, RequestOptions requestOptions) {
        return this.rawClient.create(request, requestOptions).body();
    }
}
