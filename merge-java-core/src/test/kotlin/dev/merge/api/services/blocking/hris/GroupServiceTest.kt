package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.GroupListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class GroupServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val groupService = client.hris().groups()
        val group =
            groupService.retrieve(
                GroupRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .remoteFields(GroupRetrieveParams.RemoteFields.TYPE)
                    .showEnumOrigins(GroupRetrieveParams.ShowEnumOrigins.TYPE)
                    .build()
            )
        println(group)
        group.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val groupService = client.hris().groups()
        val paginatedGroupList = groupService.list(GroupListParams.builder().build())
        println(paginatedGroupList)
        paginatedGroupList.results().forEach { it.validate() }
    }
}
