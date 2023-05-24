package dev.merge.api.services.blocking.crm.customObjects

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class GeneratorServiceTest {

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val generatorService = client.crm().customObjects().generators()
        val customObjectClass =
            generatorService.update(
                CustomObjectGeneratorUpdateParams.builder()
                    .generatorId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(customObjectClass)
        customObjectClass.validate()
    }
}
