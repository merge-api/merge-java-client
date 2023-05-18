package dev.merge.api.models.ats

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CandidateCreateParamsTest {

    @Test
    fun createCandidateCreateParams() {
        CandidateCreateParams.builder()
            .model(
                CandidateCreateParams.CandidateRequest.builder()
                    .firstName("Gil")
                    .lastName("Feig")
                    .company("Columbia Dining App.")
                    .title("Software Engineer")
                    .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                    .isPrivate(true)
                    .canEmail(true)
                    .locations(listOf("string"))
                    .phoneNumbers(
                        listOf(
                            CandidateCreateParams.CandidateRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    CandidateCreateParams.CandidateRequest.PhoneNumberRequest
                                        .PhoneNumberTypeEnum
                                        .HOME
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .phoneNumber("+3198675309")
                                .build()
                        )
                    )
                    .emailAddresses(
                        listOf(
                            CandidateCreateParams.CandidateRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    CandidateCreateParams.CandidateRequest.EmailAddressRequest
                                        .EmailAddressTypeEnum
                                        .PERSONAL
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .emailAddress("merge_is_hiring@merge.dev")
                                .build()
                        )
                    )
                    .urls(
                        listOf(
                            CandidateCreateParams.CandidateRequest.UrlRequest.builder()
                                .value("http://alturl.com/p749b")
                                .urlType(
                                    CandidateCreateParams.CandidateRequest.UrlRequest.UrlTypeEnum
                                        .PERSONAL
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .build()
                        )
                    )
                    .tags(listOf("string"))
                    .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteTemplateId("92830948203")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .remoteUserId("string")
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CandidateCreateParams.builder()
                .model(
                    CandidateCreateParams.CandidateRequest.builder()
                        .firstName("Gil")
                        .lastName("Feig")
                        .company("Columbia Dining App.")
                        .title("Software Engineer")
                        .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                        .isPrivate(true)
                        .canEmail(true)
                        .locations(listOf("string"))
                        .phoneNumbers(
                            listOf(
                                CandidateCreateParams.CandidateRequest.PhoneNumberRequest.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        CandidateCreateParams.CandidateRequest.PhoneNumberRequest
                                            .PhoneNumberTypeEnum
                                            .HOME
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .phoneNumber("+3198675309")
                                    .build()
                            )
                        )
                        .emailAddresses(
                            listOf(
                                CandidateCreateParams.CandidateRequest.EmailAddressRequest.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        CandidateCreateParams.CandidateRequest.EmailAddressRequest
                                            .EmailAddressTypeEnum
                                            .PERSONAL
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .emailAddress("merge_is_hiring@merge.dev")
                                    .build()
                            )
                        )
                        .urls(
                            listOf(
                                CandidateCreateParams.CandidateRequest.UrlRequest.builder()
                                    .value("http://alturl.com/p749b")
                                    .urlType(
                                        CandidateCreateParams.CandidateRequest.UrlRequest
                                            .UrlTypeEnum
                                            .PERSONAL
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .tags(listOf("string"))
                        .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteTemplateId("92830948203")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            CandidateCreateParams.builder()
                .model(CandidateCreateParams.CandidateRequest.builder().build())
                .remoteUserId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            CandidateCreateParams.builder()
                .model(
                    CandidateCreateParams.CandidateRequest.builder()
                        .firstName("Gil")
                        .lastName("Feig")
                        .company("Columbia Dining App.")
                        .title("Software Engineer")
                        .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                        .isPrivate(true)
                        .canEmail(true)
                        .locations(listOf("string"))
                        .phoneNumbers(
                            listOf(
                                CandidateCreateParams.CandidateRequest.PhoneNumberRequest.builder()
                                    .value("+3198675309")
                                    .phoneNumberType(
                                        CandidateCreateParams.CandidateRequest.PhoneNumberRequest
                                            .PhoneNumberTypeEnum
                                            .HOME
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .phoneNumber("+3198675309")
                                    .build()
                            )
                        )
                        .emailAddresses(
                            listOf(
                                CandidateCreateParams.CandidateRequest.EmailAddressRequest.builder()
                                    .value("merge_is_hiring@merge.dev")
                                    .emailAddressType(
                                        CandidateCreateParams.CandidateRequest.EmailAddressRequest
                                            .EmailAddressTypeEnum
                                            .PERSONAL
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .emailAddress("merge_is_hiring@merge.dev")
                                    .build()
                            )
                        )
                        .urls(
                            listOf(
                                CandidateCreateParams.CandidateRequest.UrlRequest.builder()
                                    .value("http://alturl.com/p749b")
                                    .urlType(
                                        CandidateCreateParams.CandidateRequest.UrlRequest
                                            .UrlTypeEnum
                                            .PERSONAL
                                    )
                                    .integrationParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_integration_field" to
                                                    "unique_integration_field_value"
                                            )
                                        )
                                    )
                                    .linkedAccountParams(
                                        JsonValue.from(
                                            mapOf(
                                                "unique_linked_account_field" to
                                                    "unique_linked_account_field_value"
                                            )
                                        )
                                    )
                                    .build()
                            )
                        )
                        .tags(listOf("string"))
                        .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .remoteTemplateId("92830948203")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .remoteUserId("string")
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                CandidateCreateParams.CandidateRequest.builder()
                    .firstName("Gil")
                    .lastName("Feig")
                    .company("Columbia Dining App.")
                    .title("Software Engineer")
                    .lastInteractionAt(OffsetDateTime.parse("2021-10-17T00:00:00Z"))
                    .isPrivate(true)
                    .canEmail(true)
                    .locations(listOf("string"))
                    .phoneNumbers(
                        listOf(
                            CandidateCreateParams.CandidateRequest.PhoneNumberRequest.builder()
                                .value("+3198675309")
                                .phoneNumberType(
                                    CandidateCreateParams.CandidateRequest.PhoneNumberRequest
                                        .PhoneNumberTypeEnum
                                        .HOME
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .phoneNumber("+3198675309")
                                .build()
                        )
                    )
                    .emailAddresses(
                        listOf(
                            CandidateCreateParams.CandidateRequest.EmailAddressRequest.builder()
                                .value("merge_is_hiring@merge.dev")
                                .emailAddressType(
                                    CandidateCreateParams.CandidateRequest.EmailAddressRequest
                                        .EmailAddressTypeEnum
                                        .PERSONAL
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .emailAddress("merge_is_hiring@merge.dev")
                                .build()
                        )
                    )
                    .urls(
                        listOf(
                            CandidateCreateParams.CandidateRequest.UrlRequest.builder()
                                .value("http://alturl.com/p749b")
                                .urlType(
                                    CandidateCreateParams.CandidateRequest.UrlRequest.UrlTypeEnum
                                        .PERSONAL
                                )
                                .integrationParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_integration_field" to
                                                "unique_integration_field_value"
                                        )
                                    )
                                )
                                .linkedAccountParams(
                                    JsonValue.from(
                                        mapOf(
                                            "unique_linked_account_field" to
                                                "unique_linked_account_field_value"
                                        )
                                    )
                                )
                                .build()
                        )
                    )
                    .tags(listOf("string"))
                    .applications(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .attachments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .remoteTemplateId("92830948203")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
        assertThat(body.remoteUserId()).isEqualTo("string")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            CandidateCreateParams.builder()
                .model(CandidateCreateParams.CandidateRequest.builder().build())
                .remoteUserId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(CandidateCreateParams.CandidateRequest.builder().build())
        assertThat(body.remoteUserId()).isEqualTo("string")
    }
}
