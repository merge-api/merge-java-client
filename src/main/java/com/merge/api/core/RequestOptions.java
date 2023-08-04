package com.merge.api.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class RequestOptions {

    public final String apiKey;
    public final String accountToken;

    private RequestOptions(String apiKey, String accountToken) {
        this.apiKey = apiKey;
        this.accountToken = accountToken;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        if (this.apiKey != null) {
            headers.put("Authorization", "Bearer " + this.apiKey);
        }
        if (this.apiKey != null) {
            headers.put("X-Account-Token", this.accountToken);
        }
        return headers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {

        private String apiKey = null;

        private String accountToken = null;

        public Builder apiKey(String apiKey) {
            return this;
        }

        public Builder accountToken(String accountToken) {
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(apiKey, accountToken);
        }
    }
}
