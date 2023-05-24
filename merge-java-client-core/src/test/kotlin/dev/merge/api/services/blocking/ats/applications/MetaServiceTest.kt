package dev.merge.api.services.blocking.ats.applications

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
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
        val metaService = client.ats().applications().meta()
        val metaResponse =
            metaService.forCreate(
                ApplicationMetaForCreateParams.builder()
                    .applicationRemoteTemplateId("string")
                    .build()
            )
        println(metaResponse)
        metaResponse.validate()
    }
}
