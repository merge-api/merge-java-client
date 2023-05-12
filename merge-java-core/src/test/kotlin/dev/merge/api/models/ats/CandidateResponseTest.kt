package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CandidateResponseTest {

    @Test
    fun createCandidateResponse() {
        val candidateResponse =
            CandidateResponse.builder()
                .model(
                    Candidate.builder()
                        .id("521b18c2-4d01-4297-b451-19858d07c133")
                        .remoteId("21198")
                        .firstName("Gil")
                        .lastName("Feig")
                        .company("Columbia Dining App.")
                        .title("Software Engineer")
                        .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                        .remoteUpdatedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                        .isPrivate(true)
                        .canEmail(true)
                        .locations(listOf("string"))
                        .phoneNumbers(
                            listOf(
                                Candidate.PhoneNumber.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(Candidate.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .phoneNumber("+3198675309")
                                    .build()
                            )
                        )
                        .emailAddresses(
                            listOf(
                                Candidate.EmailAddress.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        Candidate.EmailAddress.EmailAddressTypeEnum.PERSONAL
                                    )
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .emailAddress("merge_is_hiring@merge.dev")
                                    .build()
                            )
                        )
                        .urls(
                            listOf(
                                Candidate.Url.builder()
                                    .value("http://alturl.com/p749b")
                                    .urlType(Candidate.Url.UrlTypeEnum.PERSONAL)
                                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                    .build()
                            )
                        )
                        .tags(listOf("string"))
                        .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteWasDeleted(true)
                        .fieldMappings(
                            JsonValue.from(
                                mapOf(
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(
                            listOf(
                                RemoteData.builder()
                                    .path("string")
                                    .data(JsonString.of("abc"))
                                    .build()
                            )
                        )
                        .build()
                )
                .warnings(
                    listOf(
                        ValidationWarning.builder()
                            .source(
                                ValidationWarning.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Unrecognized Field")
                            .detail("An unrecognized field, age, was passed in with request data.")
                            .problemType("UNRECOGNIZED_FIELD")
                            .build()
                    )
                )
                .errors(
                    listOf(
                        ValidationError.builder()
                            .source(
                                ValidationError.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Missing Required Field")
                            .detail("custom_fields is a required field on model.")
                            .problemType("MISSING_REQUIRED_FIELD")
                            .build()
                    )
                )
                .logs(
                    listOf(
                        DebugLog.builder()
                            .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                            .dashboardView(
                                "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                            )
                            .logSummary(
                                DebugLog.DebugModelLogSummary.builder()
                                    .url("https://harvest.greenhouse.io/v1/candidates/")
                                    .method("POST")
                                    .statusCode(123L)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(candidateResponse).isNotNull
        assertThat(candidateResponse.model())
            .isEqualTo(
                Candidate.builder()
                    .id("521b18c2-4d01-4297-b451-19858d07c133")
                    .remoteId("21198")
                    .firstName("Gil")
                    .lastName("Feig")
                    .company("Columbia Dining App.")
                    .title("Software Engineer")
                    .remoteCreatedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                    .remoteUpdatedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                    .isPrivate(true)
                    .canEmail(true)
                    .locations(listOf("string"))
                    .phoneNumbers(
                        listOf(
                            Candidate.PhoneNumber.builder()
                                .value("+3198675309")
                                .phoneNumberType(Candidate.PhoneNumber.PhoneNumberTypeEnum.HOME)
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .phoneNumber("+3198675309")
                                .build()
                        )
                    )
                    .emailAddresses(
                        listOf(
                            Candidate.EmailAddress.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    Candidate.EmailAddress.EmailAddressTypeEnum.PERSONAL
                                )
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .emailAddress("merge_is_hiring@merge.dev")
                                .build()
                        )
                    )
                    .urls(
                        listOf(
                            Candidate.Url.builder()
                                .value("http://alturl.com/p749b")
                                .urlType(Candidate.Url.UrlTypeEnum.PERSONAL)
                                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                                .build()
                        )
                    )
                    .tags(listOf("string"))
                    .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(candidateResponse.warnings())
            .containsExactly(
                ValidationWarning.builder()
                    .source(
                        ValidationWarning.ValidationProblemSource.builder()
                            .pointer("string")
                            .build()
                    )
                    .title("Unrecognized Field")
                    .detail("An unrecognized field, age, was passed in with request data.")
                    .problemType("UNRECOGNIZED_FIELD")
                    .build()
            )
        assertThat(candidateResponse.errors())
            .containsExactly(
                ValidationError.builder()
                    .source(
                        ValidationError.ValidationProblemSource.builder().pointer("string").build()
                    )
                    .title("Missing Required Field")
                    .detail("custom_fields is a required field on model.")
                    .problemType("MISSING_REQUIRED_FIELD")
                    .build()
            )
        assertThat(candidateResponse.logs().get())
            .containsExactly(
                DebugLog.builder()
                    .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                    .dashboardView(
                        "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                    )
                    .logSummary(
                        DebugLog.DebugModelLogSummary.builder()
                            .url("https://harvest.greenhouse.io/v1/candidates/")
                            .method("POST")
                            .statusCode(123L)
                            .build()
                    )
                    .build()
            )
    }
}
