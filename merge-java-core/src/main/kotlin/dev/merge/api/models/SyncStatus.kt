package dev.merge.api.models

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonMissing
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The SyncStatus Object
 *
 * ### Description
 *
 * The `SyncStatus` object is used to represent the syncing state of an account
 *
 * ### Usage Example
 *
 * View the `SyncStatus` for an account to see how recently its models were synced.
 */
@JsonDeserialize(builder = SyncStatus.Builder::class)
@NoAutoDetect
class SyncStatus
private constructor(
    private val modelName: JsonField<String>,
    private val modelId: JsonField<String>,
    private val lastSyncStart: JsonField<OffsetDateTime>,
    private val nextSyncStart: JsonField<OffsetDateTime>,
    private val status: JsonField<SyncStatusStatusEnum>,
    private val isInitialSync: JsonField<Boolean>,
    private val selectiveSyncConfigurationsUsage: JsonField<SelectiveSyncConfigurationsUsageEnum>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    fun modelName(): String = modelName.getRequired("model_name")

    fun modelId(): String = modelId.getRequired("model_id")

    fun lastSyncStart(): Optional<OffsetDateTime> =
        Optional.ofNullable(lastSyncStart.getNullable("last_sync_start"))

    fun nextSyncStart(): Optional<OffsetDateTime> =
        Optional.ofNullable(nextSyncStart.getNullable("next_sync_start"))

    /**
     * - `SYNCING` - SYNCING
     * - `DONE` - DONE
     * - `FAILED` - FAILED
     * - `DISABLED` - DISABLED
     * - `PAUSED` - PAUSED
     */
    fun status(): SyncStatusStatusEnum = status.getRequired("status")

    fun isInitialSync(): Boolean = isInitialSync.getRequired("is_initial_sync")

    /**
     * - `IN_NEXT_SYNC` - IN_NEXT_SYNC
     * - `IN_LAST_SYNC` - IN_LAST_SYNC
     */
    fun selectiveSyncConfigurationsUsage(): Optional<SelectiveSyncConfigurationsUsageEnum> =
        Optional.ofNullable(
            selectiveSyncConfigurationsUsage.getNullable("selective_sync_configurations_usage")
        )

    @JsonProperty("model_name") @ExcludeMissing fun _modelName() = modelName

    @JsonProperty("model_id") @ExcludeMissing fun _modelId() = modelId

    @JsonProperty("last_sync_start") @ExcludeMissing fun _lastSyncStart() = lastSyncStart

    @JsonProperty("next_sync_start") @ExcludeMissing fun _nextSyncStart() = nextSyncStart

    /**
     * - `SYNCING` - SYNCING
     * - `DONE` - DONE
     * - `FAILED` - FAILED
     * - `DISABLED` - DISABLED
     * - `PAUSED` - PAUSED
     */
    @JsonProperty("status") @ExcludeMissing fun _status() = status

    @JsonProperty("is_initial_sync") @ExcludeMissing fun _isInitialSync() = isInitialSync

    /**
     * - `IN_NEXT_SYNC` - IN_NEXT_SYNC
     * - `IN_LAST_SYNC` - IN_LAST_SYNC
     */
    @JsonProperty("selective_sync_configurations_usage")
    @ExcludeMissing
    fun _selectiveSyncConfigurationsUsage() = selectiveSyncConfigurationsUsage

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            modelName()
            modelId()
            lastSyncStart()
            nextSyncStart()
            status()
            isInitialSync()
            selectiveSyncConfigurationsUsage()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SyncStatus &&
            this.modelName == other.modelName &&
            this.modelId == other.modelId &&
            this.lastSyncStart == other.lastSyncStart &&
            this.nextSyncStart == other.nextSyncStart &&
            this.status == other.status &&
            this.isInitialSync == other.isInitialSync &&
            this.selectiveSyncConfigurationsUsage == other.selectiveSyncConfigurationsUsage &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    modelName,
                    modelId,
                    lastSyncStart,
                    nextSyncStart,
                    status,
                    isInitialSync,
                    selectiveSyncConfigurationsUsage,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "SyncStatus{modelName=$modelName, modelId=$modelId, lastSyncStart=$lastSyncStart, nextSyncStart=$nextSyncStart, status=$status, isInitialSync=$isInitialSync, selectiveSyncConfigurationsUsage=$selectiveSyncConfigurationsUsage, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var modelName: JsonField<String> = JsonMissing.of()
        private var modelId: JsonField<String> = JsonMissing.of()
        private var lastSyncStart: JsonField<OffsetDateTime> = JsonMissing.of()
        private var nextSyncStart: JsonField<OffsetDateTime> = JsonMissing.of()
        private var status: JsonField<SyncStatusStatusEnum> = JsonMissing.of()
        private var isInitialSync: JsonField<Boolean> = JsonMissing.of()
        private var selectiveSyncConfigurationsUsage:
            JsonField<SelectiveSyncConfigurationsUsageEnum> =
            JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(syncStatus: SyncStatus) = apply {
            this.modelName = syncStatus.modelName
            this.modelId = syncStatus.modelId
            this.lastSyncStart = syncStatus.lastSyncStart
            this.nextSyncStart = syncStatus.nextSyncStart
            this.status = syncStatus.status
            this.isInitialSync = syncStatus.isInitialSync
            this.selectiveSyncConfigurationsUsage = syncStatus.selectiveSyncConfigurationsUsage
            additionalProperties(syncStatus.additionalProperties)
        }

        fun modelName(modelName: String) = modelName(JsonField.of(modelName))

        @JsonProperty("model_name")
        @ExcludeMissing
        fun modelName(modelName: JsonField<String>) = apply { this.modelName = modelName }

        fun modelId(modelId: String) = modelId(JsonField.of(modelId))

        @JsonProperty("model_id")
        @ExcludeMissing
        fun modelId(modelId: JsonField<String>) = apply { this.modelId = modelId }

        fun lastSyncStart(lastSyncStart: OffsetDateTime) =
            lastSyncStart(JsonField.of(lastSyncStart))

        @JsonProperty("last_sync_start")
        @ExcludeMissing
        fun lastSyncStart(lastSyncStart: JsonField<OffsetDateTime>) = apply {
            this.lastSyncStart = lastSyncStart
        }

        fun nextSyncStart(nextSyncStart: OffsetDateTime) =
            nextSyncStart(JsonField.of(nextSyncStart))

        @JsonProperty("next_sync_start")
        @ExcludeMissing
        fun nextSyncStart(nextSyncStart: JsonField<OffsetDateTime>) = apply {
            this.nextSyncStart = nextSyncStart
        }

        /**
         * - `SYNCING` - SYNCING
         * - `DONE` - DONE
         * - `FAILED` - FAILED
         * - `DISABLED` - DISABLED
         * - `PAUSED` - PAUSED
         */
        fun status(status: SyncStatusStatusEnum) = status(JsonField.of(status))

        /**
         * - `SYNCING` - SYNCING
         * - `DONE` - DONE
         * - `FAILED` - FAILED
         * - `DISABLED` - DISABLED
         * - `PAUSED` - PAUSED
         */
        @JsonProperty("status")
        @ExcludeMissing
        fun status(status: JsonField<SyncStatusStatusEnum>) = apply { this.status = status }

        fun isInitialSync(isInitialSync: Boolean) = isInitialSync(JsonField.of(isInitialSync))

        @JsonProperty("is_initial_sync")
        @ExcludeMissing
        fun isInitialSync(isInitialSync: JsonField<Boolean>) = apply {
            this.isInitialSync = isInitialSync
        }

        /**
         * - `IN_NEXT_SYNC` - IN_NEXT_SYNC
         * - `IN_LAST_SYNC` - IN_LAST_SYNC
         */
        fun selectiveSyncConfigurationsUsage(
            selectiveSyncConfigurationsUsage: SelectiveSyncConfigurationsUsageEnum
        ) = selectiveSyncConfigurationsUsage(JsonField.of(selectiveSyncConfigurationsUsage))

        /**
         * - `IN_NEXT_SYNC` - IN_NEXT_SYNC
         * - `IN_LAST_SYNC` - IN_LAST_SYNC
         */
        @JsonProperty("selective_sync_configurations_usage")
        @ExcludeMissing
        fun selectiveSyncConfigurationsUsage(
            selectiveSyncConfigurationsUsage: JsonField<SelectiveSyncConfigurationsUsageEnum>
        ) = apply { this.selectiveSyncConfigurationsUsage = selectiveSyncConfigurationsUsage }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            this.additionalProperties.putAll(additionalProperties)
        }

        @JsonAnySetter
        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            this.additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun build(): SyncStatus =
            SyncStatus(
                modelName,
                modelId,
                lastSyncStart,
                nextSyncStart,
                status,
                isInitialSync,
                selectiveSyncConfigurationsUsage,
                additionalProperties.toUnmodifiable(),
            )
    }

    class SyncStatusStatusEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SyncStatusStatusEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField val SYNCING = SyncStatusStatusEnum(JsonField.of("SYNCING"))

            @JvmField val DONE = SyncStatusStatusEnum(JsonField.of("DONE"))

            @JvmField val FAILED = SyncStatusStatusEnum(JsonField.of("FAILED"))

            @JvmField val DISABLED = SyncStatusStatusEnum(JsonField.of("DISABLED"))

            @JvmField val PAUSED = SyncStatusStatusEnum(JsonField.of("PAUSED"))

            @JvmStatic fun of(value: String) = SyncStatusStatusEnum(JsonField.of(value))
        }

        enum class Known {
            SYNCING,
            DONE,
            FAILED,
            DISABLED,
            PAUSED,
        }

        enum class Value {
            SYNCING,
            DONE,
            FAILED,
            DISABLED,
            PAUSED,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                SYNCING -> Value.SYNCING
                DONE -> Value.DONE
                FAILED -> Value.FAILED
                DISABLED -> Value.DISABLED
                PAUSED -> Value.PAUSED
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                SYNCING -> Known.SYNCING
                DONE -> Known.DONE
                FAILED -> Known.FAILED
                DISABLED -> Known.DISABLED
                PAUSED -> Known.PAUSED
                else -> throw MergeInvalidDataException("Unknown SyncStatusStatusEnum: $value")
            }

        fun asString(): String = _value().asStringOrThrow()
    }

    class SelectiveSyncConfigurationsUsageEnum
    @JsonCreator
    private constructor(
        private val value: JsonField<String>,
    ) {

        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is SelectiveSyncConfigurationsUsageEnum && this.value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()

        companion object {

            @JvmField
            val IN_NEXT_SYNC = SelectiveSyncConfigurationsUsageEnum(JsonField.of("IN_NEXT_SYNC"))

            @JvmField
            val IN_LAST_SYNC = SelectiveSyncConfigurationsUsageEnum(JsonField.of("IN_LAST_SYNC"))

            @JvmStatic
            fun of(value: String) = SelectiveSyncConfigurationsUsageEnum(JsonField.of(value))
        }

        enum class Known {
            IN_NEXT_SYNC,
            IN_LAST_SYNC,
        }

        enum class Value {
            IN_NEXT_SYNC,
            IN_LAST_SYNC,
            _UNKNOWN,
        }

        fun value(): Value =
            when (this) {
                IN_NEXT_SYNC -> Value.IN_NEXT_SYNC
                IN_LAST_SYNC -> Value.IN_LAST_SYNC
                else -> Value._UNKNOWN
            }

        fun known(): Known =
            when (this) {
                IN_NEXT_SYNC -> Known.IN_NEXT_SYNC
                IN_LAST_SYNC -> Known.IN_LAST_SYNC
                else ->
                    throw MergeInvalidDataException(
                        "Unknown SelectiveSyncConfigurationsUsageEnum: $value"
                    )
            }

        fun asString(): String = _value().asStringOrThrow()
    }
}
