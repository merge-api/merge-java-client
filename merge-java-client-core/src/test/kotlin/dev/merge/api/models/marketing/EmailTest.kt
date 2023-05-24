package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmailTest {

    @Test
    fun createEmail() {
        val email =
            Email.builder()
                .name("Welcome Email")
                .subject("Welcome onboard!")
                .body("Welcome onboard! Stay connected and find out more.")
                .htmlBody("<b>Welcome onboard</b>! Stay connected and find out more.")
                .fromName("Merge")
                .fromEmail("hello@merge.dev")
                .preview("Welcome onboard!")
                .replyTo("hello@merge.dev")
                .remoteCreatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .remoteUpdatedAt(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
                .status(Email.MarketingEmailStatusEnum.DRAFT)
                .sendDate(OffsetDateTime.parse("2022-12-25T00:00:00Z"))
                .template("4958cbc6-4874-430a-475r-aafacbadd5ty")
                .campaigns(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .remoteWasDeleted(true)
                .id("2634cbc6-6040-430a-475r-aafacbadf9he")
                .remoteId("15")
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
        assertThat(email).isNotNull
        assertThat(email.name()).contains("Welcome Email")
        assertThat(email.subject()).contains("Welcome onboard!")
        assertThat(email.body()).contains("Welcome onboard! Stay connected and find out more.")
        assertThat(email.htmlBody())
            .contains("<b>Welcome onboard</b>! Stay connected and find out more.")
        assertThat(email.fromName()).contains("Merge")
        assertThat(email.fromEmail()).contains("hello@merge.dev")
        assertThat(email.preview()).contains("Welcome onboard!")
        assertThat(email.replyTo()).contains("hello@merge.dev")
        assertThat(email.remoteCreatedAt()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(email.remoteUpdatedAt()).contains(OffsetDateTime.parse("2022-12-23T00:00:00Z"))
        assertThat(email.status()).contains(Email.MarketingEmailStatusEnum.DRAFT)
        assertThat(email.sendDate()).contains(OffsetDateTime.parse("2022-12-25T00:00:00Z"))
        assertThat(email.template()).contains("4958cbc6-4874-430a-475r-aafacbadd5ty")
        assertThat(email.campaigns()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(email.remoteWasDeleted()).contains(true)
        assertThat(email.id()).contains("2634cbc6-6040-430a-475r-aafacbadf9he")
        assertThat(email.remoteId()).contains("15")
        assertThat(email._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(email.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(email.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
