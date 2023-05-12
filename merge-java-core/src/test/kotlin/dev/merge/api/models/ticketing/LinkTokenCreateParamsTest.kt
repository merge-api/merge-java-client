package dev.merge.api.models.ticketing

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkTokenCreateParamsTest {

    @Test
    fun createLinkTokenCreateParams() {
        LinkTokenCreateParams.builder()
            .endUserEmailAddress("x")
            .endUserOrganizationName("x")
            .endUserOriginId("x")
            .categories(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
            .integration("x")
            .linkExpiryMins(123L)
            .shouldCreateMagicLinkUrl(true)
            .commonModels(
                listOf(
                    LinkTokenCreateParams.CommonModelScopesBodyRequest.builder()
                        .modelId("hris.Employee")
                        .enabledActions(
                            listOf(
                                LinkTokenCreateParams.CommonModelScopesBodyRequest
                                    .EnabledActionsEnum
                                    .READ
                            )
                        )
                        .disabledFields(listOf("x"))
                        .build()
                )
            )
            .build()
    }

    @Test
    fun getBody() {
        val params =
            LinkTokenCreateParams.builder()
                .endUserEmailAddress("x")
                .endUserOrganizationName("x")
                .endUserOriginId("x")
                .categories(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
                .integration("x")
                .linkExpiryMins(123L)
                .shouldCreateMagicLinkUrl(true)
                .commonModels(
                    listOf(
                        LinkTokenCreateParams.CommonModelScopesBodyRequest.builder()
                            .modelId("hris.Employee")
                            .enabledActions(
                                listOf(
                                    LinkTokenCreateParams.CommonModelScopesBodyRequest
                                        .EnabledActionsEnum
                                        .READ
                                )
                            )
                            .disabledFields(listOf("x"))
                            .build()
                    )
                )
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.endUserEmailAddress()).isEqualTo("x")
        assertThat(body.endUserOrganizationName()).isEqualTo("x")
        assertThat(body.endUserOriginId()).isEqualTo("x")
        assertThat(body.categories()).isEqualTo(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
        assertThat(body.integration()).isEqualTo("x")
        assertThat(body.linkExpiryMins()).isEqualTo(123L)
        assertThat(body.shouldCreateMagicLinkUrl()).isEqualTo(true)
        assertThat(body.commonModels())
            .isEqualTo(
                listOf(
                    LinkTokenCreateParams.CommonModelScopesBodyRequest.builder()
                        .modelId("hris.Employee")
                        .enabledActions(
                            listOf(
                                LinkTokenCreateParams.CommonModelScopesBodyRequest
                                    .EnabledActionsEnum
                                    .READ
                            )
                        )
                        .disabledFields(listOf("x"))
                        .build()
                )
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            LinkTokenCreateParams.builder()
                .endUserEmailAddress("x")
                .endUserOrganizationName("x")
                .endUserOriginId("x")
                .categories(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.endUserEmailAddress()).isEqualTo("x")
        assertThat(body.endUserOrganizationName()).isEqualTo("x")
        assertThat(body.endUserOriginId()).isEqualTo("x")
        assertThat(body.categories()).isEqualTo(listOf(LinkTokenCreateParams.CategoriesEnum.HRIS))
    }
}
