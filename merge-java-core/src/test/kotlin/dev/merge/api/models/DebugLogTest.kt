package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DebugLogTest {

    @Test
    fun createDebugLog() {
        val debugLog =
            DebugLog.builder()
                .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                .dashboardView("https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832")
                .logSummary(
                    DebugLog.DebugModelLogSummary.builder()
                        .url("https://harvest.greenhouse.io/v1/candidates/")
                        .method("POST")
                        .statusCode(123L)
                        .build()
                )
                .build()
        assertThat(debugLog).isNotNull
        assertThat(debugLog.logId()).isEqualTo("99433219-8017-4acd-bb3c-ceb23d663832")
        assertThat(debugLog.dashboardView())
            .isEqualTo("https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832")
        assertThat(debugLog.logSummary())
            .isEqualTo(
                DebugLog.DebugModelLogSummary.builder()
                    .url("https://harvest.greenhouse.io/v1/candidates/")
                    .method("POST")
                    .statusCode(123L)
                    .build()
            )
    }
}
