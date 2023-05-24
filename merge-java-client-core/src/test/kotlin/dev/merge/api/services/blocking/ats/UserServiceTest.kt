package dev.merge.api.services.blocking.ats

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.ats.*
import dev.merge.api.models.ats.UserListParams
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
        val userService = client.ats().users()
        val remoteUser =
            userService.retrieve(
                UserRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .remoteFields(UserRetrieveParams.RemoteFields.ACCESS_ROLE)
                    .showEnumOrigins(UserRetrieveParams.ShowEnumOrigins.ACCESS_ROLE)
                    .build()
            )
        println(remoteUser)
        remoteUser.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val userService = client.ats().users()
        val paginatedRemoteUserList = userService.list(UserListParams.builder().build())
        println(paginatedRemoteUserList)
        paginatedRemoteUserList.results().forEach { it.validate() }
    }
}
