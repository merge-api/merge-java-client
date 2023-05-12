package dev.merge.api.models.crm

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomObjectTest {

    @Test
    fun createCustomObject() {
        val customObject =
            CustomObject.builder()
                .objectClass("ff1ff4cb-a66b-47dc-8e2a-50388049e602")
                .fields(
                    JsonValue.from(
                        mapOf(
                            "order_id" to "4183634295",
                            "order_quantity" to 50,
                            "customer_type" to "Returning",
                        )
                    )
                )
                .remoteId("4183634295")
                .id("da0b1963-be70-469c-9f8c-06a81d0fe759")
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteFields(
                    listOf(
                        CustomObject.RemoteField.builder()
                            .remoteFieldClass(
                                RemoteFieldClass.builder()
                                    .id("string")
                                    .displayName("string")
                                    .remoteKeyName("string")
                                    .description("string")
                                    .isCustom(true)
                                    .isRequired(true)
                                    .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                                    .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                                    .fieldChoices(listOf("string"))
                                    .itemSchema(
                                        RemoteFieldClass.ItemSchema.builder()
                                            .itemType(JsonString.of("abc"))
                                            .itemFormat(JsonString.of("abc"))
                                            .itemChoices(listOf("string"))
                                            .build()
                                    )
                                    .build()
                            )
                            .value(JsonString.of("abc"))
                            .build()
                    )
                )
                .build()
        assertThat(customObject).isNotNull
        assertThat(customObject.objectClass()).contains("ff1ff4cb-a66b-47dc-8e2a-50388049e602")
        assertThat(customObject._fields())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "order_id" to "4183634295",
                        "order_quantity" to 50,
                        "customer_type" to "Returning",
                    )
                )
            )
        assertThat(customObject.remoteId()).contains("4183634295")
        assertThat(customObject.id()).contains("da0b1963-be70-469c-9f8c-06a81d0fe759")
        assertThat(customObject.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(customObject.remoteFields().get())
            .containsExactly(
                CustomObject.RemoteField.builder()
                    .remoteFieldClass(
                        RemoteFieldClass.builder()
                            .id("string")
                            .displayName("string")
                            .remoteKeyName("string")
                            .description("string")
                            .isCustom(true)
                            .isRequired(true)
                            .fieldType(RemoteFieldClass.FieldTypeEnum.STRING)
                            .fieldFormat(RemoteFieldClass.FieldFormatEnum.STRING)
                            .fieldChoices(listOf("string"))
                            .itemSchema(
                                RemoteFieldClass.ItemSchema.builder()
                                    .itemType(JsonString.of("abc"))
                                    .itemFormat(JsonString.of("abc"))
                                    .itemChoices(listOf("string"))
                                    .build()
                            )
                            .build()
                    )
                    .value(JsonString.of("abc"))
                    .build()
            )
    }
}
