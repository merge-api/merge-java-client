package com.merge.api.resources.ats.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AccountToken.Builder.class)
public final class AccountToken {
    private final String accountToken;

    private final AccountIntegration integration;

    private AccountToken(String accountToken, AccountIntegration integration) {
        this.accountToken = accountToken;
        this.integration = integration;
    }

    @JsonProperty("account_token")
    public String getAccountToken() {
        return accountToken;
    }

    @JsonProperty("integration")
    public AccountIntegration getIntegration() {
        return integration;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AccountToken && equalTo((AccountToken) other);
    }

    private boolean equalTo(AccountToken other) {
        return accountToken.equals(other.accountToken) && integration.equals(other.integration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.accountToken, this.integration);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AccountTokenStage builder() {
        return new Builder();
    }

    public interface AccountTokenStage {
        IntegrationStage accountToken(String accountToken);

        Builder from(AccountToken other);
    }

    public interface IntegrationStage {
        _FinalStage integration(AccountIntegration integration);
    }

    public interface _FinalStage {
        AccountToken build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AccountTokenStage, IntegrationStage, _FinalStage {
        private String accountToken;

        private AccountIntegration integration;

        private Builder() {}

        @Override
        public Builder from(AccountToken other) {
            accountToken(other.getAccountToken());
            integration(other.getIntegration());
            return this;
        }

        @Override
        @JsonSetter("account_token")
        public IntegrationStage accountToken(String accountToken) {
            this.accountToken = accountToken;
            return this;
        }

        @Override
        @JsonSetter("integration")
        public _FinalStage integration(AccountIntegration integration) {
            this.integration = integration;
            return this;
        }

        @Override
        public AccountToken build() {
            return new AccountToken(accountToken, integration);
        }
    }
}
