package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.LocationListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class LocationServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val locationService = client.hris().locations()
        val location =
            locationService.retrieve(
                LocationRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .remoteFields(LocationRetrieveParams.RemoteFields.LOCATION_TYPE)
                    .showEnumOrigins(LocationRetrieveParams.ShowEnumOrigins.LOCATION_TYPE)
                    .build()
            )
        println(location)
        location.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val locationService = client.hris().locations()
        val paginatedLocationList = locationService.list(LocationListParams.builder().build())
        println(paginatedLocationList)
        paginatedLocationList.results().forEach { it.validate() }
    }
}
