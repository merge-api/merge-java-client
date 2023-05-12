package dev.merge.api.services.blocking.marketing

import dev.merge.api.TestServerExtension
import dev.merge.api.client.okhttp.MergeOkHttpClient
import dev.merge.api.core.JsonValue
import dev.merge.api.models.*
import dev.merge.api.models.marketing.*
import dev.merge.api.models.marketing.ContactListParams
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
        val contactService = client.marketing().contacts()
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
        val contactService = client.marketing().contacts()
        val contact =
            contactService.retrieve(
                ContactRetrieveParams.builder()
                    .id("182bd5e5-6e1a-4fe4-a799-aa6d9a6ab26e")
                    .includeRemoteData(true)
                    .build()
            )
        println(contact)
        contact.validate()
    }

    @Test
    fun callList() {
        val client =
            MergeOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("test-api-key")
                .accountToken("<account-token>")
                .build()
        val contactService = client.marketing().contacts()
        val paginatedContactList = contactService.list(ContactListParams.builder().build())
        println(paginatedContactList)
        paginatedContactList.results().forEach { it.validate() }
    }
}
