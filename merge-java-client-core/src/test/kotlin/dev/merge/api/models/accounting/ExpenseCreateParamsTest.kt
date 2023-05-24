package dev.merge.api.models.accounting

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpenseCreateParamsTest {

    @Test
    fun createExpenseCreateParams() {
        ExpenseCreateParams.builder()
            .model(
                ExpenseCreateParams.ExpenseRequest.builder()
                    .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .contact("3d263469-51a1-4766-9205-f6c997826be1")
                    .totalAmount(42.23)
                    .currency(ExpenseCreateParams.ExpenseRequest.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .memo("New employee supplies")
                    .lines(
                        listOf(
                            ExpenseCreateParams.ExpenseRequest.ExpenseLineRequest.builder()
                                .remoteId("121222")
                                .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .netAmount(42.23)
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                .account("2a56344a-a491-11ec-b909-0242ac120002")
                                .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                .description("MacBook Pro")
                                .exchangeRate("2.9")
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
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            ExpenseCreateParams.builder()
                .model(
                    ExpenseCreateParams.ExpenseRequest.builder()
                        .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                        .contact("3d263469-51a1-4766-9205-f6c997826be1")
                        .totalAmount(42.23)
                        .currency(ExpenseCreateParams.ExpenseRequest.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .memo("New employee supplies")
                        .lines(
                            listOf(
                                ExpenseCreateParams.ExpenseRequest.ExpenseLineRequest.builder()
                                    .remoteId("121222")
                                    .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .netAmount(42.23)
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
                                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                    .account("2a56344a-a491-11ec-b909-0242ac120002")
                                    .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                    .description("MacBook Pro")
                                    .exchangeRate("2.9")
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
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
            ExpenseCreateParams.builder()
                .model(ExpenseCreateParams.ExpenseRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            ExpenseCreateParams.builder()
                .model(
                    ExpenseCreateParams.ExpenseRequest.builder()
                        .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                        .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                        .contact("3d263469-51a1-4766-9205-f6c997826be1")
                        .totalAmount(42.23)
                        .currency(ExpenseCreateParams.ExpenseRequest.CurrencyEnum.XUA)
                        .exchangeRate("2.9")
                        .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                        .memo("New employee supplies")
                        .lines(
                            listOf(
                                ExpenseCreateParams.ExpenseRequest.ExpenseLineRequest.builder()
                                    .remoteId("121222")
                                    .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .netAmount(42.23)
                                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                    .trackingCategories(
                                        listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                                    )
                                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                    .account("2a56344a-a491-11ec-b909-0242ac120002")
                                    .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                    .description("MacBook Pro")
                                    .exchangeRate("2.9")
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
                        .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                ExpenseCreateParams.ExpenseRequest.builder()
                    .transactionDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .contact("3d263469-51a1-4766-9205-f6c997826be1")
                    .totalAmount(42.23)
                    .currency(ExpenseCreateParams.ExpenseRequest.CurrencyEnum.XUA)
                    .exchangeRate("2.9")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .memo("New employee supplies")
                    .lines(
                        listOf(
                            ExpenseCreateParams.ExpenseRequest.ExpenseLineRequest.builder()
                                .remoteId("121222")
                                .item("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .netAmount(42.23)
                                .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                                .account("2a56344a-a491-11ec-b909-0242ac120002")
                                .contact("c640b80b-fac9-409f-aa19-1f9221aec445")
                                .description("MacBook Pro")
                                .exchangeRate("2.9")
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
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            ExpenseCreateParams.builder()
                .model(ExpenseCreateParams.ExpenseRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(ExpenseCreateParams.ExpenseRequest.builder().build())
    }
}
