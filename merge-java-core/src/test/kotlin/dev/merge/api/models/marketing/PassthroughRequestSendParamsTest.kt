package dev.merge.api.models.marketing

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PassthroughRequestSendParamsTest {

    @Test
    fun createPassthroughRequestSendParams() {
        PassthroughRequestSendParams.builder()
            .method(PassthroughRequestSendParams.MethodEnum.GET)
            .path("/scooters")
            .baseUrlOverride("x")
            .data("{\"company\": \"Lime\", \"model\": \"Gen 2.5\"}")
            .multipartFormData(
                listOf(
                    PassthroughRequestSendParams.MultipartFormFieldRequest.builder()
                        .name("resume")
                        .data("SW50ZWdyYXRlIGZhc3QKSW50ZWdyYXRlIG9uY2U=")
                        .encoding(
                            PassthroughRequestSendParams.MultipartFormFieldRequest.EncodingEnum.RAW
                        )
                        .fileName("resume.pdf")
                        .contentType("application/pdf")
                        .build()
                )
            )
            .headers(JsonValue.from(mapOf("EXTRA-HEADER" to "value")))
            .requestFormat(PassthroughRequestSendParams.RequestFormatEnum.JSON)
            .normalizeResponse(true)
            .build()
    }

    @Test
    fun getBody() {
        val params =
            PassthroughRequestSendParams.builder()
                .method(PassthroughRequestSendParams.MethodEnum.GET)
                .path("/scooters")
                .baseUrlOverride("x")
                .data("{\"company\": \"Lime\", \"model\": \"Gen 2.5\"}")
                .multipartFormData(
                    listOf(
                        PassthroughRequestSendParams.MultipartFormFieldRequest.builder()
                            .name("resume")
                            .data("SW50ZWdyYXRlIGZhc3QKSW50ZWdyYXRlIG9uY2U=")
                            .encoding(
                                PassthroughRequestSendParams.MultipartFormFieldRequest.EncodingEnum
                                    .RAW
                            )
                            .fileName("resume.pdf")
                            .contentType("application/pdf")
                            .build()
                    )
                )
                .headers(JsonValue.from(mapOf("EXTRA-HEADER" to "value")))
                .requestFormat(PassthroughRequestSendParams.RequestFormatEnum.JSON)
                .normalizeResponse(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.method()).isEqualTo(PassthroughRequestSendParams.MethodEnum.GET)
        assertThat(body.path()).isEqualTo("/scooters")
        assertThat(body.baseUrlOverride()).isEqualTo("x")
        assertThat(body.data()).isEqualTo("{\"company\": \"Lime\", \"model\": \"Gen 2.5\"}")
        assertThat(body.multipartFormData())
            .isEqualTo(
                listOf(
                    PassthroughRequestSendParams.MultipartFormFieldRequest.builder()
                        .name("resume")
                        .data("SW50ZWdyYXRlIGZhc3QKSW50ZWdyYXRlIG9uY2U=")
                        .encoding(
                            PassthroughRequestSendParams.MultipartFormFieldRequest.EncodingEnum.RAW
                        )
                        .fileName("resume.pdf")
                        .contentType("application/pdf")
                        .build()
                )
            )
        assertThat(body.headers()).isEqualTo(JsonValue.from(mapOf("EXTRA-HEADER" to "value")))
        assertThat(body.requestFormat())
            .isEqualTo(PassthroughRequestSendParams.RequestFormatEnum.JSON)
        assertThat(body.normalizeResponse()).isEqualTo(true)
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            PassthroughRequestSendParams.builder()
                .method(PassthroughRequestSendParams.MethodEnum.GET)
                .path("/scooters")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.method()).isEqualTo(PassthroughRequestSendParams.MethodEnum.GET)
        assertThat(body.path()).isEqualTo("/scooters")
    }
}
