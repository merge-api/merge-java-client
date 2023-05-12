package dev.merge.api.models.marketing

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ActionTest {

    @Test
    fun createAction() {
        val action =
            Action.builder()
                .name("Welcome Email")
                .emails(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .messages(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                .type(Action.TypeEnum.EMAIL)
                .remoteWasDeleted(true)
                .id("52ce940b-ecfe-43a6-955f-629f799f7f73")
                .remoteId("1234")
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
                .remoteData(listOf(JsonString.of("abc")))
                .build()
        assertThat(action).isNotNull
        assertThat(action.name()).contains("Welcome Email")
        assertThat(action.emails()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(action.messages()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(action.type()).contains(Action.TypeEnum.EMAIL)
        assertThat(action.remoteWasDeleted()).contains(true)
        assertThat(action.id()).contains("52ce940b-ecfe-43a6-955f-629f799f7f73")
        assertThat(action.remoteId()).contains("1234")
        assertThat(action._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(action.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(action.remoteData().get()).containsExactly(JsonString.of("abc"))
    }
}
