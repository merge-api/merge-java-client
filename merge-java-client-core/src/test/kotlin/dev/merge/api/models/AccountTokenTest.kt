package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountTokenTest {

    @Test
    fun createAccountToken() {
        val accountToken =
            AccountToken.builder()
                .accountToken("T9klMDQrcHdm9jrtHuOS2Nf06BIHwMNjpPXPMB")
                .integration(
                    AccountToken.AccountIntegration.builder()
                        .name("string")
                        .categories(listOf(AccountToken.AccountIntegration.CategoriesEnum.HRIS))
                        .image("https://example.com")
                        .squareImage("https://example.com")
                        .color("string")
                        .slug("string")
                        .isInBeta(true)
                        .apiEndpointsToDocumentationUrls(JsonString.of("abc"))
                        .build()
                )
                .build()
        assertThat(accountToken).isNotNull
        assertThat(accountToken.accountToken()).isEqualTo("T9klMDQrcHdm9jrtHuOS2Nf06BIHwMNjpPXPMB")
        assertThat(accountToken.integration())
            .isEqualTo(
                AccountToken.AccountIntegration.builder()
                    .name("string")
                    .categories(listOf(AccountToken.AccountIntegration.CategoriesEnum.HRIS))
                    .image("https://example.com")
                    .squareImage("https://example.com")
                    .color("string")
                    .slug("string")
                    .isInBeta(true)
                    .apiEndpointsToDocumentationUrls(JsonString.of("abc"))
                    .build()
            )
    }
}
