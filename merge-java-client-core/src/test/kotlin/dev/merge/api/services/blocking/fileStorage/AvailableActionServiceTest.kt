package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AvailableActionServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val availableActionService = client.fileStorage().availableActions()
        val availableAction =
            availableActionService.retrieve(AvailableActionRetrieveParams.builder().build())
        println(availableAction)
        availableAction.validate()
    }
}
