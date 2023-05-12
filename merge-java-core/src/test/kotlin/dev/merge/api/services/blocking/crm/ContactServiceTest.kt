package dev.merge.api.services.blocking.crm

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.crm.*
import dev.merge.api.models.crm.ContactListParams
import dev.merge.api.models.crm.ContactListRemoteFieldClassesParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
class ContactServiceTest {

    @Test
    fun callCreate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        val contactResponse =
            contactService.create(
                ContactCreateParams.builder()
                    .model(
                        ContactCreateParams.ContactRequest.builder()
                            .name("Gil Feig's Pickleball Team")
                            .isSupplier(true)
                            .isCustomer(true)
                            .emailAddress("pickleball@merge.dev")
                            .taxNumber("12-3456789")
                            .status(ContactCreateParams.ContactRequest.Status7d1Enum.ACTIVE)
                            .currency("USD")
                            .company("595c8f97-2ac4-45b7-b000-41bdf43240b5")
                            .addresses(listOf("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e"))
                            .phoneNumbers(
                                listOf(
                                    ContactCreateParams.ContactRequest.PhoneNumberRequest.builder()
                                        .value("+3198675309")
                                        .phoneNumberType(
                                            ContactCreateParams.ContactRequest.PhoneNumberRequest
                                                .PhoneNumberTypeEnum
                                                .HOME
                                        )
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
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
                                        .phoneNumber("+3198675309")
                                        .build()
                                )
                            )
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
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
                            .firstName("Gil")
                            .lastName("Feig")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .emailAddresses(
                                listOf(
                                    ContactCreateParams.ContactRequest.EmailAddressRequest.builder()
                                        .value("merge_is_hiring@merge.dev")
                                        .emailAddressType(
                                            ContactCreateParams.ContactRequest.EmailAddressRequest
                                                .EmailAddressTypeEnum
                                                .PERSONAL
                                        )
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
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
                                        .emailAddress("merge_is_hiring@merge.dev")
                                        .build()
                                )
                            )
                            .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .email("hello@merge.dev")
                            .phone("+13785579223")
                            .state("NY")
                            .country(Country.AF)
                            .postalCode("string")
                            .build()
                    )
                    .isDebugMode(true)
                    .runAsync(true)
                    .build()
            )
        println(contactResponse)
        contactResponse.validate()
    }

    @Test
    fun callRetrieve() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        val contact =
            contactService.retrieve(
                ContactRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .expand(listOf(ContactRetrieveParams.Expand.ACCOUNT))
                    .includeRemoteData(true)
                    .includeRemoteFields(true)
                    .build()
            )
        println(contact)
        contact.validate()
    }

    @Test
    fun callUpdate() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        val contactResponse =
            contactService.update(
                ContactUpdateParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .model(
                        ContactUpdateParams.PatchedContactRequest.builder()
                            .firstName("Gil")
                            .lastName("Feig")
                            .account("0958cbc6-6040-430a-848e-aafacbadf4ae")
                            .addresses(
                                listOf(
                                    ContactUpdateParams.PatchedContactRequest.AddressRequest
                                        .builder()
                                        .street1("50 Bowling Green Dr")
                                        .street2("Golden Gate Park")
                                        .city("San Francisco")
                                        .state("CA")
                                        .postalCode("94122")
                                        .country(Country.AF)
                                        .addressType(
                                            ContactUpdateParams.PatchedContactRequest.AddressRequest
                                                .AddressTypeEnum
                                                .BILLING
                                        )
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
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
                            )
                            .emailAddresses(
                                listOf(
                                    ContactUpdateParams.PatchedContactRequest.EmailAddressRequest
                                        .builder()
                                        .value("merge_is_hiring@merge.dev")
                                        .emailAddressType(
                                            ContactUpdateParams.PatchedContactRequest
                                                .EmailAddressRequest
                                                .EmailAddressTypeEnum
                                                .PERSONAL
                                        )
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
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
                                        .emailAddress("merge_is_hiring@merge.dev")
                                        .build()
                                )
                            )
                            .phoneNumbers(
                                listOf(
                                    ContactUpdateParams.PatchedContactRequest.PhoneNumberRequest
                                        .builder()
                                        .value("+3198675309")
                                        .phoneNumberType(
                                            ContactUpdateParams.PatchedContactRequest
                                                .PhoneNumberRequest
                                                .PhoneNumberTypeEnum
                                                .HOME
                                        )
                                        .integrationParams(
                                            JsonValue.from(
                                                mapOf(
                                                    "unique_integration_field" to
                                                        "unique_integration_field_value"
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
                                        .phoneNumber("+3198675309")
                                        .build()
                                )
                            )
                            .lastActivityAt(OffsetDateTime.parse("2022-02-10T00:00:00Z"))
                            .integrationParams(
                                JsonValue.from(
                                    mapOf(
                                        "unique_integration_field" to
                                            "unique_integration_field_value"
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
            )
        println(contactResponse)
        contactResponse.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        val paginatedContactList = contactService.list(ContactListParams.builder().build())
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }

    @Test
    fun callIgnoreRow() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        contactService.ignoreRow(
            ContactIgnoreRowParams.builder()
                .modelId("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                .reason(ContactIgnoreRowParams.ReasonEnum.GENERAL_CUSTOMER_REQUEST)
                .message("deletion request by user id 51903790-7dfe-4053-8d63-5a10cc4ffd39")
                .build()
        )
    }

    @Test
    fun callListRemoteFieldClasses() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.crm().contacts()
        val paginatedRemoteFieldClassList =
            contactService.listRemoteFieldClasses(
                ContactListRemoteFieldClassesParams.builder().build()
            )
        println(paginatedRemoteFieldClassList)
        paginatedRemoteFieldClassList.results().forEach { it.validate() }
    }
}
