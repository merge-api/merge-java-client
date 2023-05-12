package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountDetailTest {

    @Test
    fun createAccountDetail() {
        val accountDetail =
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
        assertThat(accountDetail).isNotNull
        assertThat(accountDetail.id()).contains("0496d4c2-42e6-4072-80b3-7b69bfdc76fd")
        assertThat(accountDetail.integration()).contains("BambooHR")
        assertThat(accountDetail.integrationSlug()).contains("bamboohr")
        assertThat(accountDetail.category()).contains(AccountDetail.CategoryEnum.HRIS)
        assertThat(accountDetail.endUserOriginId()).contains("3fa85f64-5717-4562-b3fc-2c963f66afa6")
        assertThat(accountDetail.endUserOrganizationName()).contains("Waystar Royco")
        assertThat(accountDetail.endUserEmailAddress()).contains("kendall.roy@waystar-royco.com")
        assertThat(accountDetail.status()).contains("COMPLETE")
        assertThat(accountDetail.webhookListenerUrl())
            .contains("https://api.merge.dev/api/integrations/webhook-listener/7fc3mee0UW8ecV4")
        assertThat(accountDetail.isDuplicate()).contains(true)
    }
}
