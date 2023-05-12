package dev.merge.api.models.hris

import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmployeeCreateParamsTest {

    @Test
    fun createEmployeeCreateParams() {
        EmployeeCreateParams.builder()
            .model(
                EmployeeCreateParams.EmployeeRequest.builder()
                    .employeeNumber("2")
                    .company("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                    .firstName("Greg")
                    .lastName("Hirsch")
                    .displayFullName("Cousin Greg Hirsch")
                    .username("cousingreg")
                    .groups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .workEmail("greg@merge.dev")
                    .personalEmail("greg@gmail.com")
                    .mobilePhoneNumber("+1234567890")
                    .employments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .homeLocation("d2f972d0-2526-434b-9409-4c3b468e08f0")
                    .workLocation("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                    .manager("0048ea5b-911e-4dff-9364-92070dea62ff")
                    .team("249c9faa-3045-4a31-953b-8f22d3613301")
                    .payGroup("ad1264e2-39be-4787-b749-f1aade9e3405")
                    .ssn("1234567890")
                    .gender(EmployeeCreateParams.EmployeeRequest.GenderEnum.MALE)
                    .ethnicity(
                        EmployeeCreateParams.EmployeeRequest.EthnicityEnum
                            .AMERICAN_INDIAN_OR_ALASKA_NATIVE
                    )
                    .maritalStatus(EmployeeCreateParams.EmployeeRequest.MaritalStatusEnum.SINGLE)
                    .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                    .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                    .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                    .employmentStatus(
                        EmployeeCreateParams.EmployeeRequest.EmploymentStatusEnum.ACTIVE
                    )
                    .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                    .avatar("http://alturl.com/h2h8m")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
            .isDebugMode(true)
            .runAsync(true)
            .build()
    }

    @Test
    fun getQueryParams() {
        val params =
            EmployeeCreateParams.builder()
                .model(
                    EmployeeCreateParams.EmployeeRequest.builder()
                        .employeeNumber("2")
                        .company("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                        .firstName("Greg")
                        .lastName("Hirsch")
                        .displayFullName("Cousin Greg Hirsch")
                        .username("cousingreg")
                        .groups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .workEmail("greg@merge.dev")
                        .personalEmail("greg@gmail.com")
                        .mobilePhoneNumber("+1234567890")
                        .employments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .homeLocation("d2f972d0-2526-434b-9409-4c3b468e08f0")
                        .workLocation("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                        .manager("0048ea5b-911e-4dff-9364-92070dea62ff")
                        .team("249c9faa-3045-4a31-953b-8f22d3613301")
                        .payGroup("ad1264e2-39be-4787-b749-f1aade9e3405")
                        .ssn("1234567890")
                        .gender(EmployeeCreateParams.EmployeeRequest.GenderEnum.MALE)
                        .ethnicity(
                            EmployeeCreateParams.EmployeeRequest.EthnicityEnum
                                .AMERICAN_INDIAN_OR_ALASKA_NATIVE
                        )
                        .maritalStatus(
                            EmployeeCreateParams.EmployeeRequest.MaritalStatusEnum.SINGLE
                        )
                        .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                        .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                        .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                        .employmentStatus(
                            EmployeeCreateParams.EmployeeRequest.EmploymentStatusEnum.ACTIVE
                        )
                        .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                        .avatar("http://alturl.com/h2h8m")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val expected = mutableMapOf<String, List<String>>()
        expected.put("is_debug_mode", listOf("true"))
        expected.put("run_async", listOf("true"))
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getQueryParamsWithoutOptionalFields() {
        val params =
            EmployeeCreateParams.builder()
                .model(EmployeeCreateParams.EmployeeRequest.builder().build())
                .build()
        val expected = mutableMapOf<String, List<String>>()
        assertThat(params.getQueryParams()).isEqualTo(expected)
    }

    @Test
    fun getBody() {
        val params =
            EmployeeCreateParams.builder()
                .model(
                    EmployeeCreateParams.EmployeeRequest.builder()
                        .employeeNumber("2")
                        .company("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                        .firstName("Greg")
                        .lastName("Hirsch")
                        .displayFullName("Cousin Greg Hirsch")
                        .username("cousingreg")
                        .groups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .workEmail("greg@merge.dev")
                        .personalEmail("greg@gmail.com")
                        .mobilePhoneNumber("+1234567890")
                        .employments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                        .homeLocation("d2f972d0-2526-434b-9409-4c3b468e08f0")
                        .workLocation("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                        .manager("0048ea5b-911e-4dff-9364-92070dea62ff")
                        .team("249c9faa-3045-4a31-953b-8f22d3613301")
                        .payGroup("ad1264e2-39be-4787-b749-f1aade9e3405")
                        .ssn("1234567890")
                        .gender(EmployeeCreateParams.EmployeeRequest.GenderEnum.MALE)
                        .ethnicity(
                            EmployeeCreateParams.EmployeeRequest.EthnicityEnum
                                .AMERICAN_INDIAN_OR_ALASKA_NATIVE
                        )
                        .maritalStatus(
                            EmployeeCreateParams.EmployeeRequest.MaritalStatusEnum.SINGLE
                        )
                        .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                        .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                        .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                        .employmentStatus(
                            EmployeeCreateParams.EmployeeRequest.EmploymentStatusEnum.ACTIVE
                        )
                        .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                        .avatar("http://alturl.com/h2h8m")
                        .integrationParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_integration_field" to "unique_integration_field_value"
                                )
                            )
                        )
                        .linkedAccountParams(
                            JsonValue.from(
                                mapOf(
                                    "unique_linked_account_field" to
                                        "unique_linked_account_field_value"
                                )
                            )
                        )
                        .build()
                )
                .isDebugMode(true)
                .runAsync(true)
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model())
            .isEqualTo(
                EmployeeCreateParams.EmployeeRequest.builder()
                    .employeeNumber("2")
                    .company("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
                    .firstName("Greg")
                    .lastName("Hirsch")
                    .displayFullName("Cousin Greg Hirsch")
                    .username("cousingreg")
                    .groups(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .workEmail("greg@merge.dev")
                    .personalEmail("greg@gmail.com")
                    .mobilePhoneNumber("+1234567890")
                    .employments(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                    .homeLocation("d2f972d0-2526-434b-9409-4c3b468e08f0")
                    .workLocation("9efbc633-3387-4306-aa55-e2c635e6bb4f")
                    .manager("0048ea5b-911e-4dff-9364-92070dea62ff")
                    .team("249c9faa-3045-4a31-953b-8f22d3613301")
                    .payGroup("ad1264e2-39be-4787-b749-f1aade9e3405")
                    .ssn("1234567890")
                    .gender(EmployeeCreateParams.EmployeeRequest.GenderEnum.MALE)
                    .ethnicity(
                        EmployeeCreateParams.EmployeeRequest.EthnicityEnum
                            .AMERICAN_INDIAN_OR_ALASKA_NATIVE
                    )
                    .maritalStatus(EmployeeCreateParams.EmployeeRequest.MaritalStatusEnum.SINGLE)
                    .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                    .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                    .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                    .employmentStatus(
                        EmployeeCreateParams.EmployeeRequest.EmploymentStatusEnum.ACTIVE
                    )
                    .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                    .avatar("http://alturl.com/h2h8m")
                    .integrationParams(
                        JsonValue.from(
                            mapOf("unique_integration_field" to "unique_integration_field_value")
                        )
                    )
                    .linkedAccountParams(
                        JsonValue.from(
                            mapOf(
                                "unique_linked_account_field" to "unique_linked_account_field_value"
                            )
                        )
                    )
                    .build()
            )
    }

    @Test
    fun getBodyWithoutOptionalFields() {
        val params =
            EmployeeCreateParams.builder()
                .model(EmployeeCreateParams.EmployeeRequest.builder().build())
                .build()
        val body = params.getBody()
        assertThat(body).isNotNull
        assertThat(body.model()).isEqualTo(EmployeeCreateParams.EmployeeRequest.builder().build())
    }
}
