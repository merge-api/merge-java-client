package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class RemoteKeyServiceTest {

    @Test
    fun callGenerate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val remoteKeyService = client.accounting().remoteKeys()
        val remoteKey =
            remoteKeyService.generate(
                RemoteKeyGenerateParams.builder().name("Remote Deployment Key 1").build()
            )
        println(remoteKey)
        remoteKey.validate()
    }

    @Test
    fun callRegenerate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val remoteKeyService = client.accounting().remoteKeys()
        val remoteKey =
            remoteKeyService.regenerate(
                RemoteKeyRegenerateParams.builder().name("Remote Deployment Key 1").build()
            )
        println(remoteKey)
        remoteKey.validate()
    }
}
