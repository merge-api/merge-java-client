package dev.merge.api.models

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AddressTest {

    @Test
    fun createAddress() {
        val address =
            Address.builder()
                .type(Address.AddressTypeEnum.BILLING)
                .street1("50 Bowling Green Dr")
                .street2("Golden Gate Park")
                .city("San Francisco")
                .state("CA")
                .countrySubdivision("NY")
                .country(Country.AF)
                .zipCode("10027")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .postalCode("94122")
                .addressType(Address.AddressTypeEnum.BILLING)
                .build()
        assertThat(address).isNotNull
        assertThat(address.type()).contains(Address.AddressTypeEnum.BILLING)
        assertThat(address.street1()).contains("50 Bowling Green Dr")
        assertThat(address.street2()).contains("Golden Gate Park")
        assertThat(address.city()).contains("San Francisco")
        assertThat(address.state()).contains("CA")
        assertThat(address.countrySubdivision()).contains("NY")
        assertThat(address.country()).contains(Country.AF)
        assertThat(address.zipCode()).contains("10027")
        assertThat(address.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(address.postalCode()).contains("94122")
        assertThat(address.addressType()).contains(Address.AddressTypeEnum.BILLING)
    }
}
