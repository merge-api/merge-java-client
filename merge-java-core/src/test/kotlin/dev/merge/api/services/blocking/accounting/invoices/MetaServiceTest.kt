package dev.merge.api.services.blocking.accounting.invoices

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
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
        val metaService = client.accounting().invoices().meta()
        val metaResponse = metaService.forCreate(InvoiceMetaForCreateParams.builder().build())
        println(metaResponse)
        metaResponse.validate()
    }
}
