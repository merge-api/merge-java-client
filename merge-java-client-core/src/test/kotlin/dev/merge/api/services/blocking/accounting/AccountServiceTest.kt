package dev.merge.api.services.blocking.accounting

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.accounting.*
import dev.merge.api.models.accounting.AccountListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AccountServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val accountService = client.accounting().accounts()
        val accountResponse =
            accountService.create(
                AccountCreateParams.builder()
                    .model(
                        AccountCreateParams.AccountRequest.builder()
                            .name("Merge API")
                            .description("One API for all integrations")
                            .classification(
                                AccountCreateParams.AccountRequest.ClassificationEnum.ASSET
                            )
                            .type("Asset")
                            .status(AccountCreateParams.AccountRequest.AccountStatusEnum.ACTIVE)
                            .currentBalance(42.23)
                            .currency(AccountCreateParams.AccountRequest.CurrencyEnum.XUA)
                            .accountNumber("X12Y9AB")
                            .parentAccount("22d92d6c-22f9-11ed-861d-0242ac120002")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
                                    )
                                )
                            )
                            .linkedAccountParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_linked_account_field" to
                                            "unique_linked_account_field_value"
                                    )
                                )
                            )
                            .owner("0258cbc6-6020-430a-848e-aafacbadf4ae")
                            .industry("API's")
                            .website("https://merge.dev/")
                            .numberOfEmployees(123L)
                            .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .remoteFields(
                                listOf(
                                    AccountCreateParams.AccountRequest.RemoteFieldRequest.builder()
                                        .remoteFieldClass("b057d1d2-c204-4da8-a74c-c91d1a260614")
                                        .value(JsonString.of("abc"))
                                        .build()
                                )
                            )
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(accountResponse)
        accountResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val accountService = client.accounting().accounts()
        val account =
            accountService.retrieve(
                AccountRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(AccountRetrieveParams.Expand.COMPANY))
                    .includeRemoteData(true)
                    .remoteFields(AccountRetrieveParams.RemoteFields.CLASSIFICATION)
                    .showEnumOrigins(AccountRetrieveParams.ShowEnumOrigins.CLASSIFICATION)
                    .build()
            )
        println(account)
        account.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val accountService = client.accounting().accounts()
        val paginatedAccountList = accountService.list(AccountListParams.builder().build())
        println(paginatedAccountList)
        paginatedAccountList.results().forEach { it.validate() }
    }
}
