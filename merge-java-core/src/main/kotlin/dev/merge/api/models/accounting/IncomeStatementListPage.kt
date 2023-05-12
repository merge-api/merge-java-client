package dev.merge.api.models.accounting

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.models.*
import dev.merge.api.services.blocking.accounting.IncomeStatementService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

class IncomeStatementListPage
private constructor(
    private val incomeStatementsService: IncomeStatementService,
    private val params: IncomeStatementListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun next(): String = response().next()

    fun previous(): String = response().previous()

    fun results(): List<IncomeStatement> = response().results()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is IncomeStatementListPage &&
            this.incomeStatementsService == other.incomeStatementsService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            incomeStatementsService,
            params,
            response,
        )
    }

    override fun toString() =
        "IncomeStatementListPage{incomeStatementsService=$incomeStatementsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (results().isEmpty()) {
            return false
        }

        return next().isNotEmpty()
    }

    fun getNextPageParams(): Optional<IncomeStatementListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(IncomeStatementListParams.builder().from(params).cursor(next()).build())
    }

    fun getNextPage(): Optional<IncomeStatementListPage> {
        return getNextPageParams().map { incomeStatementsService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            incomeStatementsService: IncomeStatementService,
            params: IncomeStatementListParams,
            response: Response
        ) =
            IncomeStatementListPage(
                incomeStatementsService,
                params,
                response,
            )
    }

    @JsonDeserialize(builder = Response.Builder::class)
    @NoAutoDetect
    class Response
    constructor(
        private val next: JsonField<String>,
        private val previous: JsonField<String>,
        private val results: JsonField<List<IncomeStatement>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun next(): String = next.getRequired("next")

        fun previous(): String = previous.getRequired("previous")

        fun results(): List<IncomeStatement> = results.getRequired("results")

        @JsonProperty("next") fun _next(): Optional<JsonField<String>> = Optional.ofNullable(next)

        @JsonProperty("previous")
        fun _previous(): Optional<JsonField<String>> = Optional.ofNullable(previous)

        @JsonProperty("results")
        fun _results(): Optional<JsonField<List<IncomeStatement>>> = Optional.ofNullable(results)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate() = apply {
            if (!validated) {
                next()
                previous()
                results().forEach { it.validate() }
                validated = true
            }
        }

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Response &&
                this.next == other.next &&
                this.previous == other.previous &&
                this.results == other.results &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            return Objects.hash(
                next,
                previous,
                results,
                additionalProperties,
            )
        }

        override fun toString() =
            "IncomeStatementListPage.Response{next=$next, previous=$previous, results=$results, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var next: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<String> = JsonMissing.of()
            private var results: JsonField<List<IncomeStatement>> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(page: Response) = apply {
                this.next = page.next
                this.previous = page.previous
                this.results = page.results
                this.additionalProperties.putAll(page.additionalProperties)
            }

            fun next(next: String) = next(JsonField.of(next))

            @JsonProperty("next") fun next(next: JsonField<String>) = apply { this.next = next }

            fun previous(previous: String) = previous(JsonField.of(previous))

            @JsonProperty("previous")
            fun previous(previous: JsonField<String>) = apply { this.previous = previous }

            fun results(results: List<IncomeStatement>) = results(JsonField.of(results))

            @JsonProperty("results")
            fun results(results: JsonField<List<IncomeStatement>>) = apply {
                this.results = results
            }

            @JsonAnySetter
            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                this.additionalProperties.put(key, value)
            }

            fun build() =
                Response(
                    next,
                    previous,
                    results,
                    additionalProperties.toUnmodifiable(),
                )
        }
    }

    class AutoPager
    constructor(
        private val firstPage: IncomeStatementListPage,
    ) : Iterable<IncomeStatement> {

        override fun iterator(): Iterator<IncomeStatement> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.results().size) {
                    yield(page.results()[index++])
                }
                page = page.getNextPage().orElse(null) ?: break
                index = 0
            }
        }

        fun stream(): Stream<IncomeStatement> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
