# Merge Java Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.merge/merge-java-client)](https://central.sonatype.com/artifact/dev.merge/merge-java-client) 
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Merge Java SDK provides convenient access to the Merge API from Java. 

## Documentation

API documentation is available at [here](https://docs.merge.dev/basics/authentication/).

## Installation

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'dev.merge:merge-java-client:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>dev.merge</groupId>
    <artifactId>merge-java-client</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Instantiation

```java
MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();
```

## Request Options
Every endpoint has an overloaded equivalent which takes [RequestOptions](./src/main/java/com/merge/api/core/RequestOptions.java)
that allow you to override the account token and api key.

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.ats.types.Candidate;
import com.merge.api.resources.ats.candidates.requests.CandidatesRetrieveRequest;
import com.merge.api.core.RequestOptions;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

Candidate candidate = mergeClient.ats().candidates().retrieve(
    "<CANDIDATE_UUID>", 
    CandidatesRetrieveRequest.builder()
            .includeRemoteData(true)
            .build(), 
    RequestOptions.builder()
        .accountToken("OVERRIDE_ACCOUNT_TOKEN")
        .build());
```

## Usage

Below are code snippets of how you can use the Java SDK.

### Create Link Token

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.ats.types.CategoriesEnum;
import com.merge.api.resources.ats.types.LinkToken;
import com.merge.api.resources.ats.linktoken.requests.EndUserDetailsRequest;

import java.util.List;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

LinkToken linkToken = mergeClient.ats().linkToken().create(EndUserDetailsRequest.builder()
    .endUserEmailAddress("john.smith@gmail.com")
    .endUserOrganizationName("acme")
    .endUserOriginId("1234")
    .categories(List.of(CategoriesEnum.ATS))
    .build());

System.out.println("Created link token", linkToken.getLinkToken())
```

### Get Employee

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.hris.employees.requests.EmployeesRetrieveRequest;
import com.merge.api.resources.hris.types.Employee;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

Employee employee = mergeClient.hris().employees().retrieve(
    "0958cbc6-6040-430a-848e-aafacbadf4ae",
    EmployeesRetrieveRequest.builder()
        .includeRemoteData(true)
        .build());
```

### Get Candidate

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.ats.types.Candidate;
import com.merge.api.resources.ats.candidates.requests.CandidatesRetrieveRequest;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

Candidate candidate = mergeClient.ats().candidates().retrieve(
    "521b18c2-4d01-4297-b451-19858d07c133", 
    CandidatesRetrieveRequest.builder()
        .includeRemoteData(true)
        .build());
```

### Filter Candidate

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.ats.candidates.requests.CandidatesListRequest;
import com.merge.api.resources.ats.types.PaginatedCandidateList;

import java.time.OffsetDateTime;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();
    
PaginatedCandidateList candidate = mergeClient.ats().candidates().list(
    CandidatesListRequest.builder()
        .createdAfter(OffsetDateTime.parse("2007-12-03T10:15:30+01:00"))
        .build());
```

### Get Contact

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.accounting.contacts.requests.ContactsRetrieveRequest;
import com.merge.api.resources.accounting.types.Contact;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

Contact contact = mergeClient.accounting().contacts().retrieve(
    "c640b80b-fac9-409f-aa19-1f9221aec445", 
    ContactsRetrieveRequest.builder()
        .includeRemoteData(true)
        .build());
```

### Create Ticket

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.ticketing.tickets.requests.TicketEndpointRequest;
import com.merge.api.resources.ticketing.types.TicketRequest;
import com.merge.api.resources.ticketing.types.TicketRequestStatus;
import com.merge.api.resources.ticketing.types.TicketStatusEnum;
import java.time.OffsetDateTime;

MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

mergeClient.ticketing().tickets().create(TicketEndpointRequest.builder()
    .model(TicketRequest.builder()
        .name("Please add more integrations")
        .creator("3fa85f64-5717-4562-b3fc-2c963f66afa6")
        .dueDate(OffsetDateTime.parse("2022-10-11T00:00:00Z"))
        .status(TicketRequestStatus.of(TicketStatusEnum.CLOSED))
        .build())
    .build());
```

### File Download

```java
import com.merge.api.MergeApiClient;
import com.merge.api.resources.filestorage.types.PaginatedFileList;
import com.merge.api.resources.filestorage.files.requests.FilesListRequest;
import com.merge.api.resources.filestorage.types.File;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

MergeApiClient mergeClient = MergeApiClient.builder()
        .accountToken("ACCOUNT_TOKEN")
        .apiKey("API_KEY")
        .build();

PaginatedFileList fileResponse = mergeClient.filestorage().files().list(FilesListRequest.builder()
        .name("<FILE_NAME>")
        .build());

File file = fileResponse.getResults().get().get(0);
String fileId = file.getId().get();
InputStream fileContents = mergeClient.filestorage().files().downloadRetrieve(fileId);
byte[] buffer = new byte[1024]; // Set the buffer size to your desired value
try (OutputStream outputStream = new FileOutputStream("/path/to/file")) {
    int bytesRead;
    while ((bytesRead = fileContents.read(buffer)) != -1) {
        outputStream.write(buffer, 0, bytesRead);
    }
} catch (IOException e) {
    throw new RuntimeException(e);
}   
```

## Staged Builders
The generated builders all follow the staged builder pattern. Read more [here](https://immutables.github.io/immutable.html#staged-builder). 

Staged builders only allow you to build the object once all required properties have been specified. For example, to build an `ApplicationEndpointRequest` the Merge SDK will require that you specify the `model` and `remoteUserId` properties. 

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!
