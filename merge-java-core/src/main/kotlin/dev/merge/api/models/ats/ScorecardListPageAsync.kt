package dev.merge.api.models.ats

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
import dev.merge.api.services.async.ats.ScorecardServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class ScorecardListPageAsync
private constructor(
    private val scorecardsService: ScorecardServiceAsync,
    private val params: ScorecardListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun next(): String = response().next()

    fun previous(): String = response().previous()

    fun results(): List<Scorecard> = response().results()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ScorecardListPageAsync &&
            this.scorecardsService == other.scorecardsService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            scorecardsService,
            params,
            response,
        )
    }

    override fun toString() =
        "ScorecardListPageAsync{scorecardsService=$scorecardsService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (results().isEmpty()) {
            return false
        }

        return next().isNotEmpty()
    }

    fun getNextPageParams(): Optional<ScorecardListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(ScorecardListParams.builder().from(params).cursor(next()).build())
    }

    fun getNextPage(): CompletableFuture<Optional<ScorecardListPageAsync>> {
        return getNextPageParams()
            .map { scorecardsService.list(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            scorecardsService: ScorecardServiceAsync,
            params: ScorecardListParams,
            response: Response
        ) =
            ScorecardListPageAsync(
                scorecardsService,
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
        private val results: JsonField<List<Scorecard>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun next(): String = next.getRequired("next")

        fun previous(): String = previous.getRequired("previous")

        fun results(): List<Scorecard> = results.getRequired("results")

        @JsonProperty("next") fun _next(): Optional<JsonField<String>> = Optional.ofNullable(next)

        @JsonProperty("previous")
        fun _previous(): Optional<JsonField<String>> = Optional.ofNullable(previous)

        @JsonProperty("results")
        fun _results(): Optional<JsonField<List<Scorecard>>> = Optional.ofNullable(results)

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
            "ScorecardListPageAsync.Response{next=$next, previous=$previous, results=$results, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var next: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<String> = JsonMissing.of()
            private var results: JsonField<List<Scorecard>> = JsonMissing.of()
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

            fun results(results: List<Scorecard>) = results(JsonField.of(results))

            @JsonProperty("results")
            fun results(results: JsonField<List<Scorecard>>) = apply { this.results = results }

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
        private val firstPage: ScorecardListPageAsync,
    ) {

        fun forEach(action: Predicate<Scorecard>, executor: Executor): CompletableFuture<Void> {
            fun CompletableFuture<Optional<ScorecardListPageAsync>>.forEach(
                action: (Scorecard) -> Boolean,
                executor: Executor
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.results().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<Scorecard>> {
            val values = mutableListOf<Scorecard>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
