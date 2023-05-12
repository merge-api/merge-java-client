package dev.merge.api.models.crm

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RemoteKeyRegenerateParamsTest {

    @Test
    fun createRemoteKeyRegenerateParams() {
        RemoteKeyRegenerateParams.builder().name("Remote Deployment Key 1").build()
    }

    @Test
    fun getBody() {
        val params = RemoteKeyRegenerateParams.builder().name("Remote Deployment Key 1").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("Remote Deployment Key 1")
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params = RemoteKeyRegenerateParams.builder().name("Remote Deployment Key 1").build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.name()).isEqualTo("Remote Deployment Key 1")
    }
}
