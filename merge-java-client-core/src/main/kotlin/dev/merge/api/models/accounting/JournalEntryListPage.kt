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
import dev.merge.api.services.blocking.accounting.JournalEntryService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport

class JournalEntryListPage
private constructor(
    private val journalEntriesService: JournalEntryService,
    private val params: JournalEntryListParams,
    private val response: Response,
) {

    fun response(): Response = response

    fun next(): Optional<String> = response().next()

    fun previous(): Optional<String> = response().previous()

    fun results(): List<JournalEntry> = response().results()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is JournalEntryListPage &&
            this.journalEntriesService == other.journalEntriesService &&
            this.params == other.params &&
            this.response == other.response
    }

    override fun hashCode(): Int {
        return Objects.hash(
            journalEntriesService,
            params,
            response,
        )
    }

    override fun toString() =
        "JournalEntryListPage{journalEntriesService=$journalEntriesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean {
        if (results().isEmpty()) {
            return false
        }

        return next().isPresent()
    }

    fun getNextPageParams(): Optional<JournalEntryListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(
            JournalEntryListParams.builder()
                .from(params)
                .apply { next().ifPresent { this.cursor(it) } }
                .build()
        )
    }

    fun getNextPage(): Optional<JournalEntryListPage> {
        return getNextPageParams().map { journalEntriesService.list(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            journalEntriesService: JournalEntryService,
            params: JournalEntryListParams,
            response: Response
        ) =
            JournalEntryListPage(
                journalEntriesService,
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
        private val results: JsonField<List<JournalEntry>>,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var validated: Boolean = false

        fun next(): Optional<String> = Optional.ofNullable(next.getNullable("next"))

        fun previous(): Optional<String> = Optional.ofNullable(previous.getNullable("previous"))

        fun results(): List<JournalEntry> = results.getNullable("results") ?: listOf()

        @JsonProperty("next") fun _next(): Optional<JsonField<String>> = Optional.ofNullable(next)

        @JsonProperty("previous")
        fun _previous(): Optional<JsonField<String>> = Optional.ofNullable(previous)

        @JsonProperty("results")
        fun _results(): Optional<JsonField<List<JournalEntry>>> = Optional.ofNullable(results)

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
            "JournalEntryListPage.Response{next=$next, previous=$previous, results=$results, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var next: JsonField<String> = JsonMissing.of()
            private var previous: JsonField<String> = JsonMissing.of()
            private var results: JsonField<List<JournalEntry>> = JsonMissing.of()
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

            fun results(results: List<JournalEntry>) = results(JsonField.of(results))

            @JsonProperty("results")
            fun results(results: JsonField<List<JournalEntry>>) = apply { this.results = results }

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
        private val firstPage: JournalEntryListPage,
    ) : Iterable<JournalEntry> {

        override fun iterator(): Iterator<JournalEntry> = iterator {
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

        fun stream(): Stream<JournalEntry> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
