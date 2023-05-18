package dev.merge.api.models.accounting

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class VendorCreditTest {

    @Test
    fun createVendorCredit() {
        val vendorCredit =
            VendorCredit.builder()
                .id("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
                .remoteId("088899")
                .number("6")
                .transactionDate(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
                .vendor("3d263469-51a1-4766-9205-f6c997826be1")
                .totalAmount(42.23)
                .currency(VendorCredit.CurrencyEnum.XUA)
                .exchangeRate("2.9")
                .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                .lines(
                    listOf(
                        VendorCredit.VendorCreditLine.builder()
                            .remoteId("121222")
                            .netAmount(42.23)
                            .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                            .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .description("Gifted Merge Credit")
                            .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .exchangeRate("2.9")
                            .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                            .build()
                    )
                )
                .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
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
        assertThat(vendorCredit).isNotNull
        assertThat(vendorCredit.id()).contains("ecbe05ac-62a3-46c5-ab31-4b478b37d1b4")
        assertThat(vendorCredit.remoteId()).contains("088899")
        assertThat(vendorCredit.number()).contains("6")
        assertThat(vendorCredit.transactionDate())
            .contains(OffsetDateTime.parse("2020-03-31T00:00:00Z"))
        assertThat(vendorCredit.vendor()).contains("3d263469-51a1-4766-9205-f6c997826be1")
        assertThat(vendorCredit.totalAmount()).contains(42.23)
        assertThat(vendorCredit.currency()).contains(VendorCredit.CurrencyEnum.XUA)
        assertThat(vendorCredit.exchangeRate()).contains("2.9")
        assertThat(vendorCredit.company()).contains("595c8f97-2ac4-45b7-b000-41bdf43240b5")
        assertThat(vendorCredit.lines().get())
            .containsExactly(
                VendorCredit.VendorCreditLine.builder()
                    .remoteId("121222")
                    .netAmount(42.23)
                    .trackingCategory("b38c59b0-a9d7-4740-b1ee-5436c6751e3d")
                    .trackingCategories(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .description("Gifted Merge Credit")
                    .account("9d892439-5fab-4dbb-8bd8-34f7f96c7912")
                    .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                    .exchangeRate("2.9")
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .build()
            )
        assertThat(vendorCredit.trackingCategories().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(vendorCredit.remoteWasDeleted()).contains(true)
        assertThat(vendorCredit._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(vendorCredit.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(vendorCredit.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
