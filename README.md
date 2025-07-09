# Merge Java Library

[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-Built%20with%20Fern-brightgreen)](https://buildwithfern.com?utm_source=github&utm_medium=github&utm_campaign=readme&utm_source=https%3A%2F%2Fgithub.com%2Fmerge-api%2Fmerge-java-client)

The Merge Java library provides convenient access to the Merge API from Java.

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

Instantiate and use the client with the following:

```java
package com.example.usage;

import com.merge.api.MergeApiClient;
import com.merge.api.ats.types.ActivityEndpointRequest;
import com.merge.api.ats.types.ActivityRequest;

public class Example {
    public static void main(String[] args) {
        MergeApiClient client = MergeApiClient
            .builder()
            .apiKey("<token>")
            .build();

        client.ats().activities().create(
            ActivityEndpointRequest
                .builder()
                .model(
                    ActivityRequest
                        .builder()
                        .build()
                )
                .remoteUserId("remote_user_id")
                .build()
        );
    }
}
```

## Environments

This SDK allows you to configure different environments for API requests.

```java
import com.merge.api.MergeApiClient;
import com.merge.api.core.Environment;

MergeApiClient client = MergeApiClient
    .builder()
    .environment(Environment.Production)
    .build();
```

## Base Url

You can set a custom base URL when constructing the client.

```java
import com.merge.api.MergeApiClient;

MergeApiClient client = MergeApiClient
    .builder()
    .url("https://example.com")
    .build();
```

## Exception Handling

When the API returns a non-success status code (4xx or 5xx response), an API exception will be thrown.

```java
import com.merge.api.core.ApiError;

try {
    client.ats().activities().create(...);
} catch (ApiError e) {
    // Do something with the API exception...
}
```

## Advanced

### Custom Client

This SDK is built to work with any instance of `OkHttpClient`. By default, if no client is provided, the SDK will construct one. 
However, you can pass your own client like so:

```java
import com.merge.api.MergeApiClient;
import okhttp3.OkHttpClient;

OkHttpClient customClient = ...;

MergeApiClient client = MergeApiClient
    .builder()
    .httpClient(customClient)
    .build();
```

### Retries

The SDK is instrumented with automatic retries with exponential backoff. A request will be retried as long
as the request is deemed retryable and the number of retry attempts has not grown larger than the configured
retry limit (default: 2).

A request is deemed retryable when any of the following HTTP status codes is returned:

- [408](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/408) (Timeout)
- [429](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/429) (Too Many Requests)
- [5XX](https://developer.mozilla.org/en-US/docs/Web/HTTP/Status/500) (Internal Server Errors)

Use the `maxRetries` client option to configure this behavior.

```java
import com.merge.api.MergeApiClient;

MergeApiClient client = MergeApiClient
    .builder()
    .maxRetries(1)
    .build();
```

### Timeouts

The SDK defaults to a 60 second timeout. You can configure this with a timeout option at the client or request level.

```java
import com.merge.api.MergeApiClient;
import com.merge.api.core.RequestOptions;

// Client level
MergeApiClient client = MergeApiClient
    .builder()
    .timeout(10)
    .build();

// Request level
client.ats().activities().create(
    ...,
    RequestOptions
        .builder()
        .timeout(10)
        .build()
);
```

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically.
Additions made directly to this library would have to be moved over to our generation code,
otherwise they would be overwritten upon the next generated release. Feel free to open a PR as
a proof of concept, but know that we will not be able to merge it as-is. We suggest opening
an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome! 
