package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class LinkTokenServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val linkTokenService = client.fileStorage().linkTokens()
        val linkToken =
            linkTokenService.create(
                LinkTokenCreateParams.builder()
                    .endUserEmailAddress("x")
                    .endUserOrganizationName("x")
                    .endUserOriginId("x")
                    .categories(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
                    .integration("x")
                    .linkExpiryMins(123L)
                    .shouldCreateMagicLinkUrl(true)
                    .commonModels(
                        listOf(
                            LinkTokenCreateParams.CommonModelScopesBodyRequest.builder()
                                .modelId("hris.Employee")
                                .enabledActions(
                                    listOf(
                                        LinkTokenCreateParams.CommonModelScopesBodyRequest
                                            .EnabledActionsEnum
                                            .READ
                                    )
                                )
                                .disabledFields(listOf("x"))
                                .build()
                        )
                    )
                    .build()
            )
        println(linkToken)
        linkToken.validate()
    }
}
