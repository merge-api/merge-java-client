package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomObjectClassTest {

    @Test
    fun createCustomObjectClass() {
        val customObjectClass =
            CustomObjectClass.builder()
                .name("order")
                .description("Order object")
                .labels(CustomObjectClass.Labels.builder().build())
                .fields(
                    listOf(
                        CustomObjectClass.RemoteFieldClassForCustomObjectClass.builder()
                            .displayName("string")
                            .remoteKeyName("string")
                            .description("string")
                            .isRequired(true)
                            .fieldType(
                                CustomObjectClass.RemoteFieldClassForCustomObjectClass.FieldTypeEnum
                                    .STRING
                            )
                            .fieldFormat(
                                CustomObjectClass.RemoteFieldClassForCustomObjectClass
                                    .FieldFormatEnum
                                    .STRING
                            )
                            .fieldChoices(listOf("string"))
                            .itemSchema(
                                CustomObjectClass.RemoteFieldClassForCustomObjectClass.ItemSchema
                                    .builder()
                                    .itemType("string")
                                    .itemFormat("string")
                                    .itemChoices(listOf("string"))
                                    .build()
                            )
                            .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                            .build()
                    )
                )
                .associationTypes(listOf(JsonString.of("abc")))
                .id("ff1ff4cb-a66b-47dc-8e2a-50388049e602")
                .remoteId("9579977")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .build()
        assertThat(customObjectClass).isNotNull
        assertThat(customObjectClass.name()).contains("order")
        assertThat(customObjectClass.description()).contains("Order object")
        assertThat(customObjectClass.labels()).contains(CustomObjectClass.Labels.builder().build())
        assertThat(customObjectClass.fields().get())
            .containsExactly(
                CustomObjectClass.RemoteFieldClassForCustomObjectClass.builder()
                    .displayName("string")
                    .remoteKeyName("string")
                    .description("string")
                    .isRequired(true)
                    .fieldType(
                        CustomObjectClass.RemoteFieldClassForCustomObjectClass.FieldTypeEnum.STRING
                    )
                    .fieldFormat(
                        CustomObjectClass.RemoteFieldClassForCustomObjectClass.FieldFormatEnum
                            .STRING
                    )
                    .fieldChoices(listOf("string"))
                    .itemSchema(
                        CustomObjectClass.RemoteFieldClassForCustomObjectClass.ItemSchema.builder()
                            .itemType("string")
                            .itemFormat("string")
                            .itemChoices(listOf("string"))
                            .build()
                    )
                    .modifiedAt(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )
        assertThat(customObjectClass.associationTypes().get()).containsExactly(JsonString.of("abc"))
        assertThat(customObjectClass.id()).contains("ff1ff4cb-a66b-47dc-8e2a-50388049e602")
        assertThat(customObjectClass.remoteId()).contains("9579977")
        assertThat(customObjectClass.modifiedAt())
            .contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
    }
}
