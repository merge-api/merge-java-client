package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MetaResponseTest {

    @Test
    fun createMetaResponse() {
        val metaResponse =
            MetaResponse.builder()
                .requestSchema(JsonString.of("abc"))
                .remoteFieldClasses(JsonString.of("abc"))
                .status(
                    MetaResponse.LinkedAccountStatus.builder()
                        .linkedAccountStatus("string")
                        .canMakeRequest(true)
                        .build()
                )
                .hasConditionalParams(true)
                .hasRequiredLinkedAccountParams(true)
                .build()
        assertThat(metaResponse).isNotNull
        assertThat(metaResponse._requestSchema()).isEqualTo(JsonString.of("abc"))
        assertThat(metaResponse._remoteFieldClasses()).isEqualTo(JsonString.of("abc"))
        assertThat(metaResponse.status())
            .contains(
                MetaResponse.LinkedAccountStatus.builder()
                    .linkedAccountStatus("string")
                    .canMakeRequest(true)
                    .build()
            )
        assertThat(metaResponse.hasConditionalParams()).isEqualTo(true)
        assertThat(metaResponse.hasRequiredLinkedAccountParams()).isEqualTo(true)
    }
}
