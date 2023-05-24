package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountDetailsAndActionsTest {

    @Test
    fun createAccountDetailsAndActions() {
        val accountDetailsAndActions =
            AccountDetailsAndActions.builder()
                .id("e59b1821-f85c-4e28-a6b3-1804156f3563")
                .category(AccountDetailsAndActions.CategoryEnum.HRIS)
                .status(AccountDetailsAndActions.AccountDetailsAndActionsStatusEnum.COMPLETE)
                .statusDetail("string")
                .endUserOriginId("3ac95cde-6c7f-4eef-afec-be710b42308d")
                .endUserOrganizationName("Foo Bar, LLC")
                .endUserEmailAddress("hradmin@foobar.dev")
                .webhookListenerUrl(
                    "https://api.merge.dev/api/integrations/webhook-listener/7fc3mee0UW8ecV4"
                )
                .isDuplicate(true)
                .integration(
                    AccountDetailsAndActions.AccountDetailsAndActionsIntegration.builder()
                        .name("string")
                        .categories(
                            listOf(
                                AccountDetailsAndActions.AccountDetailsAndActionsIntegration
                                    .CategoriesEnum
                                    .HRIS
                            )
                        )
                        .image("string")
                        .squareImage("string")
                        .color("string")
                        .slug("string")
                        .passthroughAvailable(true)
                        .availableModelOperations(
                            listOf(
                                AccountDetailsAndActions.AccountDetailsAndActionsIntegration
                                    .ModelOperation
                                    .builder()
                                    .modelName("Candidate")
                                    .availableOperations(listOf("string"))
                                    .requiredPostParameters(listOf("string"))
                                    .supportedFields(listOf("string"))
                                    .build()
                            )
                        )
                        .build()
                )
                .build()
        assertThat(accountDetailsAndActions).isNotNull
        assertThat(accountDetailsAndActions.id()).isEqualTo("e59b1821-f85c-4e28-a6b3-1804156f3563")
        assertThat(accountDetailsAndActions.category())
            .contains(AccountDetailsAndActions.CategoryEnum.HRIS)
        assertThat(accountDetailsAndActions.status())
            .isEqualTo(AccountDetailsAndActions.AccountDetailsAndActionsStatusEnum.COMPLETE)
        assertThat(accountDetailsAndActions.statusDetail()).contains("string")
        assertThat(accountDetailsAndActions.endUserOriginId())
            .contains("3ac95cde-6c7f-4eef-afec-be710b42308d")
        assertThat(accountDetailsAndActions.endUserOrganizationName()).isEqualTo("Foo Bar, LLC")
        assertThat(accountDetailsAndActions.endUserEmailAddress()).isEqualTo("hradmin@foobar.dev")
        assertThat(accountDetailsAndActions.webhookListenerUrl())
            .isEqualTo("https://api.merge.dev/api/integrations/webhook-listener/7fc3mee0UW8ecV4")
        assertThat(accountDetailsAndActions.isDuplicate()).contains(true)
        assertThat(accountDetailsAndActions.integration())
            .contains(
                AccountDetailsAndActions.AccountDetailsAndActionsIntegration.builder()
                    .name("string")
                    .categories(
                        listOf(
                            AccountDetailsAndActions.AccountDetailsAndActionsIntegration
                                .CategoriesEnum
                                .HRIS
                        )
                    )
                    .image("string")
                    .squareImage("string")
                    .color("string")
                    .slug("string")
                    .passthroughAvailable(true)
                    .availableModelOperations(
                        listOf(
                            AccountDetailsAndActions.AccountDetailsAndActionsIntegration
                                .ModelOperation
                                .builder()
                                .modelName("Candidate")
                                .availableOperations(listOf("string"))
                                .requiredPostParameters(listOf("string"))
                                .supportedFields(listOf("string"))
                                .build()
                        )
                    )
                    .build()
            )
    }
}
