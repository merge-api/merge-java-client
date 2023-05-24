package dev.merge.api.models

import dev.merge.api.core.JsonString
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteDataTest {

    @Test
    fun createRemoteData() {
        val remoteData = RemoteData.builder().path("string").data(JsonString.of("abc")).build()
        assertThat(remoteData).isNotNull
        assertThat(remoteData.path()).isEqualTo("string")
        assertThat(remoteData._data()).isEqualTo(JsonString.of("abc"))
    }
}
