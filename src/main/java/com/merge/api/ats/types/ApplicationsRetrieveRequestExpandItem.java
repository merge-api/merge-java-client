/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.merge.api.ats.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public final class ApplicationsRetrieveRequestExpandItem {
    public static final ApplicationsRetrieveRequestExpandItem OFFERS =
            new ApplicationsRetrieveRequestExpandItem(Value.OFFERS, "offers");

    public static final ApplicationsRetrieveRequestExpandItem CANDIDATE =
            new ApplicationsRetrieveRequestExpandItem(Value.CANDIDATE, "candidate");

    public static final ApplicationsRetrieveRequestExpandItem SCREENING_QUESTION_ANSWERS =
            new ApplicationsRetrieveRequestExpandItem(Value.SCREENING_QUESTION_ANSWERS, "screening_question_answers");

    public static final ApplicationsRetrieveRequestExpandItem CURRENT_STAGE =
            new ApplicationsRetrieveRequestExpandItem(Value.CURRENT_STAGE, "current_stage");

    public static final ApplicationsRetrieveRequestExpandItem REJECT_REASON =
            new ApplicationsRetrieveRequestExpandItem(Value.REJECT_REASON, "reject_reason");

    public static final ApplicationsRetrieveRequestExpandItem CREDITED_TO =
            new ApplicationsRetrieveRequestExpandItem(Value.CREDITED_TO, "credited_to");

    public static final ApplicationsRetrieveRequestExpandItem JOB =
            new ApplicationsRetrieveRequestExpandItem(Value.JOB, "job");

    public static final ApplicationsRetrieveRequestExpandItem SCREENING_QUESTION_ANSWERS_QUESTION =
            new ApplicationsRetrieveRequestExpandItem(
                    Value.SCREENING_QUESTION_ANSWERS_QUESTION, "screening_question_answers.question");

    private final Value value;

    private final String string;

    ApplicationsRetrieveRequestExpandItem(Value value, String string) {
        this.value = value;
        this.string = string;
    }

    public Value getEnumValue() {
        return value;
    }

    @java.lang.Override
    @JsonValue
    public String toString() {
        return this.string;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return (this == other)
                || (other instanceof ApplicationsRetrieveRequestExpandItem
                        && this.string.equals(((ApplicationsRetrieveRequestExpandItem) other).string));
    }

    @java.lang.Override
    public int hashCode() {
        return this.string.hashCode();
    }

    public <T> T visit(Visitor<T> visitor) {
        switch (value) {
            case OFFERS:
                return visitor.visitOffers();
            case CANDIDATE:
                return visitor.visitCandidate();
            case SCREENING_QUESTION_ANSWERS:
                return visitor.visitScreeningQuestionAnswers();
            case CURRENT_STAGE:
                return visitor.visitCurrentStage();
            case REJECT_REASON:
                return visitor.visitRejectReason();
            case CREDITED_TO:
                return visitor.visitCreditedTo();
            case JOB:
                return visitor.visitJob();
            case SCREENING_QUESTION_ANSWERS_QUESTION:
                return visitor.visitScreeningQuestionAnswersQuestion();
            case UNKNOWN:
            default:
                return visitor.visitUnknown(string);
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static ApplicationsRetrieveRequestExpandItem valueOf(String value) {
        switch (value) {
            case "offers":
                return OFFERS;
            case "candidate":
                return CANDIDATE;
            case "screening_question_answers":
                return SCREENING_QUESTION_ANSWERS;
            case "current_stage":
                return CURRENT_STAGE;
            case "reject_reason":
                return REJECT_REASON;
            case "credited_to":
                return CREDITED_TO;
            case "job":
                return JOB;
            case "screening_question_answers.question":
                return SCREENING_QUESTION_ANSWERS_QUESTION;
            default:
                return new ApplicationsRetrieveRequestExpandItem(Value.UNKNOWN, value);
        }
    }

    public enum Value {
        CANDIDATE,

        CREDITED_TO,

        CURRENT_STAGE,

        JOB,

        OFFERS,

        REJECT_REASON,

        SCREENING_QUESTION_ANSWERS,

        SCREENING_QUESTION_ANSWERS_QUESTION,

        UNKNOWN
    }

    public interface Visitor<T> {
        T visitCandidate();

        T visitCreditedTo();

        T visitCurrentStage();

        T visitJob();

        T visitOffers();

        T visitRejectReason();

        T visitScreeningQuestionAnswers();

        T visitScreeningQuestionAnswersQuestion();

        T visitUnknown(String unknownType);
    }
}
