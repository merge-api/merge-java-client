package dev.merge.api.models

import dev.merge.api.core.JsonValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteResponseTest {

    @Test
    fun createRemoteResponse() {
        val remoteResponse =
            RemoteResponse.builder()
                .method("GET")
                .path("/scooters")
                .status(123L)
                .response(
                    JsonValue.from(
                        mapOf(
                            "scooters" to
                                listOf(
                                    mapOf("company" to "Lime", "model" to "Gen 2.5"),
                                    mapOf("company" to "Bird", "model" to "Bird Zero")
                                )
                        )
                    )
                )
                .responseHeaders(JsonValue.from(mapOf("X-Page-Token" to "value")))
                .responseType(RemoteResponse.ResponseTypeEnum.JSON)
                .headers(
                    JsonValue.from(
                        mapOf("EXTRA-HEADER" to "value", "Authorization" to "<redacted>")
                    )
                )
                .build()
        assertThat(remoteResponse).isNotNull
        assertThat(remoteResponse.method()).isEqualTo("GET")
        assertThat(remoteResponse.path()).isEqualTo("/scooters")
        assertThat(remoteResponse.status()).isEqualTo(123L)
        assertThat(remoteResponse._response())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "scooters" to
                            listOf(
                                mapOf("company" to "Lime", "model" to "Gen 2.5"),
                                mapOf("company" to "Bird", "model" to "Bird Zero")
                            )
                    )
                )
            )
        assertThat(remoteResponse._responseHeaders())
            .isEqualTo(JsonValue.from(mapOf("X-Page-Token" to "value")))
        assertThat(remoteResponse.responseType()).contains(RemoteResponse.ResponseTypeEnum.JSON)
        assertThat(remoteResponse._headers())
            .isEqualTo(
                JsonValue.from(mapOf("EXTRA-HEADER" to "value", "Authorization" to "<redacted>"))
            )
    }
}
