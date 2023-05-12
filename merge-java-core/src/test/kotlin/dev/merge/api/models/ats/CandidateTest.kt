package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CandidateTest {

    @Test
    fun createCandidate() {
        val candidate =
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
                            .emailAddressType(Candidate.EmailAddress.EmailAddressTypeEnum.PERSONAL)
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
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(candidate).isNotNull
        assertThat(candidate.id()).contains("521b18c2-4d01-4297-b451-19858d07c133")
        assertThat(candidate.remoteId()).contains("21198")
        assertThat(candidate.firstName()).contains("Gil")
        assertThat(candidate.lastName()).contains("Feig")
        assertThat(candidate.company()).contains("Columbia Dining App.")
        assertThat(candidate.title()).contains("Software Engineer")
        assertThat(candidate.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(candidate.remoteUpdatedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(candidate.lastInteractionAt())
            .contains(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
        assertThat(candidate.isPrivate()).contains(true)
        assertThat(candidate.canEmail()).contains(true)
        assertThat(candidate.locations().get()).containsExactly("string")
        assertThat(candidate.phoneNumbers().get())
            .containsExactly(
                Candidate.PhoneNumber.builder()
                    .value("+3198675309")
                    .phoneNumberType(Candidate.PhoneNumber.PhoneNumberTypeEnum.HOME)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .phoneNumber("+3198675309")
                    .build()
            )
        assertThat(candidate.emailAddresses().get())
            .containsExactly(
                Candidate.EmailAddress.builder()
                    .value("merge_is_hiring@merge.dev")
                    .emailAddressType(Candidate.EmailAddress.EmailAddressTypeEnum.PERSONAL)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .emailAddress("merge_is_hiring@merge.dev")
                    .build()
            )
        assertThat(candidate.urls().get())
            .containsExactly(
                Candidate.Url.builder()
                    .value("http://alturl.com/p749b")
                    .urlType(Candidate.Url.UrlTypeEnum.PERSONAL)
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(candidate.tags().get()).containsExactly("string")
        assertThat(candidate.applications().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(candidate.attachments().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(candidate.remoteWasDeleted()).contains(true)
        assertThat(candidate._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(candidate.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(candidate.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
