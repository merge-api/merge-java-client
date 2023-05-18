package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteKeyTest {

    @Test
    fun createRemoteKey() {
        val remoteKey =
            RemoteKey.builder()
                .name("Remote Deployment Key 1")
                .key("hXY57W0g0WkdRHjCaPvwijK63fwfN-o_Wh7f30SLTq_uPCOLo-WFcA")
                .build()
        assertThat(remoteKey).isNotNull
        assertThat(remoteKey.name()).isEqualTo("Remote Deployment Key 1")
        assertThat(remoteKey.key())
            .isEqualTo("hXY57W0g0WkdRHjCaPvwijK63fwfN-o_Wh7f30SLTq_uPCOLo-WFcA")
    }
}
