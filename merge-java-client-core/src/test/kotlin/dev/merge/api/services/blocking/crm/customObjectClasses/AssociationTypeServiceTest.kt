package dev.merge.api.services.blocking.crm.customObjectClasses

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.CustomObjectClassAssociationTypeListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class AssociationTypeServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val associationTypeService = client.crm().customObjectClasses().associationTypes()
        val associationTypeResponse =
            associationTypeService.create(
                CustomObjectClassAssociationTypeCreateParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        CustomObjectClassAssociationTypeCreateParams.AssociationTypeRequestRequest
                            .builder()
                            .sourceObjectClass(
                                CustomObjectClassAssociationTypeCreateParams
                                    .AssociationTypeRequestRequest
                                    .ObjectClassDescriptionRequest
                                    .builder()
                                    .id("x")
                                    .originType(
                                        CustomObjectClassAssociationTypeCreateParams
                                            .AssociationTypeRequestRequest
                                            .ObjectClassDescriptionRequest
                                            .OriginTypeEnum
                                            .CUSTOM_OBJECT
                                    )
                                    .build()
                            )
                            .targetObjectClasses(
                                listOf(
                                    CustomObjectClassAssociationTypeCreateParams
                                        .AssociationTypeRequestRequest
                                        .ObjectClassDescriptionRequest
                                        .builder()
                                        .id("x")
                                        .originType(
                                            CustomObjectClassAssociationTypeCreateParams
                                                .AssociationTypeRequestRequest
                                                .ObjectClassDescriptionRequest
                                                .OriginTypeEnum
                                                .CUSTOM_OBJECT
                                        )
                                        .build()
                                )
                            )
                            .remoteKeyName("x")
                            .displayName("x")
                            .cardinality(
                                CustomObjectClassAssociationTypeCreateParams
                                    .AssociationTypeRequestRequest
                                    .CardinalityEnum
                                    .ONE_TO_ONE
                            )
                            .isRequired(true)
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(associationTypeResponse)
        associationTypeResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val associationTypeService = client.crm().customObjectClasses().associationTypes()
        val associationType =
            associationTypeService.retrieve(
                CustomObjectClassAssociationTypeRetrieveParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(
                        listOf(
                            CustomObjectClassAssociationTypeRetrieveParams.Expand
                                .TARGET_OBJECT_CLASSES
                        )
                    )
                    .includeRemoteData(true)
                    .build()
            )
        println(associationType)
        associationType.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val associationTypeService = client.crm().customObjectClasses().associationTypes()
        val paginatedAssociationTypeList =
            associationTypeService.list(
                CustomObjectClassAssociationTypeListParams.builder()
                    .customObjectClassId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .build()
            )
        println(paginatedAssociationTypeList)
        paginatedAssociationTypeList.results().forEach { it.validate() }
    }
}
