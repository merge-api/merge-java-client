package dev.merge.api.services

import com.fasterxml.jackson.databind.json.JsonMapper
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.google.common.collect.ImmutableListMultimap
import com.google.common.collect.ListMultimap
import dev.merge.api.client.MergeClient
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonString
import dev.merge.api.core.jsonMapper
import dev.merge.api.errors.BadRequestException
import dev.merge.api.errors.InternalServerException
import dev.merge.api.errors.MergeError
import dev.merge.api.errors.MergeException
import dev.merge.api.errors.NotFoundException
import dev.merge.api.errors.PermissionDeniedException
import dev.merge.api.errors.RateLimitException
import dev.merge.api.errors.UnauthorizedException
import dev.merge.api.errors.UnexpectedStatusCodeException
import dev.merge.api.errors.UnprocessableEntityException
import dev.merge.api.models.*
import dev.merge.api.models.hris.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.InstanceOfAssertFactories
import org.assertj.guava.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

@WireMockTest
class ErrorHandlingTest {

    private val JSON_MAPPER: JsonMapper = jsonMapper()

    private val API_KEY: String = "apiKey"

    private val MERGE_ERROR: MergeError =
        MergeError.builder().putAdditionalProperty("key", JsonString.of("value")).build()

    private lateinit var client: MergeClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            MergeOkHttpClient.builder()
                .apiKey(API_KEY)
                .baseUrl(wmRuntimeInfo.getHttpBaseUrl())
                .accountToken("<account-token>")
                .build()
    }

    @Test
    fun accountDetailsRetrieve200() {
        val params = AccountDetailRetrieveParams.builder().build()

        val expected =
            AccountDetail.builder()
                .id("0496d4c2-42e6-4072-80b3-7b69bfdc76fd")
                .integration("BambooHR")
                .integrationSlug("bamboohr")
                .category(AccountDetail.CategoryEnum.HRIS)
                .endUserOriginId("3fa85f64-5717-4562-b3fc-2c963f66afa6")
                .endUserOrganizationName("Waystar Royco")
                .endUserEmailAddress("kendall.roy@waystar-royco.com")
                .status("COMPLETE")
                .webhookListenerUrl(
                    "https://api.merge.dev/api/integrations/webhook-listener/7fc3mee0UW8ecV4"
                )
                .isDuplicate(true)
                .build()

        stubFor(get(anyUrl()).willReturn(ok().withBody(toJson(expected))))

        assertThat(client.hris().accountDetails().retrieve(params)).isEqualTo(expected)
    }

    @Test
    fun accountDetailsRetrieve400() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(400).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve401() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(401).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertUnauthorized(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve403() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(403).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertPermissionDenied(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve404() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(404).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertNotFound(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve422() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(422).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertUnprocessableEntity(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve429() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(429).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertRateLimit(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun accountDetailsRetrieve500() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(500).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertInternalServer(e, ImmutableListMultimap.of("Foo", "Bar"), MERGE_ERROR)
            })
    }

    @Test
    fun unexpectedStatusCode() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(
            get(anyUrl())
                .willReturn(status(999).withHeader("Foo", "Bar").withBody(toJson(MERGE_ERROR)))
        )

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertUnexpectedStatusCodeException(
                    e,
                    999,
                    ImmutableListMultimap.of("Foo", "Bar"),
                    toJson(MERGE_ERROR)
                )
            })
    }

    @Test
    fun invalidBody() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(get(anyUrl()).willReturn(status(200).withBody("Not JSON")))

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertThat(e)
                    .isInstanceOf(MergeException::class.java)
                    .hasMessage("Error reading response")
            })
    }

    @Test
    fun invalidErrorBody() {
        val params = AccountDetailRetrieveParams.builder().build()

        stubFor(get(anyUrl()).willReturn(status(400).withBody("Not JSON")))

        assertThatThrownBy({ client.hris().accountDetails().retrieve(params) })
            .satisfies({ e ->
                assertBadRequest(e, ImmutableListMultimap.of(), MergeError.builder().build())
            })
    }

    private fun <T> toJson(body: T): ByteArray {
        return JSON_MAPPER.writeValueAsBytes(body)
    }

    private fun assertUnexpectedStatusCodeException(
        throwable: Throwable,
        statusCode: Int,
        headers: ListMultimap<String, String>,
        responseBody: ByteArray
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnexpectedStatusCodeException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(statusCode)
                assertThat(e.body()).isEqualTo(String(responseBody))
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertBadRequest(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(BadRequestException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(400)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnauthorized(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(UnauthorizedException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(401)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertPermissionDenied(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(PermissionDeniedException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(403)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertNotFound(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(NotFoundException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(404)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertUnprocessableEntity(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(
                InstanceOfAssertFactories.throwable(UnprocessableEntityException::class.java)
            )
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(422)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertRateLimit(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(RateLimitException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(429)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }

    private fun assertInternalServer(
        throwable: Throwable,
        headers: ListMultimap<String, String>,
        error: MergeError
    ) {
        assertThat(throwable)
            .asInstanceOf(InstanceOfAssertFactories.throwable(InternalServerException::class.java))
            .satisfies({ e ->
                assertThat(e.statusCode()).isEqualTo(500)
                assertThat(e.error()).isEqualTo(error)
                assertThat(e.headers()).containsAllEntriesOf(headers)
            })
    }
}
