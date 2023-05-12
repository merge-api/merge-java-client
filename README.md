# Merge Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/dev.merge.api/merge-java)](https://central.sonatype.com/artifact/dev.merge.api/merge-java/0.0.1)

The Merge Java SDK provides convenient access to the Merge REST API from applications written in Java. It includes helper classes with helpful types and documentation for every request and response property.

This package is currently in beta (pre-v1.0.0). We expect some breaking changes to rarely-used areas of the SDK, and appreciate your [feedback](mailto:hello@merge.dev).

The Merge Java SDK is similar to the Merge Kotlin SDK but with minor differences that make it more ergonomic for use in Java, such as `Optional` instead of nullable values, `Stream` instead of `Sequence`, and `CompletableFuture` instead of suspend functions.

## Documentation

The API documentation can be found [here](https://docs.merge.dev).

---

## Getting started

### Install dependencies

#### Gradle

```kotlin
implementation("dev.merge.api:merge-java:0.0.1")
```

#### Maven

```xml
<dependency>
    <groupId>dev.merge.api</groupId>
    <artifactId>merge-java</artifactId>
    <version>0.0.1</version>
</dependency>
```

### Configure the client

Use `MergeOkHttpClient.builder()` to configure the client. At a minimum you need to set `.apiKey()`:

```java
import dev.merge.api.client.MergeClient;
import dev.merge.api.client.okhttp.MergeOkHttpClient;

MergeClient client = MergeOkHttpClient.builder()
    .apiKey("<your API Key>")
    .build();
```

Alternately, set the environment variable `MERGE_API_KEY` and use `MergeOkHttpClient.fromEnv()`:

```java
MergeClient client = MergeOkHttpClient.fromEnv();

// Note: you can also call fromEnv() from the client builder, for example if you need to set additional properties
MergeClient client = MergeOkHttpClient.builder()
    .fromEnv()
    // ... set properties on the builder
    .build();
```

Read the documentation for more configuration options.

---

### Example: creating a resource

To create a new hris account detail, first use the `AccountDetailRetrieveParams` builder to specify attributes,
then pass that to the `retrieve` method of the `accountDetails` service.

```java
import dev.merge.api.models.AccountDetail;
import dev.merge.api.models.AccountDetailRetrieveParams;

AccountDetailRetrieveParams params = AccountDetailRetrieveParams.builder().build();
AccountDetail hrisAccountDetail = client.accountDetails().retrieve(params);
```

### Example: listing resources

The Merge API provides a `list` method to get a paginated list of hris sync status.
You can retrieve the first page by:

```java
import dev.merge.api.models.Page;
import dev.merge.api.models.SyncStatus;

SyncStatusListPage page = client.syncStatus().list();
for (SyncStatus hrisSyncStatus : page.results()) {
    System.out.println(hrisSyncStatus);
}
```

See [Pagination](#pagination) below for more information on transparently working with lists of objects without worrying about fetching each page.

---

## Requests

### Parameters and bodies

To make a request to the Merge API, you generally build an instance of the appropriate `Params` class.

In [Example: creating a resource](#example-creating-a-resource) above, we used the `AccountDetailRetrieveParams.builder()` to pass to
the `retrieve` method of the `accountDetails` service.

Sometimes, the API may support other properties that are not yet supported in the Java SDK types. In that case,
you can attach them using the `putAdditionalProperty` method.

```java
AccountDetailRetrieveParams params = AccountDetailRetrieveParams.builder()
    // ... normal properties
    .putAdditionalProperty("secret_param", "4242")
    .build();
```

## Responses

### Response validation

When receiving a response, the Merge Java SDK will deserialize it into instances of the typed model classes. In rare cases, the API may return a response property that doesn't match the expected Java type. If you directly access the mistaken property, the SDK will throw an unchecked `MergeInvalidDataException` at runtime. If you would prefer to check in advance that that response is completely well-typed, call `.validate()` on the returned model.

```java
AccountDetail hrisAccountDetail = client.accountDetails().retrieve().validate();
```

### Response properties as JSON

In rare cases, you may want to access the underlying JSON value for a response property rather than using the typed version provided by
this SDK. Each model property has a corresponding JSON version, with an underscore before the method name, which returns a `JsonField` value.

### Additional model properties

Sometimes, the server response may include additional properties that are not yet available in this library's types. You can access them using the model's `_additionalProperties` method:

```java
JsonValue secret = hrisAccountDetail._additionalProperties().get("secret_field");
```

---

## Pagination

For methods that return a paginated list of results, this library provides convenient ways access
the results either one page at a time, or item-by-item across all pages.

### Auto-pagination

To iterate through all results across all pages, you can use `autoPager`,
which automatically handles fetching more pages for you:

### Synchronous

```java
// As an Iterable:
SyncStatusListPage page = client.syncStatus().list(params);
for (SyncStatus hrisSyncStatus : page.autoPager()) {
    System.out.println(hrisSyncStatus);
};

// As a Stream:
client.syncStatus().list(params).autoPager().stream()
    .limit(50)
    .forEach(hrisSyncStatus -> System.out.println(hrisSyncStatus));
```

### Asynchronous

```java
// Using forEach, which returns CompletableFuture<Void>:
asyncClient.syncStatus().list(params).autoPager()
    .forEach(hrisSyncStatus -> System.out.println(hrisSyncStatus), executor);
```

### Manual pagination

If none of the above helpers meet your needs, you can also manually request pages one-by-one.
A page of results has a `data()` method to fetch the list of objects, as well as top-level
`response` and other methods to fetch top-level data about the page. It also has methods
`hasNextPage`, `getNextPage`, and `getNextPageParams` methods to help with pagination.

```java
SyncStatusListPage page = client.syncStatus().list(params);
while (page != null) {
    for (SyncStatus hrisSyncStatus : page.results()) {
        System.out.println(hrisSyncStatus);
    }

    page = page.getNextPage().orElse(null);
}
```

---

## Error handling

This library throws exceptions in a single hierarchy for easy handling:

- **`MergeException`** - Base exception for all exceptions

  - **`MergeServiceException`** - HTTP errors with a well-formed response body we were able to parse. The exception message and the `.debuggingRequestId()` will be set by the server.

    | 400    | BadRequestException           |
    | ------ | ----------------------------- |
    | 401    | AuthenticationException       |
    | 403    | PermissionDeniedException     |
    | 404    | NotFoundException             |
    | 422    | UnprocessableEntityException  |
    | 429    | RateLimitException            |
    | 5xx    | InternalServerException       |
    | others | UnexpectedStatusCodeException |

  - **`MergeIoException`** - I/O networking errors
  - **`MergeInvalidDataException`** - any other exceptions on the client side, e.g.:
    - We failed to serialize the request body
    - We failed to parse the response body (has access to response code and body)

## Network options

### Retries

Requests that experience certain errors are automatically retried 2 times by default, with a short exponential backoff. Connection errors (for example, due to a network connectivity problem), 409 Conflict, 429 Rate Limit, and >=500 Internal errors will all be retried by default.
You can provide a `maxRetries` on the client builder to configure this:

```java
MergeClient client = MergeOkHttpClient.builder()
    .fromEnv()
    .maxRetries(4)
    .build();
```

### Timeouts

Requests time out after 60 seconds by default. You can configure this on the client builder:

```java
MergeClient client = MergeOkHttpClient.builder()
    .fromEnv()
    .timeout(Duration.ofSeconds(30))
    .build();
```

### Proxies

Requests can be routed through a proxy. You can configure this on the client builder:

```java
MergeClient client = MergeOkHttpClient.builder()
    .fromEnv()
    .proxy(new Proxy(
        Type.HTTP,
        new InetSocketAddress("proxy.com", 8080)
    ))
    .build();
```