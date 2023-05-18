package dev.merge.api.models.hris

import dev.merge.api.core.JsonString
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EmployeeTest {

    @Test
    fun createEmployee() {
        val employee =
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
                            "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                            "linked_account_defined_targets" to
                                mapOf("custom_key" to "custom_value")
                        )
                    )
                )
                .modifiedAt(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
                .remoteData(
                    listOf(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
                )
                .build()
        assertThat(employee).isNotNull
        assertThat(employee.id()).contains("0958cbc6-6040-430a-848e-aafacbadf4ae")
        assertThat(employee.remoteId()).contains("19202938")
        assertThat(employee.employeeNumber()).contains("2")
        assertThat(employee.company()).contains("8d9fd929-436c-4fd4-a48b-0c61f68d6178")
        assertThat(employee.firstName()).contains("Greg")
        assertThat(employee.lastName()).contains("Hirsch")
        assertThat(employee.displayFullName()).contains("Cousin Greg Hirsch")
        assertThat(employee.username()).contains("cousingreg")
        assertThat(employee.groups().get()).containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(employee.workEmail()).contains("greg@merge.dev")
        assertThat(employee.personalEmail()).contains("greg@gmail.com")
        assertThat(employee.mobilePhoneNumber()).contains("+1234567890")
        assertThat(employee.employments().get())
            .containsExactly("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
        assertThat(employee.homeLocation()).contains("d2f972d0-2526-434b-9409-4c3b468e08f0")
        assertThat(employee.workLocation()).contains("9efbc633-3387-4306-aa55-e2c635e6bb4f")
        assertThat(employee.manager()).contains("0048ea5b-911e-4dff-9364-92070dea62ff")
        assertThat(employee.team()).contains("249c9faa-3045-4a31-953b-8f22d3613301")
        assertThat(employee.payGroup()).contains("ad1264e2-39be-4787-b749-f1aade9e3405")
        assertThat(employee.ssn()).contains("1234567890")
        assertThat(employee.gender()).contains(Employee.GenderEnum.MALE)
        assertThat(employee.ethnicity())
            .contains(Employee.EthnicityEnum.AMERICAN_INDIAN_OR_ALASKA_NATIVE)
        assertThat(employee.maritalStatus()).contains(Employee.MaritalStatusEnum.SINGLE)
        assertThat(employee.dateOfBirth()).contains(OffsetDateTime.parse("1990-11-10T00:00:00Z"))
        assertThat(employee.hireDate()).contains(OffsetDateTime.parse("2020-10-10T00:00:00Z"))
        assertThat(employee.startDate()).contains(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
        assertThat(employee.remoteCreatedAt())
            .contains(OffsetDateTime.parse("2020-10-11T00:00:00Z"))
        assertThat(employee.employmentStatus()).contains(Employee.EmploymentStatusEnum.ACTIVE)
        assertThat(employee.terminationDate())
            .contains(OffsetDateTime.parse("2021-10-12T00:00:00Z"))
        assertThat(employee.avatar()).contains("http://alturl.com/h2h8m")
        assertThat(employee._customFields()).isEqualTo(JsonString.of("abc"))
        assertThat(employee.remoteWasDeleted()).contains(true)
        assertThat(employee._fieldMappings())
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "organization_defined_targets" to mapOf("custom_key" to "custom_value"),
                        "linked_account_defined_targets" to mapOf("custom_key" to "custom_value")
                    )
                )
            )
        assertThat(employee.modifiedAt()).contains(OffsetDateTime.parse("2021-10-16T00:00:00Z"))
        assertThat(employee.remoteData().get())
            .containsExactly(RemoteData.builder().path("string").data(JsonString.of("abc")).build())
    }
}
