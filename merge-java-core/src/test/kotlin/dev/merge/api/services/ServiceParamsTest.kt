package dev.merge.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import dev.merge.api.client.MergeClient
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.jsonMapper
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.SyncStatusListPage
import dev.merge.api.models.hris.SyncStatusListParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ServiceParamsTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val API_KEY: String = "apiKey"

    private lateinit var client: MergeClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            MergeOkHttpClient.builder()
                .apiKey(API_KEY)
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .accountToken("<account-token>")
                .build()
    }

    @Test
    fun hrisAccountDetailsRetrieveWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val params =
            AccountDetailRetrieveParams.builder()
                .additionalHeaders(additionalHeaders)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            AccountDetail.builder()
                .id("0496d4c2-42e6-4072-80b3-7b69bfdc76fd")
                .integration("BambooHR")
                .integrationSlug("bamboohr")
                .category(AccountDetail.CategoryEnum.HRIS)
                .endUserOriginId("3fa85f64-5717-4562-b3fc-2c963f66afa6")
                .endUserOrganizationName("Waystar Royco")
                .endUserEmailAddress("kendall.roy@waystar-royco.com")
                .status("COMPLETE")
                .webhookListenerUrl(
                    "https://api.merge.dev/api/integrations/webhook-listener/7fc3mee0UW8ecV4"
                )
                .isDuplicate(true)
                .build()

        stubFor(
            get(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse)))
        )

        client.hris().accountDetails().retrieve(params)

        verify(getRequestedFor(anyUrl()))
    }

    @Test
    fun hrisSyncStatusListWithAdditionalParams() {
        val additionalHeaders = mutableMapOf<String, List<String>>()

        additionalHeaders.put("x-test-header", listOf("abc1234"))

        val additionalQueryParams = mutableMapOf<String, List<String>>()

        additionalQueryParams.put("test_query_param", listOf("def567"))

        val params =
            SyncStatusListParams.builder()
                .cursor("string")
                .pageSize(123L)
                .additionalHeaders(additionalHeaders)
                .additionalQueryParams(additionalQueryParams)
                .build()

        val apiResponse =
            SyncStatusListPage.Response.builder()
                .next("cD0yMDIxLTAxLTA2KzAzJTNBMjQlM0E1My40MzQzMjYlMkIwMCUzQTAw")
                .previous("cj1sZXdwd2VycWVtY29zZnNkc2NzUWxNMEUxTXk0ME16UXpNallsTWtJ")
                .results(
                    listOf(
                        SyncStatus.builder()
                            .modelName("File")
                            .modelId("filestorage.FileStorageFile")
                            .lastSyncStart(OffsetDateTime.parse("2021-03-30T19:44:18.695973Z"))
                            .nextSyncStart(OffsetDateTime.parse("2021-03-30T20:44:18.662942Z"))
                            .status(SyncStatus.SyncStatusStatusEnum.SYNCING)
                            .isInitialSync(true)
                            .selectiveSyncConfigurationsUsage(
                                SyncStatus.SelectiveSyncConfigurationsUsageEnum.IN_NEXT_SYNC
                            )
                            .build()
                    )
                )
                .build()

        stubFor(
            get(anyUrl())
                .withHeader("x-test-header", equalTo("abc1234"))
                .withQueryParam("test_query_param", equalTo("def567"))
                .willReturn(ok(JSON_MAPPER.writeValueAsString(apiResponse)))
        )

        client.hris().syncStatus().list(params)

        verify(getRequestedFor(anyUrl()))
    }
}
