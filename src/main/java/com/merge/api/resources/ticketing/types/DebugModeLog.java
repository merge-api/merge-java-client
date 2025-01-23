/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = DebugModeLog.Builder.class)
public final class DebugModeLog {
    private final String logId;

    private final String dashboardView;

    private final DebugModelLogSummary logSummary;

    private final Map<String, Object> additionalProperties;

    private DebugModeLog(
            String logId,
            String dashboardView,
            DebugModelLogSummary logSummary,
            Map<String, Object> additionalProperties) {
        this.logId = logId;
        this.dashboardView = dashboardView;
        this.logSummary = logSummary;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("log_id")
    public String getLogId() {
        return logId;
    }

    @JsonProperty("dashboard_view")
    public String getDashboardView() {
        return dashboardView;
    }

    @JsonProperty("log_summary")
    public DebugModelLogSummary getLogSummary() {
        return logSummary;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DebugModeLog && equalTo((DebugModeLog) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DebugModeLog other) {
        return logId.equals(other.logId)
                && dashboardView.equals(other.dashboardView)
                && logSummary.equals(other.logSummary);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.logId, this.dashboardView, this.logSummary);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LogIdStage builder() {
        return new Builder();
    }

    public interface LogIdStage {
        DashboardViewStage logId(@NotNull String logId);

        Builder from(DebugModeLog other);
    }

    public interface DashboardViewStage {
        LogSummaryStage dashboardView(@NotNull String dashboardView);
    }

    public interface LogSummaryStage {
        _FinalStage logSummary(@NotNull DebugModelLogSummary logSummary);
    }

    public interface _FinalStage {
        DebugModeLog build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LogIdStage, DashboardViewStage, LogSummaryStage, _FinalStage {
        private String logId;

        private String dashboardView;

        private DebugModelLogSummary logSummary;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(DebugModeLog other) {
            logId(other.getLogId());
            dashboardView(other.getDashboardView());
            logSummary(other.getLogSummary());
            return this;
        }

        @java.lang.Override
        @JsonSetter("log_id")
        public DashboardViewStage logId(@NotNull String logId) {
            this.logId = logId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("dashboard_view")
        public LogSummaryStage dashboardView(@NotNull String dashboardView) {
            this.dashboardView = dashboardView;
            return this;
        }

        @java.lang.Override
        @JsonSetter("log_summary")
        public _FinalStage logSummary(@NotNull DebugModelLogSummary logSummary) {
            this.logSummary = logSummary;
            return this;
        }

        @java.lang.Override
        public DebugModeLog build() {
            return new DebugModeLog(logId, dashboardView, logSummary, additionalProperties);
        }
    }
}
