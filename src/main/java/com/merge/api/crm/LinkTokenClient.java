/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.crm;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.RequestOptions;
import com.merge.api.crm.types.EndUserDetailsRequest;
import com.merge.api.crm.types.LinkToken;

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
