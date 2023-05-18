package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class PassthroughRequestServiceTest {

    @Test
    fun callSend() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val passthroughRequestService = client.hris().passthroughRequests()
        val remoteResponse =
            passthroughRequestService.send(
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
                                    PassthroughRequestSendParams.MultipartFormFieldRequest
                                        .EncodingEnum
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
            )
        println(remoteResponse)
        remoteResponse.validate()
    }
}
