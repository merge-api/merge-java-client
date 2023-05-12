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
import java.time.OffsetDateTime
import java.util.Objects
import java.util.Optional

/**
 * # The AccountingPhoneNumber Object
 *
 * ### Description
 *
 * The `AccountingPhoneNumber` object is used to represent a contact's or company's phone number.
 *
 * ### Usage Example
 *
 * Fetch from the `GET CompanyInfo` endpoint and view the company's phone numbers.
 */
@JsonDeserialize(builder = PhoneNumber.Builder::class)
@NoAutoDetect
class PhoneNumber
private constructor(
    private val number: JsonField<String>,
    private val type: JsonField<String>,
    private val modifiedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: Map<String, JsonValue>,
) {

    private var validated: Boolean = false

    private var hashCode: Int = 0

    /** The phone number. */
    fun number(): Optional<String> = Optional.ofNullable(number.getNullable("number"))

    /** The phone number's type. */
    fun type(): Optional<String> = Optional.ofNullable(type.getNullable("type"))

    /** This is the datetime that this object was last updated by Merge */
    fun modifiedAt(): Optional<OffsetDateTime> =
        Optional.ofNullable(modifiedAt.getNullable("modified_at"))

    /** The phone number. */
    @JsonProperty("number") @ExcludeMissing fun _number() = number

    /** The phone number's type. */
    @JsonProperty("type") @ExcludeMissing fun _type() = type

    /** This is the datetime that this object was last updated by Merge */
    @JsonProperty("modified_at") @ExcludeMissing fun _modifiedAt() = modifiedAt

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

    fun validate() = apply {
        if (!validated) {
            number()
            type()
            modifiedAt()
            validated = true
        }
    }

    fun toBuilder() = Builder().from(this)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PhoneNumber &&
            this.number == other.number &&
            this.type == other.type &&
            this.modifiedAt == other.modifiedAt &&
            this.additionalProperties == other.additionalProperties
    }

    override fun hashCode(): Int {
        if (hashCode == 0) {
            hashCode =
                Objects.hash(
                    number,
                    type,
                    modifiedAt,
                    additionalProperties,
                )
        }
        return hashCode
    }

    override fun toString() =
        "PhoneNumber{number=$number, type=$type, modifiedAt=$modifiedAt, additionalProperties=$additionalProperties}"

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder {

        private var number: JsonField<String> = JsonMissing.of()
        private var type: JsonField<String> = JsonMissing.of()
        private var modifiedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(phoneNumber: PhoneNumber) = apply {
            this.number = phoneNumber.number
            this.type = phoneNumber.type
            this.modifiedAt = phoneNumber.modifiedAt
            additionalProperties(phoneNumber.additionalProperties)
        }

        /** The phone number. */
        fun number(number: String) = number(JsonField.of(number))

        /** The phone number. */
        @JsonProperty("number")
        @ExcludeMissing
        fun number(number: JsonField<String>) = apply { this.number = number }

        /** The phone number's type. */
        fun type(type: String) = type(JsonField.of(type))

        /** The phone number's type. */
        @JsonProperty("type")
        @ExcludeMissing
        fun type(type: JsonField<String>) = apply { this.type = type }

        /** This is the datetime that this object was last updated by Merge */
        fun modifiedAt(modifiedAt: OffsetDateTime) = modifiedAt(JsonField.of(modifiedAt))

        /** This is the datetime that this object was last updated by Merge */
        @JsonProperty("modified_at")
        @ExcludeMissing
        fun modifiedAt(modifiedAt: JsonField<OffsetDateTime>) = apply {
            this.modifiedAt = modifiedAt
        }

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

        fun build(): PhoneNumber =
            PhoneNumber(
                number,
                type,
                modifiedAt,
                additionalProperties.toUnmodifiable(),
            )
    }
}
