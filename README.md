# Merge Java Library

[![Maven Central](https://img.shields.io/maven-central/v/io.github.fern-api/merge)](https://central.sonatype.com/artifact/io.github.fern-api/merge) 
[![fern shield](https://img.shields.io/badge/%F0%9F%8C%BF-SDK%20generated%20by%20Fern-brightgreen)](https://github.com/fern-api/fern)

The Merge Java SDK provides convenient access to the Merge API from Java. 

## Documentation

API documentation is available at [here](https://docs.merge.dev/basics/authentication/).

## Install

### Gradle

Add the dependency in your `build.gradle`:

```groovy
dependencies {
    implementation 'io.github.fern-api:merge:0.x.x'
}
```

### Maven

Add the dependency in your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.fern-api</groupId>
    <artifactId>merge</artifactId>
    <version>0.x.x</version>
</dependency>
```

## Usage

Check out the [sample app](.sample-app/src/main/java/sample/App.java) which consumes this SDK!

```java
MergeApiClient mergeClient = MergeApiClient.builder()
    .accountToken("ACCOUNT_TOKEN")
    .apiKey("API_KEY")
    .build();

ApplicationResponse applicationResponse = mergeClient.ats().applications().create(ApplicationEndpointRequest.builder()
    .model(ApplicationRequest.builder()
        .appliedAt("10/12/2022")
        .build())
    .remoteUserId("remote-user-id")
    .build());

System.out.println("Received response: " + applicationResponse);
```

## Staged Builders
The generated builders all follow the staged builder pattern. Read more [here](https://immutables.github.io/immutable.html#staged-builder). 

Staged builders only allow you to build the object once all required properties have been specified. For example, to build an `ApplicationEndpointRequest` the Merge SDK will require that you specify the `model` and `remoteUserId` properties. 

## Beta status

This SDK is in beta, and there may be breaking changes between versions without a major version update. Therefore, we recommend pinning the package version to a specific version in your build.gradle file. This way, you can install the same version each time without breaking changes unless you are intentionally looking for the latest version.

## Contributing

While we value open-source contributions to this SDK, this library is generated programmatically. Additions made directly to this library would have to be moved over to our generation code, otherwise they would be overwritten upon the next generated release. Feel free to open a PR as a proof of concept, but know that we will not be able to merge it as-is. We suggest opening an issue first to discuss with us!

On the other hand, contributions to the README are always very welcome!