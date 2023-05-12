package dev.merge.api.models.crm

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountCreateParamsTest {

    @Test
    fun createAccountCreateParams() {
        AccountCreateParams.builder()
            .model(
                AccountCreateParams.AccountRequest.builder()
                    .name("Merge API")
                    .description("One API for all integrations")
                    .classification(AccountCreateParams.AccountRequest.ClassificationEnum.ASSET)
                    .type("Asset")
                    .status(AccountCreateParams.AccountRequest.AccountStatusEnum.ACTIVE)
                    .currentBalance(42.23)
                    .currency(AccountCreateParams.AccountRequest.CurrencyEnum.XUA)
                    .accountNumber("X12Y9AB")
                    .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                    .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                    .industry("API's")
                    .website("https://merge.dev/")
                    .numberOfEmployees(123L)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            AccountCreateParams.builder()
                .model(
                    AccountCreateParams.AccountRequest.builder()
                        .name("Merge API")
                        .description("One API for all integrations")
                        .classification(AccountCreateParams.AccountRequest.ClassificationEnum.ASSET)
                        .type("Asset")
                        .status(AccountCreateParams.AccountRequest.AccountStatusEnum.ACTIVE)
                        .currentBalance(42.23)
                        .currency(AccountCreateParams.AccountRequest.CurrencyEnum.XUA)
                        .accountNumber("X12Y9AB")
                        .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                        .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                        .industry("API's")
                        .website("https://merge.dev/")
                        .numberOfEmployees(123L)
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .build()
                )
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
            AccountCreateParams.builder()
                .model(AccountCreateParams.AccountRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            AccountCreateParams.builder()
                .model(
                    AccountCreateParams.AccountRequest.builder()
                        .name("Merge API")
                        .description("One API for all integrations")
                        .classification(AccountCreateParams.AccountRequest.ClassificationEnum.ASSET)
                        .type("Asset")
                        .status(AccountCreateParams.AccountRequest.AccountStatusEnum.ACTIVE)
                        .currentBalance(42.23)
                        .currency(AccountCreateParams.AccountRequest.CurrencyEnum.XUA)
                        .accountNumber("X12Y9AB")
                        .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                        .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                        .industry("API's")
                        .website("https://merge.dev/")
                        .numberOfEmployees(123L)
                        .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                AccountCreateParams.AccountRequest.builder()
                    .name("Merge API")
                    .description("One API for all integrations")
                    .classification(AccountCreateParams.AccountRequest.ClassificationEnum.ASSET)
                    .type("Asset")
                    .status(AccountCreateParams.AccountRequest.AccountStatusEnum.ACTIVE)
                    .currentBalance(42.23)
                    .currency(AccountCreateParams.AccountRequest.CurrencyEnum.XUA)
                    .accountNumber("X12Y9AB")
                    .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
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
                    .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                    .industry("API's")
                    .website("https://merge.dev/")
                    .numberOfEmployees(123L)
                    .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            AccountCreateParams.builder()
                .model(AccountCreateParams.AccountRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(AccountCreateParams.AccountRequest.builder().build())
    }
}
