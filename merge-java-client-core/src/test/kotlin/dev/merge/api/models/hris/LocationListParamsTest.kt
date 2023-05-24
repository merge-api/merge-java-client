package dev.merge.api.models.hris

import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LocationListParamsTest {

    @Test
    fun createLocationListParams() {
        LocationListParams.builder()
            .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .cursor("string")
            .includeDeletedData(true)
            .includeRemoteData(true)
            .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .pageSize(123L)
            .remoteFields(LocationListParams.RemoteFields.LOCATION_TYPE)
            .remoteId("string")
            .showEnumOrigins(LocationListParams.ShowEnumOrigins.LOCATION_TYPE)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            LocationListParams.builder()
                .createdAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .createdBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .cursor("string")
                .includeDeletedData(true)
                .includeRemoteData(true)
                .modifiedAfter(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .modifiedBefore(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .pageSize(123L)
                .remoteFields(LocationListParams.RemoteFields.LOCATION_TYPE)
                .remoteId("string")
                .showEnumOrigins(LocationListParams.ShowEnumOrigins.LOCATION_TYPE)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("created_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("created_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("cursor", listOf("string"))
        expected.put("include_deleted_data", listOf("true"))
        expected.put("include_remote_data", listOf("true"))
        expected.put("modified_after", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("modified_before", listOf("2019-12-27T18:11:19.117Z"))
        expected.put("page_size", listOf("123"))
        expected.put(
            "remote_fields",
            listOf(LocationListParams.RemoteFields.LOCATION_TYPE.toString())
        )
        expected.put("remote_id", listOf("string"))
        expected.put(
            "show_enum_origins",
            listOf(LocationListParams.ShowEnumOrigins.LOCATION_TYPE.toString())
        )
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params = LocationListParams.builder().build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }
}
