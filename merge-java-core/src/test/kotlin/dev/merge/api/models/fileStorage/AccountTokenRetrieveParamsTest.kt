package dev.merge.api.models.fileStorage

import dev.merge.api.models.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AccountTokenRetrieveParamsTest {

    @Test
    fun createAccountTokenRetrieveParams() {
        AccountTokenRetrieveParams.builder().publicToken("string").build()
    }

    @Test
    fun getPathParam() {
        val params = AccountTokenRetrieveParams.builder().publicToken("string").build()
        assertThat(params).isNotNull
        // path param "publicToken"
        assertThat(params.getPathParam(0)).isEqualTo("string")
        // out-of-bound path param
        assertThat(params.getPathParam(1)).isEqualTo("")
    }
}
