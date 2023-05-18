package dev.merge.api.models.crm

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
import dev.merge.api.services.async.crm.SelectiveSyncServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate

class SelectiveSyncListMetadataPageAsync
private constructor(
    private val selectiveSyncService: SelectiveSyncServiceAsync,
    private val params: SelectiveSyncListMetadataParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun next(): Optional<String> = response().next()

    fun previous(): Optional<String> = response().previous()

    fun results(): List<ConditionSchema> = response().results()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SelectiveSyncListMetadataPageAsync &&
            this.selectiveSyncService == other.selectiveSyncService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            selectiveSyncService,
            params,
            response,
        )
    }

    override fun toString() =
        "SelectiveSyncListMetadataPageAsync{selectiveSyncService=$selectiveSyncService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (results().isEmpty()) {
            return false
        }

        return next().filter { it.isNotEmpty() }.isPresent
    }

    fun getNextPageParams(): Optional<SelectiveSyncListMetadataParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            SelectiveSyncListMetadataParams.builder()
                .from(params)
                .apply { next().ifPresent { this.cursor(it) } }
                .build()
        )
    }

    fun getNextPage(): CompletableFuture<Optional<SelectiveSyncListMetadataPageAsync>> {
        return getNextPageParams()
            .map { selectiveSyncService.listMetadata(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            selectiveSyncService: SelectiveSyncServiceAsync,
            params: SelectiveSyncListMetadataParams,
            response: Response
        ) =
            SelectiveSyncListMetadataPageAsync(
                selectiveSyncService,
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
        private val results: JsonField<List<ConditionSchema>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun next(): Optional<String> = Optional.ofNullable(next.getNullable("next"))

        fun previous(): Optional<String> = Optional.ofNullable(previous.getNullable("previous"))

        fun results(): List<ConditionSchema> = results.getNullable("results") ?: listOf()

        @JsonProperty("next") fun _next(): Optional<JsonField<String>> = Optional.ofNullable(next)

        @JsonProperty("previous")
        fun _previous(): Optional<JsonField<String>> = Optional.ofNullable(previous)

        @JsonProperty("results")
        fun _results(): Optional<JsonField<List<ConditionSchema>>> = Optional.ofNullable(results)

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun validate(): Response = apply {
            if (!validated) {
                next()
                previous()
                results().map { it.validate() }
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
            "SelectiveSyncListMetadataPageAsync.Response{next=$next, previous=$previous, results=$results, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var next: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<String> = JsonMissing.of()
            private var results: JsonField<List<ConditionSchema>> = JsonMissing.of()
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

            fun results(results: List<ConditionSchema>) = results(JsonField.of(results))

            @JsonProperty("results")
            fun results(results: JsonField<List<ConditionSchema>>) = apply {
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
        private val firstPage: SelectiveSyncListMetadataPageAsync,
    ) {

        fun forEach(
            action: Predicate<ConditionSchema>,
            executor: Executor
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<SelectiveSyncListMetadataPageAsync>>.forEach(
                action: (ConditionSchema) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<ConditionSchema>> {
            val values = mutableListOf<ConditionSchema>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
