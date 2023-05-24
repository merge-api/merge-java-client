package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AvailableActionTest {

    @Test
    fun createAvailableAction() {
        val availableAction =
            AvailableAction.builder()
                .integration(
                    AvailableAction.AccountIntegration.builder()
                        .name("string")
                        .categories(listOf(AvailableAction.AccountIntegration.CategoriesEnum.HRIS))
                        .image("https://example.com")
                        .squareImage("https://example.com")
                        .color("string")
                        .slug("string")
                        .isInBeta(true)
                        .apiEndpointsToDocumentationUrls(JsonString.of("abc"))
                        .build()
                )
                .passthroughAvailable(true)
                .availableModelOperations(
                    listOf(
                        AvailableAction.ModelOperation.builder()
                            .modelName("Candidate")
                            .availableOperations(listOf("string"))
                            .requiredPostParameters(listOf("string"))
                            .supportedFields(listOf("string"))
                            .build()
                    )
                )
                .build()
        assertThat(availableAction).isNotNull
        assertThat(availableAction.integration())
            .isEqualTo(
                AvailableAction.AccountIntegration.builder()
                    .name("string")
                    .categories(listOf(AvailableAction.AccountIntegration.CategoriesEnum.HRIS))
                    .image("https://example.com")
                    .squareImage("https://example.com")
                    .color("string")
                    .slug("string")
                    .isInBeta(true)
                    .apiEndpointsToDocumentationUrls(JsonString.of("abc"))
                    .build()
            )
        assertThat(availableAction.passthroughAvailable()).isEqualTo(true)
        assertThat(availableAction.availableModelOperations().get())
            .containsExactly(
                AvailableAction.ModelOperation.builder()
                    .modelName("Candidate")
                    .availableOperations(listOf("string"))
                    .requiredPostParameters(listOf("string"))
                    .supportedFields(listOf("string"))
                    .build()
            )
    }
}
