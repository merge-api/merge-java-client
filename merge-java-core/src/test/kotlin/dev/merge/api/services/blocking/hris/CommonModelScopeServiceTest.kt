package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class CommonModelScopeServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val commonModelScopeService = client.hris().commonModelScopes()
        val commonModelScope =
            commonModelScopeService.retrieve(
                CommonModelScopeRetrieveParams.builder().linkedAccountId("string").build()
            )
        println(commonModelScope)
        commonModelScope.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val commonModelScopeService = client.hris().commonModelScopes()
        val commonModelScope =
            commonModelScopeService.update(
                CommonModelScopeUpdateParams.builder()
                    .commonModels(
                        listOf(
                            CommonModelScopeUpdateParams
                                .CommonModelScopesPostInnerDeserializerRequest
                                .builder()
                                .modelId("hris.Employee")
                                .enabledActions(
                                    listOf(
                                        CommonModelScopeUpdateParams
                                            .CommonModelScopesPostInnerDeserializerRequest
                                            .EnabledActionsEnum
                                            .READ
                                    )
                                )
                                .disabledFields(listOf("x"))
                                .build()
                        )
                    )
                    .linkedAccountId("string")
                    .build()
            )
        println(commonModelScope)
        commonModelScope.validate()
    }
}
