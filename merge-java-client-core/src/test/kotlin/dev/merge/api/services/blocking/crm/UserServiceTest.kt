package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.UserListParams
import dev.merge.api.models.crm.UserListRemoteFieldClassesParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class UserServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val userService = client.crm().users()
        val user =
            userService.retrieve(
                UserRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(user)
        user.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val userService = client.crm().users()
        val crmPaginatedUserList = userService.list(UserListParams.builder().build())
        println(crmPaginatedUserList)
        crmPaginatedUserList.results().forEach { it.validate() }
    }

    @Test
    fun callIgnoreRow() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val userService = client.crm().users()
        userService.ignoreRow(
            UserIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(UserIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .message("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
                .build()
        )
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val userService = client.crm().users()
        val paginatedRemoteFieldClassList =
            userService.listRemoteFieldClasses(UserListRemoteFieldClassesParams.builder().build())
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
