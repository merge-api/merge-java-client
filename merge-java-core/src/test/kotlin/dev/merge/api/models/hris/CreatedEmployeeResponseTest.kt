package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CreatedEmployeeResponseTest {

    @Test
    fun createCreatedEmployeeResponse() {
        val createdEmployeeResponse =
            CreatedEmployeeResponse.builder()
                .model(
                    Employee.builder()
                        .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                        .remoteId("19202938")
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
                        .gender(Employee.GenderEnum.MALE)
                        .ethnicity(Employee.EthnicityEnum.AMERICAN_INDIAN_OR_ALASKA_NATIVE)
                        .maritalStatus(Employee.MaritalStatusEnum.SINGLE)
                        .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                        .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                        .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                        .remoteCreatedAt(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                        .employmentStatus(Employee.EmploymentStatusEnum.ACTIVE)
                        .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                        .avatar("http://alturl.com/h2h8m")
                        .customFields(JsonString.of("abc"))
                        .remoteWasDeleted(true)
                        .fieldMappings(
                            JsonValue.from(
                                mapOf(
                                    "organization_defined_targets" to
                                        mapOf("custom_key" to "custom_value"),
                                    "linked_account_defined_targets" to
                                        mapOf("custom_key" to "custom_value")
                                )
                            )
                        )
                        .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                        .remoteData(
                            listOf(
                                RemoteData.builder()
                                    .path("string")
                                    .data(JsonString.of("abc"))
                                    .build()
                            )
                        )
                        .build()
                )
                .warnings(
                    listOf(
                        ValidationWarning.builder()
                            .source(
                                ValidationWarning.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Unrecognized Field")
                            .detail("An unrecognized field, age, was passed in with request data.")
                            .problemType("UNRECOGNIZED_FIELD")
                            .build()
                    )
                )
                .errors(
                    listOf(
                        ValidationError.builder()
                            .source(
                                ValidationError.ValidationProblemSource.builder()
                                    .pointer("string")
                                    .build()
                            )
                            .title("Missing Required Field")
                            .detail("custom_fields is a required field on model.")
                            .problemType("MISSING_REQUIRED_FIELD")
                            .build()
                    )
                )
                .logs(
                    listOf(
                        DebugLog.builder()
                            .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                            .dashboardView(
                                "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                            )
                            .logSummary(
                                DebugLog.DebugModelLogSummary.builder()
                                    .url("https://harvest.greenhouse.io/v1/candidates/")
                                    .method("POST")
                                    .statusCode(123L)
                                    .build()
                            )
                            .build()
                    )
                )
                .build()
        assertThat(createdEmployeeResponse).isNotNull
        assertThat(createdEmployeeResponse.model())
            .isEqualTo(
                Employee.builder()
                    .id("0958cbc6-6040-430a-848e-aafacbadf4ae")
                    .remoteId("19202938")
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
                    .gender(Employee.GenderEnum.MALE)
                    .ethnicity(Employee.EthnicityEnum.AMERICAN_INDIAN_OR_ALASKA_NATIVE)
                    .maritalStatus(Employee.MaritalStatusEnum.SINGLE)
                    .dateOfBirth(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
                    .hireDate(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
                    .startDate(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                    .remoteCreatedAt(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
                    .employmentStatus(Employee.EmploymentStatusEnum.ACTIVE)
                    .terminationDate(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
                    .avatar("http://alturl.com/h2h8m")
                    .customFields(JsonString.of("abc"))
                    .remoteWasDeleted(true)
                    .fieldMappings(
                        JsonValue.from(
                            mapOf(
                                "organization_defined_targets" to
                                    mapOf("custom_key" to "custom_value"),
                                "linked_account_defined_targets" to
                                    mapOf("custom_key" to "custom_value")
                            )
                        )
                    )
                    .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                    .remoteData(
                        listOf(
                            RemoteData.builder().path("string").data(JsonString.of("abc")).build()
                        )
                    )
                    .build()
            )
        assertThat(createdEmployeeResponse.warnings())
            .containsExactly(
                ValidationWarning.builder()
                    .source(
                        ValidationWarning.ValidationProblemSource.builder()
                            .pointer("string")
                            .build()
                    )
                    .title("Unrecognized Field")
                    .detail("An unrecognized field, age, was passed in with request data.")
                    .problemType("UNRECOGNIZED_FIELD")
                    .build()
            )
        assertThat(createdEmployeeResponse.errors())
            .containsExactly(
                ValidationError.builder()
                    .source(
                        ValidationError.ValidationProblemSource.builder().pointer("string").build()
                    )
                    .title("Missing Required Field")
                    .detail("custom_fields is a required field on model.")
                    .problemType("MISSING_REQUIRED_FIELD")
                    .build()
            )
        assertThat(createdEmployeeResponse.logs().get())
            .containsExactly(
                DebugLog.builder()
                    .logId("99433219-8017-4acd-bb3c-ceb23d663832")
                    .dashboardView(
                        "https://app.merge.dev/logs/99433219-8017-4acd-bb3c-ceb23d663832"
                    )
                    .logSummary(
                        DebugLog.DebugModelLogSummary.builder()
                            .url("https://harvest.greenhouse.io/v1/candidates/")
                            .method("POST")
                            .statusCode(123L)
                            .build()
                    )
                    .build()
            )
    }
}
