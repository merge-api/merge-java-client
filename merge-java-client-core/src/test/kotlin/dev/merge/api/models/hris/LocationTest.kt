package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LocationTest {

    @Test
    fun createLocation() {
        val location =
            Location.builder()
                .id("f5e6a151-f44e-449a-afb1-8fd781905958")
                .remoteId("93018402")
                .name("NYC Office")
                .phoneNumber("+1111111111")
                .street1("2920 Broadway")
                .street2("2nd Floor")
                .city("New York ")
                .state("NY")
                .zipCode("10027")
                .country(Country.AF)
                .locationType(Location.LocationTypeEnum.HOME)
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
        assertThat(location).isNotNull
        assertThat(location.id()).contains("f5e6a151-f44e-449a-afb1-8fd781905958")
        assertThat(location.remoteId()).contains("93018402")
        assertThat(location.name()).contains("NYC Office")
        assertThat(location.phoneNumber()).contains("+1111111111")
        assertThat(location.street1()).contains("2920 Broadway")
        assertThat(location.street2()).contains("2nd Floor")
        assertThat(location.city()).contains("New York ")
        assertThat(location.state()).contains("NY")
        assertThat(location.zipCode()).contains("10027")
        assertThat(location.country()).contains(Country.AF)
        assertThat(location.locationType()).contains(Location.LocationTypeEnum.HOME)
        assertThat(location.remoteWasDeleted()).contains(true)
        assertThat(location._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(location.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(location.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
