package com.merge.api.resources.ticketing.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.merge.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DebugModeLog.Builder.class)
public final class DebugModeLog {
    private final String logId;

    private final String dashboardView;

    private final DebugModelLogSummary logSummary;

    private DebugModeLog(String logId, String dashboardView, DebugModelLogSummary logSummary) {
        this.logId = logId;
        this.dashboardView = dashboardView;
        this.logSummary = logSummary;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DebugModeLog && equalTo((DebugModeLog) other);
    }

    private boolean equalTo(DebugModeLog other) {
        return logId.equals(other.logId)
                && dashboardView.equals(other.dashboardView)
                && logSummary.equals(other.logSummary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.logId, this.dashboardView, this.logSummary);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LogIdStage builder() {
        return new Builder();
    }

    public interface LogIdStage {
        DashboardViewStage logId(String logId);

        Builder from(DebugModeLog other);
    }

    public interface DashboardViewStage {
        LogSummaryStage dashboardView(String dashboardView);
    }

    public interface LogSummaryStage {
        _FinalStage logSummary(DebugModelLogSummary logSummary);
    }

    public interface _FinalStage {
        DebugModeLog build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LogIdStage, DashboardViewStage, LogSummaryStage, _FinalStage {
        private String logId;

        private String dashboardView;

        private DebugModelLogSummary logSummary;

        private Builder() {}

        @Override
        public Builder from(DebugModeLog other) {
            logId(other.getLogId());
            dashboardView(other.getDashboardView());
            logSummary(other.getLogSummary());
            return this;
        }

        @Override
        @JsonSetter("log_id")
        public DashboardViewStage logId(String logId) {
            this.logId = logId;
            return this;
        }

        @Override
        @JsonSetter("dashboard_view")
        public LogSummaryStage dashboardView(String dashboardView) {
            this.dashboardView = dashboardView;
            return this;
        }

        @Override
        @JsonSetter("log_summary")
        public _FinalStage logSummary(DebugModelLogSummary logSummary) {
            this.logSummary = logSummary;
            return this;
        }

        @Override
        public DebugModeLog build() {
            return new DebugModeLog(logId, dashboardView, logSummary);
        }
    }
}
