package dev.merge.api.models.accounting

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PhoneNumberTest {

    @Test
    fun createPhoneNumber() {
        val phoneNumber =
            PhoneNumber.builder()
                .number("+3198675309")
                .type("Mobile")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .build()
        assertThat(phoneNumber).isNotNull
        assertThat(phoneNumber.number()).contains("+3198675309")
        assertThat(phoneNumber.type()).contains("Mobile")
        assertThat(phoneNumber.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
    }
}
