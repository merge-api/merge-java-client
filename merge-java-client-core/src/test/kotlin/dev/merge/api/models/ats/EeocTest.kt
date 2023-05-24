package dev.merge.api.models.ats

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EeocTest {

    @Test
    fun createEeoc() {
        val eeoc =
            Eeoc.builder()
                .id("f7dd7b4f-237e-4772-8bd4-3246384c6c58")
                .remoteId("76")
                .candidate("f963f34d-3d2f-4f77-b557-cf36bc7e6498")
                .submittedAt(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
                .race(Eeoc.RaceEnum.AMERICAN_INDIAN_OR_ALASKAN_NATIVE)
                .gender(Eeoc.GenderEnum.MALE)
                .veteranStatus(Eeoc.VeteranStatusEnum.I_AM_NOT_A_PROTECTED_VETERAN)
                .disabilityStatus(
                    Eeoc.DisabilityStatusEnum.YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
                )
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
        assertThat(eeoc).isNotNull
        assertThat(eeoc.id()).contains("f7dd7b4f-237e-4772-8bd4-3246384c6c58")
        assertThat(eeoc.remoteId()).contains("76")
        assertThat(eeoc.candidate()).contains("f963f34d-3d2f-4f77-b557-cf36bc7e6498")
        assertThat(eeoc.submittedAt()).contains(OffsetDateTime.parse("2021-10-15T00:00:00Z"))
        assertThat(eeoc.race()).contains(Eeoc.RaceEnum.AMERICAN_INDIAN_OR_ALASKAN_NATIVE)
        assertThat(eeoc.gender()).contains(Eeoc.GenderEnum.MALE)
        assertThat(eeoc.veteranStatus())
            .contains(Eeoc.VeteranStatusEnum.I_AM_NOT_A_PROTECTED_VETERAN)
        assertThat(eeoc.disabilityStatus())
            .contains(
                Eeoc.DisabilityStatusEnum.YES_I_HAVE_A_DISABILITY_OR_PREVIOUSLY_HAD_A_DISABILITY
            )
        assertThat(eeoc.remoteWasDeleted()).contains(true)
        assertThat(eeoc._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(eeoc.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(eeoc.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
