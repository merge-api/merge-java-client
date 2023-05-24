package dev.merge.api.models

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LinkTokenTest {

    @Test
    fun createLinkToken() {
        val linkToken =
            LinkToken.builder()
                .linkToken("necdP7FtdASl1fQwm62be2_dM4wBG8_GactqoUV0")
                .integrationName("Lever")
                .magicLinkUrl("https://link.merge.dev/asdfjkl12345jsndfgi2i83n")
                .build()
        assertThat(linkToken).isNotNull
        assertThat(linkToken.linkToken()).isEqualTo("necdP7FtdASl1fQwm62be2_dM4wBG8_GactqoUV0")
        assertThat(linkToken.integrationName()).contains("Lever")
        assertThat(linkToken.magicLinkUrl())
            .contains("https://link.merge.dev/asdfjkl12345jsndfgi2i83n")
    }
}
