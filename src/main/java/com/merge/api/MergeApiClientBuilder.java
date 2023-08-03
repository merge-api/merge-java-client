package com.merge.api;

import com.merge.api.core.ClientOptions;
import com.merge.api.core.Environment;

public final class MergeApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.PRODUCTION;

    public MergeApiClientBuilder apiKey(String apiKey) {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + apiKey);
        return this;
    }

    public MergeApiClientBuilder accountToken(String accountToken) {
        this.clientOptionsBuilder.addHeader("X-Account-Token", accountToken);
        return this;
    }

    public MergeApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public MergeApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public MergeApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new MergeApiClient(clientOptionsBuilder.build());
    }
}
