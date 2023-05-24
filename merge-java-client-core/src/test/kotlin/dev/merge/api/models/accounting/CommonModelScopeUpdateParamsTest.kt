package dev.merge.api.models.accounting

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CommonModelScopeUpdateParamsTest {

    @Test
    fun createCommonModelScopeUpdateParams() {
        CommonModelScopeUpdateParams.builder()
            .commonModels(
                listOf(
                    CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                        .builder()
                        .modelId("hris.Employee")
                        .enabledActions(
                            listOf(
                                CommonModelScopeUpdateParams
                                    .CommonModelScopesPostInnerDeserializerRequest
                                    .EnabledActionsEnum
                                    .READ
                            )
                        )
                        .disabledFields(listOf("x"))
                        .build()
                )
            )
            .linkedAccountId("string")
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            CommonModelScopeUpdateParams.builder()
                .commonModels(
                    listOf(
                        CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                            .builder()
                            .modelId("hris.Employee")
                            .enabledActions(
                                listOf(
                                    CommonModelScopeUpdateParams
                                        .CommonModelScopesPostInnerDeserializerRequest
                                        .EnabledActionsEnum
                                        .READ
                                )
                            )
                            .disabledFields(listOf("x"))
                            .build()
                    )
                )
                .linkedAccountId("string")
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("linked_account_id", listOf("string"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            CommonModelScopeUpdateParams.builder()
                .commonModels(
                    listOf(
                        CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                            .builder()
                            .modelId("hris.Employee")
                            .enabledActions(
                                listOf(
                                    CommonModelScopeUpdateParams
                                        .CommonModelScopesPostInnerDeserializerRequest
                                        .EnabledActionsEnum
                                        .READ
                                )
                            )
                            .disabledFields(listOf("x"))
                            .build()
                    )
                )
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            CommonModelScopeUpdateParams.builder()
                .commonModels(
                    listOf(
                        CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                            .builder()
                            .modelId("hris.Employee")
                            .enabledActions(
                                listOf(
                                    CommonModelScopeUpdateParams
                                        .CommonModelScopesPostInnerDeserializerRequest
                                        .EnabledActionsEnum
                                        .READ
                                )
                            )
                            .disabledFields(listOf("x"))
                            .build()
                    )
                )
                .linkedAccountId("string")
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.commonModels())
            .isEqualTo(
                listOf(
                    CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                        .builder()
                        .modelId("hris.Employee")
                        .enabledActions(
                            listOf(
                                CommonModelScopeUpdateParams
                                    .CommonModelScopesPostInnerDeserializerRequest
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
            CommonModelScopeUpdateParams.builder()
                .commonModels(
                    listOf(
                        CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                            .builder()
                            .modelId("hris.Employee")
                            .enabledActions(
                                listOf(
                                    CommonModelScopeUpdateParams
                                        .CommonModelScopesPostInnerDeserializerRequest
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
        assertThat(body.commonModels())
            .isEqualTo(
                listOf(
                    CommonModelScopeUpdateParams.CommonModelScopesPostInnerDeserializerRequest
                        .builder()
                        .modelId("hris.Employee")
                        .enabledActions(
                            listOf(
                                CommonModelScopeUpdateParams
                                    .CommonModelScopesPostInnerDeserializerRequest
                                    .EnabledActionsEnum
                                    .READ
                            )
                        )
                        .disabledFields(listOf("x"))
                        .build()
                )
            )
    }
}
