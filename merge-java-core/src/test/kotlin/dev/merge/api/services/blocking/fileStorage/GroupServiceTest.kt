package dev.merge.api.services.blocking.fileStorage

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.fileStorage.*
import dev.merge.api.models.fileStorage.GroupListParams
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
        val groupService = client.fileStorage().groups()
        val group =
            groupService.retrieve(
                GroupRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
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
        val groupService = client.fileStorage().groups()
        val fileStoragePaginatedGroupList = groupService.list(GroupListParams.builder().build())
        println(fileStoragePaginatedGroupList)
        fileStoragePaginatedGroupList.results().forEach { it.validate() }
    }
}
