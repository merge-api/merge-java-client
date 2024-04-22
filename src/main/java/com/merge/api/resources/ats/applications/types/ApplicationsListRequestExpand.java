/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.resources.ats.applications.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ApplicationsListRequestExpand {
    CANDIDATE("candidate"),

    CANDIDATE_CREDITED_TO("candidate,credited_to"),

    CANDIDATE_CREDITED_TO_CURRENT_STAGE("candidate,credited_to,current_stage"),

    CANDIDATE_CREDITED_TO_CURRENT_STAGE_REJECT_REASON("candidate,credited_to,current_stage,reject_reason"),

    CANDIDATE_CREDITED_TO_REJECT_REASON("candidate,credited_to,reject_reason"),

    CANDIDATE_CURRENT_STAGE("candidate,current_stage"),

    CANDIDATE_CURRENT_STAGE_REJECT_REASON("candidate,current_stage,reject_reason"),

    CANDIDATE_JOB("candidate,job"),

    CANDIDATE_JOB_CREDITED_TO("candidate,job,credited_to"),

    CANDIDATE_JOB_CREDITED_TO_CURRENT_STAGE("candidate,job,credited_to,current_stage"),

    CANDIDATE_JOB_CREDITED_TO_CURRENT_STAGE_REJECT_REASON("candidate,job,credited_to,current_stage,reject_reason"),

    CANDIDATE_JOB_CREDITED_TO_REJECT_REASON("candidate,job,credited_to,reject_reason"),

    CANDIDATE_JOB_CURRENT_STAGE("candidate,job,current_stage"),

    CANDIDATE_JOB_CURRENT_STAGE_REJECT_REASON("candidate,job,current_stage,reject_reason"),

    CANDIDATE_JOB_REJECT_REASON("candidate,job,reject_reason"),

    CANDIDATE_REJECT_REASON("candidate,reject_reason"),

    CREDITED_TO("credited_to"),

    CREDITED_TO_CURRENT_STAGE("credited_to,current_stage"),

    CREDITED_TO_CURRENT_STAGE_REJECT_REASON("credited_to,current_stage,reject_reason"),

    CREDITED_TO_REJECT_REASON("credited_to,reject_reason"),

    CURRENT_STAGE("current_stage"),

    CURRENT_STAGE_REJECT_REASON("current_stage,reject_reason"),

    JOB("job"),

    JOB_CREDITED_TO("job,credited_to"),

    JOB_CREDITED_TO_CURRENT_STAGE("job,credited_to,current_stage"),

    JOB_CREDITED_TO_CURRENT_STAGE_REJECT_REASON("job,credited_to,current_stage,reject_reason"),

    JOB_CREDITED_TO_REJECT_REASON("job,credited_to,reject_reason"),

    JOB_CURRENT_STAGE("job,current_stage"),

    JOB_CURRENT_STAGE_REJECT_REASON("job,current_stage,reject_reason"),

    JOB_REJECT_REASON("job,reject_reason"),

    OFFERS("offers"),

    OFFERS_CANDIDATE("offers,candidate"),

    OFFERS_CANDIDATE_CREDITED_TO("offers,candidate,credited_to"),

    OFFERS_CANDIDATE_CREDITED_TO_CURRENT_STAGE("offers,candidate,credited_to,current_stage"),

    OFFERS_CANDIDATE_CREDITED_TO_CURRENT_STAGE_REJECT_REASON(
            "offers,candidate,credited_to,current_stage,reject_reason"),

    OFFERS_CANDIDATE_CREDITED_TO_REJECT_REASON("offers,candidate,credited_to,reject_reason"),

    OFFERS_CANDIDATE_CURRENT_STAGE("offers,candidate,current_stage"),

    OFFERS_CANDIDATE_CURRENT_STAGE_REJECT_REASON("offers,candidate,current_stage,reject_reason"),

    OFFERS_CANDIDATE_JOB("offers,candidate,job"),

    OFFERS_CANDIDATE_JOB_CREDITED_TO("offers,candidate,job,credited_to"),

    OFFERS_CANDIDATE_JOB_CREDITED_TO_CURRENT_STAGE("offers,candidate,job,credited_to,current_stage"),

    OFFERS_CANDIDATE_JOB_CREDITED_TO_CURRENT_STAGE_REJECT_REASON(
            "offers,candidate,job,credited_to,current_stage,reject_reason"),

    OFFERS_CANDIDATE_JOB_CREDITED_TO_REJECT_REASON("offers,candidate,job,credited_to,reject_reason"),

    OFFERS_CANDIDATE_JOB_CURRENT_STAGE("offers,candidate,job,current_stage"),

    OFFERS_CANDIDATE_JOB_CURRENT_STAGE_REJECT_REASON("offers,candidate,job,current_stage,reject_reason"),

    OFFERS_CANDIDATE_JOB_REJECT_REASON("offers,candidate,job,reject_reason"),

    OFFERS_CANDIDATE_REJECT_REASON("offers,candidate,reject_reason"),

    OFFERS_CREDITED_TO("offers,credited_to"),

    OFFERS_CREDITED_TO_CURRENT_STAGE("offers,credited_to,current_stage"),

    OFFERS_CREDITED_TO_CURRENT_STAGE_REJECT_REASON("offers,credited_to,current_stage,reject_reason"),

    OFFERS_CREDITED_TO_REJECT_REASON("offers,credited_to,reject_reason"),

    OFFERS_CURRENT_STAGE("offers,current_stage"),

    OFFERS_CURRENT_STAGE_REJECT_REASON("offers,current_stage,reject_reason"),

    OFFERS_JOB("offers,job"),

    OFFERS_JOB_CREDITED_TO("offers,job,credited_to"),

    OFFERS_JOB_CREDITED_TO_CURRENT_STAGE("offers,job,credited_to,current_stage"),

    OFFERS_JOB_CREDITED_TO_CURRENT_STAGE_REJECT_REASON("offers,job,credited_to,current_stage,reject_reason"),

    OFFERS_JOB_CREDITED_TO_REJECT_REASON("offers,job,credited_to,reject_reason"),

    OFFERS_JOB_CURRENT_STAGE("offers,job,current_stage"),

    OFFERS_JOB_CURRENT_STAGE_REJECT_REASON("offers,job,current_stage,reject_reason"),

    OFFERS_JOB_REJECT_REASON("offers,job,reject_reason"),

    OFFERS_REJECT_REASON("offers,reject_reason"),

    REJECT_REASON("reject_reason");

    private final String value;

    ApplicationsListRequestExpand(String value) {
        this.value = value;
    }

    @JsonValue
    @java.lang.Override
    public String toString() {
        return this.value;
    }
}
