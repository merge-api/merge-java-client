package dev.merge.api.services.blocking.hris

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import dev.merge.api.models.hris.BenefitListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class BenefitServiceTest {

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val benefitService = client.hris().benefits()
        val benefit =
            benefitService.retrieve(
                BenefitRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(BenefitRetrieveParams.Expand.EMPLOYEE))
                    .includeRemoteData(true)
                    .build()
            )
        println(benefit)
        benefit.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val benefitService = client.hris().benefits()
        val paginatedBenefitList = benefitService.list(BenefitListParams.builder().build())
        println(paginatedBenefitList)
        paginatedBenefitList.results().forEach { it.validate() }
    }
}
