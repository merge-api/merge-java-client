package dev.merge.api.services.blocking.ticketing.tickets

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ticketing.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class MetaServiceTest {

    @Test
    fun callForCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val metaService = client.ticketing().tickets().meta()
        val metaResponse = metaService.forCreate(TicketMetaForCreateParams.builder().build())
        println(metaResponse)
        metaResponse.validate()
    }

    @Test
    fun callForUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val metaService = client.ticketing().tickets().meta()
        val metaResponse =
            metaService.forUpdate(
                TicketMetaForUpdateParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(metaResponse)
        metaResponse.validate()
    }
}
