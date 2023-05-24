package dev.merge.api.models.crm

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import dev.merge.api.core.ExcludeMissing
import dev.merge.api.core.JsonField
import dev.merge.api.core.JsonValue
import dev.merge.api.core.NoAutoDetect
import dev.merge.api.core.toUnmodifiable
import dev.merge.api.errors.MergeInvalidDataException
import dev.merge.api.models.*
import java.util.Objects
import java.util.Optional

class CustomObjectClassAssociationTypeCreateParams
constructor(
    private val customObjectClassId: String,
    private val model: AssociationTypeRequestRequest,
    private val isDebugMode: Boolean?,
    private val runAsync: Boolean?,
    private val additionalQueryParams: Map<String, List<String>>,
    private val additionalHeaders: Map<String, List<String>>,
    private val additionalBodyProperties: Map<String, JsonValue>,
) {

    fun customObjectClassId(): String = customObjectClassId

    fun model(): AssociationTypeRequestRequest = model

    fun isDebugMode(): Optional<Boolean> = Optional.ofNullable(isDebugMode)

    fun runAsync(): Optional<Boolean> = Optional.ofNullable(runAsync)

    @JvmSynthetic
    internal fun getBody(): CustomObjectClassAssociationTypeCreateBody {
        return CustomObjectClassAssociationTypeCreateBody(model, additionalBodyProperties)
    }

    @JvmSynthetic
    internal fun getQueryParams(): Map<String, List<String>> {
        val params = mutableMapOf<String, List<String>>()
        this.isDebugMode?.let { params.put("is_debug_mode", listOf(it.toString())) }
        this.runAsync?.let { params.put("run_async", listOf(it.toString())) }
        params.putAll(additionalQueryParams)
        return params.toUnmodifiable()
    }

    @JvmSynthetic internal fun getHeaders(): Map<String, List<String>> = additionalHeaders

    fun getPathParam(index: Int): String {
        return when (index) {
            0 -> customObjectClassId
            else -> ""
        }
    }

    @JsonDeserialize(builder = CustomObjectClassAssociationTypeCreateBody.Builder::class)
    @NoAutoDetect
    class CustomObjectClassAssociationTypeCreateBody
    internal constructor(
        private val model: AssociationTypeRequestRequest?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("model") fun model(): AssociationTypeRequestRequest? = model

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CustomObjectClassAssociationTypeCreateBody &&
                this.model == other.model &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode = Objects.hash(model, additionalProperties)
            }
            return hashCode
        }

        override fun toString() =
            "CustomObjectClassAssociationTypeCreateBody{model=$model, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var model: AssociationTypeRequestRequest? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(
                customObjectClassAssociationTypeCreateBody:
                    CustomObjectClassAssociationTypeCreateBody
            ) = apply {
                this.model = customObjectClassAssociationTypeCreateBody.model
                additionalProperties(
                    customObjectClassAssociationTypeCreateBody.additionalProperties
                )
            }

            @JsonProperty("model")
            fun model(model: AssociationTypeRequestRequest) = apply { this.model = model }

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

            fun build(): CustomObjectClassAssociationTypeCreateBody =
                CustomObjectClassAssociationTypeCreateBody(
                    checkNotNull(model) { "`model` is required but was not set" },
                    additionalProperties.toUnmodifiable()
                )
        }
    }

    fun _additionalQueryParams(): Map<String, List<String>> = additionalQueryParams

    fun _additionalHeaders(): Map<String, List<String>> = additionalHeaders

    fun _additionalBodyProperties(): Map<String, JsonValue> = additionalBodyProperties

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CustomObjectClassAssociationTypeCreateParams &&
            this.customObjectClassId == other.customObjectClassId &&
            this.model == other.model &&
            this.isDebugMode == other.isDebugMode &&
            this.runAsync == other.runAsync &&
            this.additionalQueryParams == other.additionalQueryParams &&
            this.additionalHeaders == other.additionalHeaders &&
            this.additionalBodyProperties == other.additionalBodyProperties
    }

    override fun hashCode(): Int {
        return Objects.hash(
            customObjectClassId,
            model,
            isDebugMode,
            runAsync,
            additionalQueryParams,
            additionalHeaders,
            additionalBodyProperties,
        )
    }

    override fun toString() =
        "CustomObjectClassAssociationTypeCreateParams{customObjectClassId=$customObjectClassId, model=$model, isDebugMode=$isDebugMode, runAsync=$runAsync, additionalQueryParams=$additionalQueryParams, additionalHeaders=$additionalHeaders, additionalBodyProperties=$additionalBodyProperties}"

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    @NoAutoDetect
    class Builder {

        private var customObjectClassId: String? = null
        private var model: AssociationTypeRequestRequest? = null
        private var isDebugMode: Boolean? = null
        private var runAsync: Boolean? = null
        private var additionalQueryParams: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalHeaders: MutableMap<String, MutableList<String>> = mutableMapOf()
        private var additionalBodyProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(
            customObjectClassAssociationTypeCreateParams:
                CustomObjectClassAssociationTypeCreateParams
        ) = apply {
            this.customObjectClassId =
                customObjectClassAssociationTypeCreateParams.customObjectClassId
            this.model = customObjectClassAssociationTypeCreateParams.model
            this.isDebugMode = customObjectClassAssociationTypeCreateParams.isDebugMode
            this.runAsync = customObjectClassAssociationTypeCreateParams.runAsync
            additionalQueryParams(
                customObjectClassAssociationTypeCreateParams.additionalQueryParams
            )
            additionalHeaders(customObjectClassAssociationTypeCreateParams.additionalHeaders)
            additionalBodyProperties(
                customObjectClassAssociationTypeCreateParams.additionalBodyProperties
            )
        }

        fun customObjectClassId(customObjectClassId: String) = apply {
            this.customObjectClassId = customObjectClassId
        }

        fun model(model: AssociationTypeRequestRequest) = apply { this.model = model }

        /** Whether to include debug fields (such as log file links) in the response. */
        fun isDebugMode(isDebugMode: Boolean) = apply { this.isDebugMode = isDebugMode }

        /** Whether or not third-party updates should be run asynchronously. */
        fun runAsync(runAsync: Boolean) = apply { this.runAsync = runAsync }

        fun additionalQueryParams(additionalQueryParams: Map<String, List<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllQueryParams(additionalQueryParams)
        }

        fun putQueryParam(name: String, value: String) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putQueryParams(name: String, values: Iterable<String>) = apply {
            this.additionalQueryParams.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            additionalQueryParams.forEach(this::putQueryParams)
        }

        fun removeQueryParam(name: String) = apply {
            this.additionalQueryParams.put(name, mutableListOf())
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllHeaders(additionalHeaders)
        }

        fun putHeader(name: String, value: String) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.add(value)
        }

        fun putHeaders(name: String, values: Iterable<String>) = apply {
            this.additionalHeaders.getOrPut(name) { mutableListOf() }.addAll(values)
        }

        fun putAllHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            additionalHeaders.forEach(this::putHeaders)
        }

        fun removeHeader(name: String) = apply { this.additionalHeaders.put(name, mutableListOf()) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            this.additionalBodyProperties.clear()
            this.additionalBodyProperties.putAll(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            this.additionalBodyProperties.put(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                this.additionalBodyProperties.putAll(additionalBodyProperties)
            }

        fun build(): CustomObjectClassAssociationTypeCreateParams =
            CustomObjectClassAssociationTypeCreateParams(
                checkNotNull(customObjectClassId) {
                    "`customObjectClassId` is required but was not set"
                },
                checkNotNull(model) { "`model` is required but was not set" },
                isDebugMode,
                runAsync,
                additionalQueryParams.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalHeaders.mapValues { it.value.toUnmodifiable() }.toUnmodifiable(),
                additionalBodyProperties.toUnmodifiable(),
            )
    }

    @JsonDeserialize(builder = AssociationTypeRequestRequest.Builder::class)
    @NoAutoDetect
    class AssociationTypeRequestRequest
    private constructor(
        private val sourceObjectClass: ObjectClassDescriptionRequest?,
        private val targetObjectClasses: List<ObjectClassDescriptionRequest>?,
        private val remoteKeyName: String?,
        private val displayName: String?,
        private val cardinality: CardinalityEnum?,
        private val isRequired: Boolean?,
        private val additionalProperties: Map<String, JsonValue>,
    ) {

        private var hashCode: Int = 0

        @JsonProperty("source_object_class")
        fun sourceObjectClass(): ObjectClassDescriptionRequest? = sourceObjectClass

        @JsonProperty("target_object_classes")
        fun targetObjectClasses(): List<ObjectClassDescriptionRequest>? = targetObjectClasses

        @JsonProperty("remote_key_name") fun remoteKeyName(): String? = remoteKeyName

        @JsonProperty("display_name") fun displayName(): String? = displayName

        /**
         * - `ONE_TO_ONE` - ONE_TO_ONE
         * - `MANY_TO_ONE` - MANY_TO_ONE
         * - `MANY_TO_MANY` - MANY_TO_MANY
         * - `ONE_TO_MANY` - ONE_TO_MANY
         */
        @JsonProperty("cardinality") fun cardinality(): CardinalityEnum? = cardinality

        @JsonProperty("is_required") fun isRequired(): Boolean? = isRequired

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AssociationTypeRequestRequest &&
                this.sourceObjectClass == other.sourceObjectClass &&
                this.targetObjectClasses == other.targetObjectClasses &&
                this.remoteKeyName == other.remoteKeyName &&
                this.displayName == other.displayName &&
                this.cardinality == other.cardinality &&
                this.isRequired == other.isRequired &&
                this.additionalProperties == other.additionalProperties
        }

        override fun hashCode(): Int {
            if (hashCode == 0) {
                hashCode =
                    Objects.hash(
                        sourceObjectClass,
                        targetObjectClasses,
                        remoteKeyName,
                        displayName,
                        cardinality,
                        isRequired,
                        additionalProperties,
                    )
            }
            return hashCode
        }

        override fun toString() =
            "AssociationTypeRequestRequest{sourceObjectClass=$sourceObjectClass, targetObjectClasses=$targetObjectClasses, remoteKeyName=$remoteKeyName, displayName=$displayName, cardinality=$cardinality, isRequired=$isRequired, additionalProperties=$additionalProperties}"

        companion object {

            @JvmStatic fun builder() = Builder()
        }

        class Builder {

            private var sourceObjectClass: ObjectClassDescriptionRequest? = null
            private var targetObjectClasses: List<ObjectClassDescriptionRequest>? = null
            private var remoteKeyName: String? = null
            private var displayName: String? = null
            private var cardinality: CardinalityEnum? = null
            private var isRequired: Boolean? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(associationTypeRequestRequest: AssociationTypeRequestRequest) =
                apply {
                    this.sourceObjectClass = associationTypeRequestRequest.sourceObjectClass
                    this.targetObjectClasses = associationTypeRequestRequest.targetObjectClasses
                    this.remoteKeyName = associationTypeRequestRequest.remoteKeyName
                    this.displayName = associationTypeRequestRequest.displayName
                    this.cardinality = associationTypeRequestRequest.cardinality
                    this.isRequired = associationTypeRequestRequest.isRequired
                    additionalProperties(associationTypeRequestRequest.additionalProperties)
                }

            @JsonProperty("source_object_class")
            fun sourceObjectClass(sourceObjectClass: ObjectClassDescriptionRequest) = apply {
                this.sourceObjectClass = sourceObjectClass
            }

            @JsonProperty("target_object_classes")
            fun targetObjectClasses(targetObjectClasses: List<ObjectClassDescriptionRequest>) =
                apply {
                    this.targetObjectClasses = targetObjectClasses
                }

            @JsonProperty("remote_key_name")
            fun remoteKeyName(remoteKeyName: String) = apply { this.remoteKeyName = remoteKeyName }

            @JsonProperty("display_name")
            fun displayName(displayName: String) = apply { this.displayName = displayName }

            /**
             * - `ONE_TO_ONE` - ONE_TO_ONE
             * - `MANY_TO_ONE` - MANY_TO_ONE
             * - `MANY_TO_MANY` - MANY_TO_MANY
             * - `ONE_TO_MANY` - ONE_TO_MANY
             */
            @JsonProperty("cardinality")
            fun cardinality(cardinality: CardinalityEnum) = apply { this.cardinality = cardinality }

            @JsonProperty("is_required")
            fun isRequired(isRequired: Boolean) = apply { this.isRequired = isRequired }

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

            fun build(): AssociationTypeRequestRequest =
                AssociationTypeRequestRequest(
                    checkNotNull(sourceObjectClass) {
                        "`sourceObjectClass` is required but was not set"
                    },
                    checkNotNull(targetObjectClasses) {
                            "`targetObjectClasses` is required but was not set"
                        }
                        .toUnmodifiable(),
                    checkNotNull(remoteKeyName) { "`remoteKeyName` is required but was not set" },
                    displayName,
                    cardinality,
                    isRequired,
                    additionalProperties.toUnmodifiable(),
                )
        }

        @JsonDeserialize(builder = ObjectClassDescriptionRequest.Builder::class)
        @NoAutoDetect
        class ObjectClassDescriptionRequest
        private constructor(
            private val id: String?,
            private val originType: OriginTypeEnum?,
            private val additionalProperties: Map<String, JsonValue>,
        ) {

            private var hashCode: Int = 0

            @JsonProperty("id") fun id(): String? = id

            /**
             * - `CUSTOM_OBJECT` - CUSTOM_OBJECT
             * - `COMMON_MODEL` - COMMON_MODEL
             * - `REMOTE_ONLY_MODEL` - REMOTE_ONLY_MODEL
             */
            @JsonProperty("origin_type") fun originType(): OriginTypeEnum? = originType

            @JsonAnyGetter
            @ExcludeMissing
            fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

            fun toBuilder() = Builder().from(this)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ObjectClassDescriptionRequest &&
                    this.id == other.id &&
                    this.originType == other.originType &&
                    this.additionalProperties == other.additionalProperties
            }

            override fun hashCode(): Int {
                if (hashCode == 0) {
                    hashCode =
                        Objects.hash(
                            id,
                            originType,
                            additionalProperties,
                        )
                }
                return hashCode
            }

            override fun toString() =
                "ObjectClassDescriptionRequest{id=$id, originType=$originType, additionalProperties=$additionalProperties}"

            companion object {

                @JvmStatic fun builder() = Builder()
            }

            class Builder {

                private var id: String? = null
                private var originType: OriginTypeEnum? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(objectClassDescriptionRequest: ObjectClassDescriptionRequest) =
                    apply {
                        this.id = objectClassDescriptionRequest.id
                        this.originType = objectClassDescriptionRequest.originType
                        additionalProperties(objectClassDescriptionRequest.additionalProperties)
                    }

                @JsonProperty("id") fun id(id: String) = apply { this.id = id }

                /**
                 * - `CUSTOM_OBJECT` - CUSTOM_OBJECT
                 * - `COMMON_MODEL` - COMMON_MODEL
                 * - `REMOTE_ONLY_MODEL` - REMOTE_ONLY_MODEL
                 */
                @JsonProperty("origin_type")
                fun originType(originType: OriginTypeEnum) = apply { this.originType = originType }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    this.additionalProperties.putAll(additionalProperties)
                }

                @JsonAnySetter
                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    this.additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun build(): ObjectClassDescriptionRequest =
                    ObjectClassDescriptionRequest(
                        checkNotNull(id) { "`id` is required but was not set" },
                        checkNotNull(originType) { "`originType` is required but was not set" },
                        additionalProperties.toUnmodifiable(),
                    )
            }

            class OriginTypeEnum
            @JsonCreator
            private constructor(
                private val value: JsonField<String>,
            ) {

                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is OriginTypeEnum && this.value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()

                companion object {

                    @JvmField val CUSTOM_OBJECT = OriginTypeEnum(JsonField.of("CUSTOM_OBJECT"))

                    @JvmField val COMMON_MODEL = OriginTypeEnum(JsonField.of("COMMON_MODEL"))

                    @JvmField
                    val REMOTE_ONLY_MODEL = OriginTypeEnum(JsonField.of("REMOTE_ONLY_MODEL"))

                    @JvmStatic fun of(value: String) = OriginTypeEnum(JsonField.of(value))
                }

                enum class Known {
                    CUSTOM_OBJECT,
                    COMMON_MODEL,
                    REMOTE_ONLY_MODEL,
                }

                enum class Value {
                    CUSTOM_OBJECT,
                    COMMON_MODEL,
                    REMOTE_ONLY_MODEL,
                    _UNKNOWN,
                }

                fun value(): Value =
                    when (this) {
                        CUSTOM_OBJECT -> Value.CUSTOM_OBJECT
                        COMMON_MODEL -> Value.COMMON_MODEL
                        REMOTE_ONLY_MODEL -> Value.REMOTE_ONLY_MODEL
                        else -> Value._UNKNOWN
                    }

                fun known(): Known =
                    when (this) {
                        CUSTOM_OBJECT -> Known.CUSTOM_OBJECT
                        COMMON_MODEL -> Known.COMMON_MODEL
                        REMOTE_ONLY_MODEL -> Known.REMOTE_ONLY_MODEL
                        else -> throw MergeInvalidDataException("Unknown OriginTypeEnum: $value")
                    }

                fun asString(): String = _value().asStringOrThrow()
            }
        }

        class CardinalityEnum
        @JsonCreator
        private constructor(
            private val value: JsonField<String>,
        ) {

            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is CardinalityEnum && this.value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()

            companion object {

                @JvmField val ONE_TO_ONE = CardinalityEnum(JsonField.of("ONE_TO_ONE"))

                @JvmField val MANY_TO_ONE = CardinalityEnum(JsonField.of("MANY_TO_ONE"))

                @JvmField val MANY_TO_MANY = CardinalityEnum(JsonField.of("MANY_TO_MANY"))

                @JvmField val ONE_TO_MANY = CardinalityEnum(JsonField.of("ONE_TO_MANY"))

                @JvmStatic fun of(value: String) = CardinalityEnum(JsonField.of(value))
            }

            enum class Known {
                ONE_TO_ONE,
                MANY_TO_ONE,
                MANY_TO_MANY,
                ONE_TO_MANY,
            }

            enum class Value {
                ONE_TO_ONE,
                MANY_TO_ONE,
                MANY_TO_MANY,
                ONE_TO_MANY,
                _UNKNOWN,
            }

            fun value(): Value =
                when (this) {
                    ONE_TO_ONE -> Value.ONE_TO_ONE
                    MANY_TO_ONE -> Value.MANY_TO_ONE
                    MANY_TO_MANY -> Value.MANY_TO_MANY
                    ONE_TO_MANY -> Value.ONE_TO_MANY
                    else -> Value._UNKNOWN
                }

            fun known(): Known =
                when (this) {
                    ONE_TO_ONE -> Known.ONE_TO_ONE
                    MANY_TO_ONE -> Known.MANY_TO_ONE
                    MANY_TO_MANY -> Known.MANY_TO_MANY
                    ONE_TO_MANY -> Known.ONE_TO_MANY
                    else -> throw MergeInvalidDataException("Unknown CardinalityEnum: $value")
                }

            fun asString(): String = _value().asStringOrThrow()
        }
    }
}
